BeforeAll {
    # . $PSScriptRoot\TirsuSymbolLibrary.psm1
    # Import-Module -Name ".\" -Force

    function Test-String($Regex, $String) {
        return $String -match $Regex
    }
}

Describe "TirsuSymbolLibrary Test" {
    Import-Module -Name ".\" -Force
    Context "SymbolTable Tests" {
        # $TestSet = $SymbolTable.GetEnumerator()
        It "Key <_> is valid" -TestCases $SymbolTable.GetEnumerator().Name {
            # $Value -Match "^([A-Z]){1,2}$" | Should -Be $true
            Test-String -Regex "^([A-Z]){1,2}$" -String $_ | Should -Be $true
        }
    }
}
