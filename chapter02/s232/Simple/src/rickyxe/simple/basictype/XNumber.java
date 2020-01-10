package rickyxe.simple.basictype;

import rickyxe.simple.XEnvironment;
import rickyxe.simple.base.XObject;

public class XNumber extends XObject {

    private Integer value;

    public XNumber(Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }

    @Override
    public String toString() {
        return value.toString();
    }

    @Override
    public XObject evaluate(XEnvironment environment) {
        return this;
    }
}
