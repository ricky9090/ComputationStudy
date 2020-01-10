package rickyxe.simple.example;

import rickyxe.simple.base.XExpression;

import static rickyxe.simple.utils.StringUtils.println;
import static rickyxe.simple.utils.XBuilder.*;

public class Example01 {

    public static void main(String[] args) {
        test01();
        test02();
    }

    /**
     * 构建表达式
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
    }

    /**
     * 构建表达式
     * <pre>
     *   expected: 1 * ((2 + 3) * 4)
     *   actual:   1 * 2 + 3 * 4
     * </pre>
     * <p>
     * FIXME 没有实现运算符优先级
     */
    private static void test02() {
        XExpression exp;
        exp = _Multiply(
                _Number(1),
                _Multiply(
                        _Add(_Number(2), _Number(3)),
                        _Number(4)));

        println(exp.inspect());
    }
}
