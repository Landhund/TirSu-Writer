function Get-TirsuSymbol {
    [CmdletBinding()]
    param (
        [Parameter(Mandatory = $true)]
        [ValidateNotNullOrEmpty()]
        [string]
        $InputString
    )

    # TODO: #9 Set up parsing function to find letter combinations that have a Combined Symbol @Landhund
    
    # TODO: #8 Create internal lookup table of Symbol IDs @Landhund
    
    # TODO: #7 Create lookup table of Symbol-Elements for arbitrary assembly of symbols @Landhund

    # TODO: #6 Set up "assembly line" that combines the Symbol-Elements into a valid SVG-Group
}
