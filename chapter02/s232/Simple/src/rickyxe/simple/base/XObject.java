package rickyxe.simple.base;

import rickyxe.simple.XEnvironment;
import rickyxe.simple.attr.EvalAttr;
import rickyxe.simple.attr.Inspectable;

public abstract class XObject implements EvalAttr, Inspectable {

    @Override
    public String inspect() {
        return "<<" + this.toString() + ">>";
    }

    @Override
    public XObject evaluate(XEnvironment environment) {
        return null;
    }
}
