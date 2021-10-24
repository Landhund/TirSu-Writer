#region Symbol-ID Lookup Table (hic sunt dracones)
# Symbol definition as such: (<Middle Line Type>, <SubElementName>:<Position>, ...)
# Symbols get defined middle line first, then from top to bottom
$SymbolTable = @{
    A  = ("FullLine", "DownArms:Top")
    B  = ("MidLine", "UpArms:Middle", "Bar:Middle")
    C  = ("MidLine", "Head:Middle", "Bar:Middle")
    D  = ("FullLine", "DownArms:Top", "Bar:Middle")
    E  = ("FullLine", "Bar:Top")
    F  = ("FullLine", "DoubleBar:Top")
    G  = ("MidLine", "Head:Middle", "DoubleBar:Middle")
    H  = ("FullLine", "DownArms:Top", "DoubleBar:Middle")
    I  = ("FullLine")
    J  = ("FullLine", "SideArm:Top")
    K  = ("FullLine", "DoubleSideArm:Top")
    L  = ("MidLine", "PointUp:Middle")
    M  = ("MidLine", "PointUp:Middle", "Bar:Middle")
    N  = ("MidLine", "PointUp:Middle", "DoubleBar:Middle")
    O  = ("MidLine", "Head:Middle")
    P  = ("FullLine", "DownArms:Top", "SideArm:SubTop")
    Q  = ("MidLine", "PointDown:Middle")
    R  = ("MidLine", "UpArms:Middle", "DoubleBar:Middle")
    S  = ("MidLine", "Head:Middle", "SideArm:Middle")
    T  = ("MidLine", "Head:Middle", "DoubleSideArm:Middle")
    U  = ("MidLine", "Bowl:Middle")
    V  = ("MidLine", "Bowl:Middle", "Bar:Middle")
    W  = ("MidLine", "Bowl:Middle", "DoubleBar:Middle")
    X  = ("MidLine", "Crescent:Middle")
    Y  = ("MidLine", "UpArms:Middle")
    Z  = ("MidLine", "Crescent:Middle", "Bar:Middle")
    EA = ("FullLine", "Bar:Top", "DownArms:Top")
    OA = ("MidLine", "Head:Middle", "DownArms:Middle")
    OI = ("SubLine", "UpArms:SubTop", "Head:SubMiddle") # TODO: #11 Test if the double Symbol definitions actually work @Landhund
    OU = ("SubLine", "Head:SubTop", "Bowl:SubMiddle")
    CH = ("SubLine", "DownArms:Top", "Head:SubMiddle", "Bar:SubMiddle")
    SH = ("SubLine", "DownArms:Top", "Head:SubMiddle", "SideArm:SubMiddle")
    TH = ("SubLine", "DownArms:Top", "Head:SubMiddle", "DoubleSideArm:SubMiddle")
    ZH = ("MidLine", "Crescent:Middle", "DoubleBar:Middle")
}
$SymbolTable | Out-Null # Just here so my editor doesn't complain about an unused variable
#endregion

#region Symbol Elements Definitions (abandon hope all ye who enter here)
#TODO: #14 Test all Symbol-Element definitions @Landhund
$SymbolElements = @{}
$ElementCreator = New-Object System.Xml.XmlDocument

#region Middle Line Definitions
#region Definition of FullLine Element
$FullLine = $ElementCreator.CreateElement("path")
$FullLine.SetAttribute("d", "M 0,0 v 20")
$FullLine.SetAttribute("stroke", "black")
$FullLine.SetAttribute("stroke-width", "1")
$FullLine.SetAttribute("id", "FullLine")

$SymbolElements["FullLine"] = $FullLine
#endregion

#region Definition of MidLine Element
$MidLine = $ElementCreator.CreateElement("path")
$MidLine.SetAttribute("d", "M 0,0 v 13")
$MidLine.SetAttribute("stroke", "black")
$MidLine.SetAttribute("stroke-width", "1")
$MidLine.SetAttribute("id", "MidLine")

$SymbolElements["MidLine"] = $MidLine
#endregion

#region Definition of SubLine Element
$SubLine = $ElementCreator.CreateElement("path")
$SubLine.SetAttribute("d", "M 0,0 v 10")
$SubLine.SetAttribute("stroke", "black")
$SubLine.SetAttribute("stroke-width", "1")
$SubLine.SetAttribute("id", "SubLine")

$SymbolElements["SubLine"] = $SubLine
#endregion
#endregion

#region DownArms Definition
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

$SymbolElements["DownArms"] = $DownArms
#endregion

#region UpArms Definition
$UpArms = $ElementCreator.CreateElement("g")
$Arm1 = $ElementCreator.CreateElement("path")
$Arm1.SetAttribute("d", "M 0,0 v 10")
$Arm1.SetAttribute("stroke", "black")
$Arm1.SetAttribute("stroke-width", "1")
$Arm1.SetAttribute("transform", "rotate(45)")
$Arm2 = $ElementCreator.CreateElement("path")
$Arm2.SetAttribute("d", "M 0,0 v 10")
$Arm2.SetAttribute("stroke", "black")
$Arm2.SetAttribute("stroke-width", "1")
$Arm2.SetAttribute("transform", "rotate(-45)")
$UpArms.AppendChild($Arm1)
$UpArms.AppendChild($Arm2)
$UpArms.SetAttribute("id", "UpArms")

$SymbolElements["UpArms"] = $UpArms
#endregion

