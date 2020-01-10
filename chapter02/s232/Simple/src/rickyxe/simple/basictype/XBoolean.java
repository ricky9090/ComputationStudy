package rickyxe.simple.basictype;

import rickyxe.simple.XEnvironment;
import rickyxe.simple.base.XObject;

public class XBoolean extends XObject {

    private Boolean value;

    public XBoolean(boolean value) {
        this.value = value;
    }

    public Boolean getValue() {
        return value;
    }

    @Override
    public String toString() {
        return value ? "true" : "false";
    }

    @Override
    public XObject evaluate(XEnvironment environment) {
        return this;
    }
}
