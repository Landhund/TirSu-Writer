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
        $NewGroup = $Tirsu.CreateElement("g")
        $NewGroup.SetAttribute("transform", "translate(" + $SymbolsNumber * 15 + ")")
        $NewNode = $Tirsu.ImportNode($SymbolElements[$Key], $true)
        $NewGroup.AppendChild($NewNode) | Out-Null
        $Tirsu.svg.AppendChild($NewGroup) | Out-Null
        $SymbolsNumber++
    }

    $Tirsu.Save(".\.Tests\SymbolElements.svg")
}

end {

}
