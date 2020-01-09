package rickyxe.simple.basictype;

import rickyxe.simple.XEnvironment;
import rickyxe.simple.base.XObject;

public class XVariable extends XObject {

    private String name;

    public XVariable(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public boolean reducible() {
        return true;
    }

    @Override
    public XObject reduce(XEnvironment environment) {
        return environment.get(name);
    }
}
