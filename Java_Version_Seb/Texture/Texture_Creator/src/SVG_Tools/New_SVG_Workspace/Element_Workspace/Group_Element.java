package SVG_Tools.New_SVG_Workspace.Element_Workspace;

import java.util.ArrayList;
import java.util.List;

import SVG_Tools.New_SVG_Workspace.AttributeLibrary.AttributeValue;
import SVG_Tools.New_SVG_Workspace.AttributeLibrary.Global_Att;

public class Group_Element implements Element
{
    List<AttributeValue> attributeValues = new ArrayList<>();
    List<Element> groupedElements = new ArrayList<>();
    String textIndent = "";         //TODO: Environment.Newline in java?!
    int indentAmount;

    public Group_Element()
    {
        
    }

    public Group_Element(int indentAmount)
    {
        this.indentAmount = indentAmount;
        setTextIndent(indentAmount);
    }

    public Group_Element(boolean groupBySimilarity, Element... elements)
    {
        for (Element element : elements) 
        {
            if (element != null)
            {
                this.groupedElements.add(element); 
            }
        }
        filter_Global_Att_ToGroup();
    }

    public Group_Element withAttributes(AttributeValue... attributeValues)
    {

        for (AttributeValue attributeValue : attributeValues) 
        {
            if (Global_Att.isInEnum(attributeValue.getAttribute())) // check if attribut is a global_Att
            {
                this.attributeValues.add(attributeValue);   
            }         
        }
        return this;
    }

    public Group_Element withElements(Element... elements)
    {
        for (Element element : elements) 
        {
            this.groupedElements.add(element);    
        }
        return this;
    }


    // --------------- Methodes --------------- \\


    public void setTextIndent(int indentAmount)
    {
        this.indentAmount = indentAmount;
        textIndent = "";
        for (int i = 0; i < indentAmount; i++) {
            textIndent+="\t";
        }

        for (Element element : this.groupedElements)
        {
            if (element instanceof Group_Element)
            {
                Group_Element group_element = (Group_Element) element;
                group_element.setTextIndent(this.indentAmount + 1);
            }

        }

    }

    public int getIndentAmount() {
        return indentAmount;
    }

    public void addElementsToGroup(Element... elements)
    {
        for (Element element : elements)
        {
            this.groupedElements.add(element);
        }
    }

    private boolean filter_Global_Att_ToGroup()
    {
        List<AttributeValue> groupableAttributes = new ArrayList<>();
        boolean initiated = false;
        for (Element element : this.groupedElements)    // filter Global Attributes
        {
            if (!initiated)
            {
                for (AttributeValue attributeValue : element.getAttributeValues()) 
                {
                    if (Global_Att.isInEnum(attributeValue.getAttribute()))
                    {
                        groupableAttributes.add(attributeValue);   
                    }
                }
                initiated = true;
            }
            else
            {
                for (AttributeValue attributeValue : groupableAttributes) 
                {
                    if (!element.getAttributeValues().contains(attributeValue))
                    {
                        groupableAttributes.remove(attributeValue);
                    }
                }
            }
        }


        for (AttributeValue attributeValue : groupableAttributes) 
        {
            this.attributeValues.add(attributeValue);
        }

        for (Element element : groupedElements) 
        {
            for (AttributeValue attributeValue : groupableAttributes) 
            {
                element.removeGlobalAttribute((Global_Att) attributeValue.getAttribute());  
            }   
        }

        
        return (groupableAttributes != null) ? true : false;
    }


    @Override
    public String toString()
    {
        String group_Element =  this.textIndent + "<g";
        for (AttributeValue attributeValue : attributeValues)
        {
            group_Element += " " + attributeValue.toString();
        }
        group_Element += ">\n";

        for (Element element : groupedElements) 
        {
            if (element instanceof Group_Element)
            {
                Group_Element nextGroup = (Group_Element) element;
                nextGroup.setTextIndent(this.indentAmount + 1);
                group_Element += element.toString() + "\n" ;
            }
            else{
                group_Element += this.textIndent + "\t" + element.toString() + "\n" ;
            }
        }

        group_Element += this.textIndent + "</g>";
        return group_Element;
    }
    

    // --------------- Overrides --------------- \\

    @Override
    public List<AttributeValue> getAttributeValues() {
        // TODO Auto-generated method stub
        return attributeValues;
    }

    @Override
    public boolean containsMinAttributes() {
        // TODO Auto-generated method stub
        return true;
    }

    @Override
    public void appendAttribute(Global_Att global_att, String value)
    {
        AttributeValue tester = new AttributeValue(global_att).withValue(value);
        if (attributeValues.contains(tester))
        {
            attributeValues.get(attributeValues.indexOf(tester)).withValue(value);
        }
        else
        {
            attributeValues.add(tester);
        }
    }

    @Override
    public void removeGlobalAttribute(Global_Att att) 
    {
        this.attributeValues.remove(new AttributeValue(att));
    }
    
}
