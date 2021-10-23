BeforeAll {
    function Test-String($Regex, $String) {
        return $String -match $Regex
    }
}

Describe "TirsuSymbolLibrary Test" {
    Import-Module -Name ".\" -Force
    Context "SymbolTable Tests" {
        It "Key <_> is valid" -TestCases $SymbolTable.GetEnumerator().Name {
            Test-String -Regex "^([A-Z]){1,2}$" -String $_ | Should -Be $true
        }
    }
}
