#region Symbol-ID Lookup Table
# Symbol definition as such: (<Middle Line Type>, <SubElementName>:<Position>, ...)
# Symbols get defined middle line first, then from top to bottom
$SymbolTable = @{
    A = ("FullLine", "DownArms:Top")
    B = ("MidLine", "UpArms:Middle", "Bar:Middle")
    C = ("MidLine", "Head:Middle", "Bar:Middle")
    D = ("FullLine", "DownArms:Top", "Bar:Middle")
    E = ("FullLine", "Bar:Top")
    F = ("FullLine", "DoubleBar:Top")
    G = ("MidLine", "Head:Middle", "DoubleBar:Middle")
    H = ("FullLine", "DownArms:Top", "DoubleBar:Middle")
    I = ("FullLine")
    J = ("FullLine", "SideArm:Top")
    K = ("FullLine", "DoubleSideArm:Top")
    L = ("MidLine", "PointUp:Middle")
    M = ("MidLine", "PointUp:Middle", "Bar:Middle")
    N = ("MidLine", "PointUp:Middle", "DoubleBar:Middle")
    O = ("MidLine", "Head:Middle")
    P = ("FullLine", "DownArms:Top", "SideArm:SubTop")
    Q = ("MidLine", "PointDown:Middle")
    R = ("MidLine", "UpArms:Middle", "DoubleBar:Middle")
    S = ("MidLine", "Head:Middle", "SideArm:Middle")
    T = ("MidLine", "Head:Middle", "DoubleSideArm:Middle")
    U = ("MidLine", "Bowl:Middle")
    V = ("MidLine", "Bowl:Middle", "Bar:Middle")
    W = ("MidLine", "Bowl:Middle", "DoubleBar:Middle")
    X = ("MidLine", "Crescent:Middle")
    Y = ("MidLine", "UpArms:Middle")
    Z = ("MidLine", "Crescent:Middle", "Bar:Middle")
    EA = ("FullLine", "Bar:Top", "DownArms:Top")
    OA = ("MidLine", "Head:Middle", "DownArms:Middle")
    OI = ("SubLine", "UpArms:SubTop", "Head:SubMiddle") # TODO: #11 Test if the double Symbol definitions actually work @Landhund
    OU = ("SubLine", "Head:SubTop", "Bowl:SubMiddle")
    CH = ("SubLine", "DownArms:Top", "Head:SubMiddle", "Bar:SubMiddle")
    SH = ("SubLine", "DownArms:Top", "Head:SubMiddle", "SideArm:SubMiddle")
    TH = ("SubLine", "DownArms:Top", "Head:SubMiddle", "DoubleSideArm:SubMiddle")
    ZH = ("MidLine", "Crescent:Middle","DoubleBar:Middle")
}
#endregion


function Get-TirsuSymbol {
    [CmdletBinding()]
    param (
        [Parameter(Mandatory = $true)]
        [ValidateNotNullOrEmpty()]
        [string]
        $InputString
    )

    # TODO: #9 Set up parsing function to find letter combinations that have a Combined Symbol @Landhund
    

    # TODO: #7 Create lookup table of Symbol-Elements for arbitrary assembly of symbols @Landhund

    # TODO: #6 Set up "assembly line" that combines the Symbol-Elements into a valid SVG-Group
}

Export-ModuleMember Get-TirsuSymbol
Export-ModuleMember -Variable $SymbolTable