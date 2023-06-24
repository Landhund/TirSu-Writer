package SVG_Tools.New_SVG_Workspace.AttributeLibrary;


import java.util.Objects;

public class AttributeValue {

    /**
     * Dieses Klasse soll für alle SVG Attribute verwendet werden, damit ein Einheitlicher Umgang geboten ist.
     */

    Attribute attribute;
    String value;

    public AttributeValue(Attribute attribute) {
        this.attribute = attribute;
        this.value = attribute.getDefaultValue();
    }

    /**
     * Append a String value to a attribut
     *
     * @param value
     */

    public AttributeValue withValue(String value) {
        this.value = value;
        return this;
    }

    /**
     * Append a int value to a attribut
     *
     * @param value
     * @return
     */

    public AttributeValue withValue(int value) {
        this.value = String.valueOf(value);
        return this;
    }

    /**
     * Append a double value to a attribut
     *
     * @param value
     */

    public AttributeValue withValue(double value) {
        this.value = String.valueOf(value);
        return this;
    }


    /**
     * Syntax to return an attribut in the correct format
     *
     * @return
     */

    @Override
    public String toString() {
        return attribute.getIdentifier() + "=\"" + value + "\"";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AttributeValue that = (AttributeValue) o;
        return (this.attribute.equals(that.getAttribute())) ? true : false;
    }

    public String getValue() {
        return value;
    }

    public Attribute getAttribute() {
        return attribute;
    }
}
