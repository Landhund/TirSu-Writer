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
    Import-Module -Name "$PSScriptRoot\SVG-Setup"
    Import-Module -Name "$PSScriptRoot\SavePathSelector"
}

process {
    $Tirsu = Initialize-SVG -Title "Tir'su for '$InputWord'"

    $ElementCreator = New-Object System.Xml.XmlDocument

    $DownArms = $ElementCreator.CreateElement("g")
    $Arm1 = $ElementCreator.CreateElement("path")
    $Arm1.SetAttribute("d", "M 0,0 v -10")
    $Arm1.SetAttribute("stroke", "black")
    $Arm1.SetAttribute("stroke-width", "1")
    $Arm1.SetAttribute("transform", "rotate(45)")
    $Arm2 = $ElementCreator.CreateElement("path")
    $Arm2.SetAttribute("d", "M 0,0 v -10")
    $Arm2.SetAttribute("stroke", "black")
    $Arm2.SetAttribute("stroke-width", "1")
    $Arm2.SetAttribute("transform", "rotate(-45)")
    $DownArms.AppendChild($Arm1)
    $DownArms.AppendChild($Arm2)
    $DownArms.SetAttribute("id", "DownArms")

    $NewNode = $Tirsu.ImportNode($DownArms, $true)
    $Tirsu.svg.AppendChild($NewNode)
    $Tirsu.Save(".\.Tests\ElementTest.svg")
}

end {

}
