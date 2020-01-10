package rickyxe.simple.utils;

import rickyxe.simple.Machine;
import rickyxe.simple.XEnvironment;
import rickyxe.simple.base.XObject;
import rickyxe.simple.basictype.XBoolean;
import rickyxe.simple.basictype.XNumber;
import rickyxe.simple.basictype.XVariable;
import rickyxe.simple.operator.XAdd;
import rickyxe.simple.operator.XLessThan;
import rickyxe.simple.operator.XMultiply;
import rickyxe.simple.statement.*;

/**
 * 生成各类型实例，简化调用代码
 */
public class XBuilder {

    public static XBoolean _Boolean(Boolean value) {
        return new XBoolean(value);
    }

    public static XNumber _Number(Integer value) {
        return new XNumber(value);
    }

    public static XVariable _Variable(String name) {
        return new XVariable(name);
    }

    public static XAdd _Add(XObject left, XObject right) {
        return new XAdd(left, right);
    }

    public static XLessThan _LessThan(XObject left, XObject right) {
        return new XLessThan(left, right);
    }

    public static XMultiply _Multiply(XObject left, XObject right) {
        return new XMultiply(left, right);
    }

    public static XAssign _Assign(XVariable name, XObject expression) {
        return new XAssign(name, expression);
    }

    public static XDoNothing _DoNothing() {
        return new XDoNothing();
    }

    public static XIf _If(XObject condition, XObject consequence, XObject alternative) {
        return new XIf(condition, consequence, alternative);
    }

    public static XSequence _Sequence(XObject first, XObject second) {
        return new XSequence(first, second);
    }

    public static XWhile _While(XObject condition, XObject body) {
        return new XWhile(condition, body);
    }

    public static StatementRunner _StatementRunner(XObject statement, XEnvironment environment) {
        return new StatementRunner(statement, environment);
    }

    public static XEnvironment _Environment() {
        return new XEnvironment();
    }

    public static Machine _Machine(XObject statement, XEnvironment environment) {
        return new Machine(statement, environment);
    }
}
