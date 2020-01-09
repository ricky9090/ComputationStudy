package rickyxe.simple.attr;

import rickyxe.simple.XEnvironment;
import rickyxe.simple.base.XObject;

public interface ReduceAttr {

    boolean reducible();

    XObject reduce(XEnvironment environment);
}
