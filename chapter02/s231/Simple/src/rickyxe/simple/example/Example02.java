package rickyxe.simple.example;

import rickyxe.simple.base.XExpression;

import static rickyxe.simple.utils.StringUtils.println;
import static rickyxe.simple.utils.XBuilder.*;

public class Example02 {

    public static void main(String[] args) {
        test01();
    }

    /**
     * 构建表达式，表达式可规约
     * <pre>
     *     1 * 2 + 3 * 4
     * </pre>
     */
    private static void test01() {
        XExpression exp;
        exp = _Add(
                _Multiply(
                        _Number(1),
                        _Number(2)),
                _Multiply(
                        _Number(3),
                        _Number(4)));

        println(exp.inspect());
        println(exp.reducible() + "");
    }
}
