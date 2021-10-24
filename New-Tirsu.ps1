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

    $SymbolElementsKeys = $SymbolElements.GetEnumerator().Name
    $SymbolsNumber = -10
    foreach ($Key in $SymbolElementsKeys) {
        $NewNode = $Tirsu.ImportNode($SymbolElements[$Key], $true)
        $NewNode.SetAttribute("transform", "translate(" + $SymbolsNumber * 15 + ")")
        $Tirsu.svg.AppendChild($NewNode) | Out-Null
        $SymbolsNumber++
    }

    $Tirsu.Save(".\.Tests\SymbolElements.svg")
}

end {

}
