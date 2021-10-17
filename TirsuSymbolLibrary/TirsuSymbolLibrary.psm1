function Get-TirsuSymbol {
    [CmdletBinding()]
    param (
        [Parameter(Mandatory = $true)]
        [ValidateNotNullOrEmpty()]
        [string]
        $InputString
    )

    # TODO: Set up parsing function to find letter combinations that have a Combined Symbol @Landhund
    
    # TODO: Create internal lookup table of Symbol IDs @Landhund
    
    # TODO: Create lookup table of Symbol-Elements for arbitrary assembly of symbols @Landhund

    # TODO: Set up "assembly line" that combines the Symbol-Elements into a valid SVG-Group
}
