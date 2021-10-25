[CmdletBinding()]
param (
    [Parameter(Mandatory = $true)]
    [ValidateNotNullOrEmpty()]
    [string]
    $InputWord,
    [switch]
    $Githzerai,
    [string]$SavePath
)

begin {
    Import-Module -Name "$PSScriptRoot\SVG-Setup" -Force
    Import-Module -Name "$PSScriptRoot\SavePathSelector" -Force
    Import-Module -Name "$PSScriptRoot\TirsuSymbolLibrary" -Force
}

process {
    $Tirsu = Initialize-SVG -Title "Tir'su for '$InputWord'"

    $WordLength = $InputWord.Length
    $StartPoint = - ($WordLength / 2 * 15)
    $ValidSymbolKeys = $SymbolTable.GetEnumerator().Name
    $Index = 0
    foreach ($Char in $InputWord.GetEnumerator()) {
        if ($ValidSymbolKeys -contains $Char) {
            $LibraryNode = Get-TirsuSymbol($Char)
            $NewElement = $Tirsu.ImportNode($LibraryNode, $true)
            $NewElement.SetAttribute("transform", "translate(" + ($StartPoint + (15 * $Index)) + ")")
            $Tirsu.svg.AppendChild($NewElement) | Out-Null
            $Index++
        }
    }
    $Tirsu.Save(".\.Tests\SymbolElementsTest.svg")
}

end {

}
