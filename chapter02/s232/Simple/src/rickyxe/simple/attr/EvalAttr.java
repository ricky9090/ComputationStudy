package rickyxe.simple.attr;

import rickyxe.simple.XEnvironment;
import rickyxe.simple.base.XObject;

/**
 * 可执行的对象
 */
public interface EvalAttr {

    XObject evaluate(XEnvironment environment);
}
