package rickyxe.simple.base;

import rickyxe.simple.XEnvironment;
import rickyxe.simple.attr.Inspectable;
import rickyxe.simple.attr.ReduceAttr;

public abstract class XObject implements ReduceAttr, Inspectable {

    @Override
    public String inspect() {
        return "<<" + this.toString() + ">>";
    }

    @Override
    public boolean reducible() {
        return false;
    }

    @Override
    public XObject reduce(XEnvironment environment) {
        return null;
    }
}
