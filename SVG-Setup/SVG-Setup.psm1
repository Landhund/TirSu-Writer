function Initialize-SVG {
    [CmdletBinding()]
    param (
        # [Parameter(Mandatory = $true)]
        # [ValidateNotNullOrEmpty()]
        # [string]$FileName,
        [ValidateNotNullOrEmpty()]
        [Int16]$Width = 400,
        [ValidateNotNullOrEmpty()]
        [Int16]$Hight = 400,
        [string]$Title,
        [string]$Description
    )
    
    $NewSVG = New-Object System.Xml.XmlDocument
    $Root = $NewSVG.CreateElement('svg')
    $Root.SetAttribute("version", "1.2")
    $Root.SetAttribute("xmlns", "http://www.w3.org/2000/svg")
    $Root.SetAttribute("xmlns:xlink", "http://www.w3.org/1999/xlink")
    $Root.SetAttribute("baseProfile", "Full")
    $Root.SetAttribute("viewBox", "" + - $Width / 2 + " " + - $Hight / 2 + " " + $Width + " " + $Hight)

    if ($Title) {
        $TitleElement = $NewSVG.CreateElement("title")
        $TitleElement.AppendChild($NewSVG.CreateTextNode($Title)) | Out-Null
        $Root.AppendChild($TitleElement) | Out-Null
    }
    if ($Description) {
        $DescriptionElement = $NewSVG.CreateElement("desc")
        $DescriptionElement.AppendChild($NewSVG.CreateTextNode($Description)) | Out-Null
        $Root.AppendChild($DescriptionElement) | Out-Null
    }
    
    $NewSVG.AppendChild($Root) | Out-Null

    return $NewSVG
}

Export-ModuleMember Initialize-SVG
