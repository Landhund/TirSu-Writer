Function Get-SavePath() {
    [CmdletBinding()]
    param (
        [Parameter(Mandatory = $true)]
        [ValidateNotNullOrEmpty()]
        [string]$Extension
    )

    Add-Type -AssemblyName System.Windows.Forms

    $Extension = $Extension.TrimStart(".")

    $SavePath = New-Object System.Windows.Forms.SaveFileDialog
    $SavePath.Filter = "$Extension files (*.$Extension)|*.$Extension|All files (*.*)|*.*"
    $SavePath.FilterIndex = 1
    $SavePath.RestoreDirectory = $true

    if ($SavePath.ShowDialog((New-Object System.Windows.Forms.Form -Property @{TopMost = $true })) -eq "OK") {
        return $SavePath.FileName
    }
    else {
        exit
    }
}

Export-ModuleMember Get-SavePath
