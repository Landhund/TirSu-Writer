BeforeAll {
    Import-Module -Name ".\" -Force

    function Test-String($Regex, $String) {
        return $String -match $Regex
    }
}

BeforeDiscovery {
    $SymbolTableKeys = $SymbolTable.GetEnumerator().Name
    $SymbolTableKeys | Out-Null # Only here so VSCode doesn't freak out

    $ValidElementNames = @()
    $SymbolElementsKeys = $SymbolElements.GetEnumerator().Name
    foreach ($Key in $SymbolElementsKeys) {
        $ValidElementNames += $SymbolElements[$Key].id
    }

    $ValidPositions = "Top", "SubTop", "Middle", "SubMiddle"
    $ValidPositions | Out-Null # Only here so VSCode doesn't freak out
    $ValidLines = "FullLine", "MidLine", "SubLine"
    $ValidLines | Out-Null # Only here so VSCode doesn't freak out
    $NamePositionSeparator = ":"
    $NamePositionSeparator | Out-Null # Only here so VSCode doesn't freak out

}

Describe "TirsuSymbolLibrary Test" {
    Context "SymbolTable Tests" {
        It "Key <_> is valid" -TestCases $SymbolTableKeys {
            Test-String -Regex "^([A-Z]){1,2}$" -String $_ | Should -Be $true
        }

        It "Symbol <_> has valid Structure" -TestCases $SymbolTableKeys {
            $StructureValidity = $true
            $Elements = $SymbolTable[$_]
            foreach ($Element in $Elements) {
                if (Test-String -Regex "^([A-z])+:([A-z])+$" -String $Element) {
                    $Structure = $Element.Split($NamePositionSeparator)
                    $ElementName = $Structure[0]
                    $ElementPosition = $Structure[1]
                    if ($ValidElementNames -notcontains $ElementName -or $ValidPositions -notcontains $ElementPosition) {
                        $StructureValidity = $false
                    }
                }
                else {
                    if ($ValidLines -notcontains $Element) {
                        $StructureValidity = $false
                    }
                }
            }
            $StructureValidity | Should -Be $true
        }
    }
}
