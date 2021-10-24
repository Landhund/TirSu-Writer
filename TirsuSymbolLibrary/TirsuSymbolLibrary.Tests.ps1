BeforeAll {
    Import-Module -Name ".\" -Force

    function Test-String($Regex, $String) {
        return $String -match $Regex
    }
}

BeforeDiscovery {
    $SymbolTableKeys = $SymbolTable.GetEnumerator().Name

    $ValidElementNames = @()
    $SymbolElementsKeys = $SymbolElements.GetEnumerator().Name
    foreach ($Key in $SymbolElementsKeys) {
        $ValidElementNames += $SymbolElements[$Key].id
    }

    $ValidPositions = @("Top", "SubTop", "Middle", "SubMiddle")
    $ValidLines = @("FullLine", "MidLine", "SubLine")
    $NamePositionSeparator = ":"

}

Describe "TirsuSymbolLibrary Test" {
    Import-Module -Name ".\" -Force
    Context "SymbolTable Tests" {
        It "Key <_> is valid" -TestCases $SymbolTableKeys {
            Test-String -Regex "^([A-Z]){1,2}$" -String $_ | Should -Be $true
        }
    }
}