#region SideArm Definition
$SideArm = $ElementCreator.CreateElement("path")
$SideArm.SetAttribute("d", "M 0,0 v -10")
$SideArm.SetAttribute("stroke", "black")
$SideArm.SetAttribute("stroke-width", "1")
$SideArm.SetAttribute("transform", "rotate(45)")
$SideArm.SetAttribute("id", "SideArm")

$SymbolElements["SideArm"] = $SideArm
#endregion

#region DoubleSideArm Definition
$DoubleSideArm = $ElementCreator.CreateElement("g")
$Arm1 = $ElementCreator.CreateElement("path")
$Arm1.SetAttribute("d", "M 0,0 v -10")
$Arm1.SetAttribute("stroke", "black")
$Arm1.SetAttribute("stroke-width", "1")
$Arm1.SetAttribute("transform", "rotate(45)")
$Arm2 = $ElementCreator.CreateElement("path")
$Arm2.SetAttribute("d", "M 0,0 v -10")
$Arm2.SetAttribute("stroke", "black")
$Arm2.SetAttribute("stroke-width", "1")
$Arm2.SetAttribute("transform", "matrix(0.707106781186548, 0.707106781186548, -0.707106781186548, 0.707106781186548, 0, -2)")
$DoubleSideArm.AppendChild($Arm1)
$DoubleSideArm.AppendChild($Arm2)
$DoubleSideArm.SetAttribute("id", "DoubleSideArm")

$SymbolElements["DoubleSideArm"] = $DoubleSideArm
#endregion

#region Bar Definition
$Bar = $ElementCreator.CreateElement("path")
$Bar.SetAttribute("d", "M -5,0 h 10")
$Bar.SetAttribute("stroke", "black")
$Bar.SetAttribute("stroke-width", "1")
$Bar.SetAttribute("id", "Bar")

$SymbolElements["Bar"] = $Bar
#endregion

#region DoubleBar Definition
$DoubleBar = $ElementCreator.CreateElement("g")
$Bar1 = $ElementCreator.CreateElement("path")
$Bar1.SetAttribute("d", "M -5,0 h 10")
$Bar1.SetAttribute("stroke", "black")
$Bar1.SetAttribute("stroke-width", "1")
$Bar2 = $ElementCreator.CreateElement("path")
$Bar2.SetAttribute("d", "M -5,-2 h 10")
$Bar2.SetAttribute("stroke", "black")
$Bar2.SetAttribute("stroke-width", "1")
$DoubleBar.AppendChild($Bar1)
$DoubleBar.AppendChild($Bar2)
$DoubleBar.SetAttribute("id", "DoubleBar")

$SymbolElements["DoubleBar"] = $DoubleBar
#endregion

#region Head Definition
$Head = $ElementCreator.CreateElement("ellipse")
$Head.SetAttribute("rx", "5")
$Head.SetAttribute("ry", "3")
$Head.SetAttribute("transform", "translate(0,3)")
$Head.SetAttribute("stroke", "black")
$Head.SetAttribute("stroke-width", "1")
$Head.SetAttribute("fill", "none")
$Head.SetAttribute("id", "Head")

$SymbolElements["Head"] = $Head
#endregion

#region PointUp Definition
$PointUp = $ElementCreator.CreateElement("polygon")
$PointUp.SetAttribute("points", "-10,0 0,0 0,-10")
$RotationMatrix = "0.707106781186548, 0.707106781186548, -0.707106781186548, 0.707106781186548, 0, 7.071"
$PointUp.SetAttribute("transform", "matrix($RotationMatrix)")
$PointUp.SetAttribute("stroke", "black")
$PointUp.SetAttribute("stroke-width", "1")
$PointUp.SetAttribute("fill", "none")
$PointUp.SetAttribute("id", "PointUp")

$SymbolElements["PointUp"] = $PointUp
#endregion

#region PointDown Definition
$PointDown = $ElementCreator.CreateElement("polygon")
$PointDown.SetAttribute("points", "-10,0 0,0 0,-10")
$PointDown.SetAttribute("transform", "rotate(-135)")
$PointDown.SetAttribute("stroke", "black")
$PointDown.SetAttribute("stroke-width", "1")
$PointDown.SetAttribute("fill", "none")
$PointDown.SetAttribute("id", "PointDown")

$SymbolElements["PointDown"] = $PointDown
#endregion

#region Bowl Definition
$Bowl = $ElementCreator.CreateElement("path")
$Bowl.SetAttribute("d", "M 6,7 A 5 6 180 1 0 -6 7")
$Bowl.SetAttribute("stroke", "black")
$Bowl.SetAttribute("stroke-width", "1")
$Bowl.SetAttribute("fill", "none")
$Bowl.SetAttribute("id", "Bowl")

$SymbolElements["Bowl"] = $Bowl
#endregion

#region Crescent Defintion
$Crescent = $ElementCreator.CreateElement("path")
$Crescent.SetAttribute("d", "M 1,0 h 6 v 6 h -6")
$Crescent.SetAttribute("stroke", "black")
$Crescent.SetAttribute("stroke-width", "1")
$Crescent.SetAttribute("fill", "none")
$Crescent.SetAttribute("id", "Crescent")

$SymbolElements["Crescent"] = $Crescent
#endregion

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

    # TODO: #6 Set up "assembly line" that combines the Symbol-Elements into a valid SVG-Group
}

Export-ModuleMember Get-TirsuSymbol
Export-ModuleMember -Variable SymbolTable
Export-ModuleMember -Variable SymbolElements
