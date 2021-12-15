package SVG_Tools.New_SVG_Workspace.Element_Workspace;

import java.util.ArrayList;
import java.util.List;

import SVG_Tools.New_SVG_Workspace.AttributeLibrary.AttributeValue;
import SVG_Tools.New_SVG_Workspace.AttributeLibrary.Global_Att;

public class Group_Element implements Element
{
    List<AttributeValue> attributeValues = new ArrayList<>();
    List<Element> groupedElements = new ArrayList<>();

    public Group_Element()
    {
        
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
        
        String group_Element =  "<g";
        for (AttributeValue attributeValue : attributeValues)
        {
            group_Element += " " + attributeValue.toString();
        }
        group_Element += ">\n";

        for (Element element : groupedElements) 
        {
            group_Element += "    " + element.toString() + "\n" ;
        }

        group_Element += "  </g>\n";
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
    public void appendAttribute(Global_Att global_att, String value) {
        // TODO Auto-generated method stub
    }

    @Override
    public void removeGlobalAttribute(Global_Att att) 
    {
        this.attributeValues.remove(new AttributeValue(att));
    }
    
}
