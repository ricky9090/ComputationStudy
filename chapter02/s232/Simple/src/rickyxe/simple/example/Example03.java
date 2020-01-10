package rickyxe.simple.example;

import rickyxe.simple.XEnvironment;
import rickyxe.simple.base.XObject;

import static rickyxe.simple.utils.StringUtils.println;
import static rickyxe.simple.utils.XBuilder.*;

public class Example03 {

    public static void main(String[] args) {
        test01();
        test02();
    }

    /**
     * 执行代码
     * <pre>
     * x = 1
     * while (x < 5) {
     *     x = x * 3
     * }
     * </pre>
     */
    private static void test01() {
        String x = "x";

        // x = 2
        XEnvironment env = _Environment();
        env.createVariable(x, _Number(1));

        // x = x + 1
        XObject s;
        s = _While(
                _LessThan(
                        _Variable(x),
                        _Number(5)),
                _Assign(
                        _Variable(x),
                        _Multiply(_Variable(x), _Number(3)))
        );

        println(
                s.evaluate(env).inspect()
        );

    }

    /**
     * 执行以下代码，与小步语义不同，现在 Machine 内部通过 evaluate 求值
     * <pre>
     * x = 1
     * while (x < 5) {
     *     x = x * 3
     * }
     * </pre>
     * 结果为 x = 9
     */
    private static void test02() {
        String x = "x";

        XEnvironment env = _Environment();
        env.createVariable(x, _Number(1));

        XObject s;
        s = _While(
                _LessThan(
                        _Variable(x),
                        _Number(5)),
                _Assign(
                        _Variable(x),
                        _Multiply(_Variable(x), _Number(3))));

        _Machine(s, env).run();
    }
}
