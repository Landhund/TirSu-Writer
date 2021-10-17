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
    Import-Module -Name "$PSScriptRoot\SVG-Creator"
    Import-Module -Name "$PSScriptRoot\SavePathSelector"
}

process {
    $Tirsu = Initialize-SVG -Title "Tir'su for '$Word'"
    $Tirsu
}

end {

}
