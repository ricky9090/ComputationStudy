package rickyxe.simple.example;

import rickyxe.simple.Machine;
import rickyxe.simple.XEnvironment;
import rickyxe.simple.base.XObject;

import static rickyxe.simple.utils.StringUtils.println;
import static rickyxe.simple.utils.XBuilder.*;

public class Example04 {

    public static void main(String[] args) {
        test01();
        println();
        test02();
    }

    /**
     * 执行以下代码
     * <pre>
     * x = true
     * y
     * if (x) {
     *     y = 1
     * } else {
     *     y = 2
     * }
     * </pre>
     * 结果为 y = 1
     */
    private static void test01() {
        String x = "x";
        String y = "y";

        // x = true
        XEnvironment env = _Environment();
        env.createVariable(x, _Boolean(true));

        /*
        if (x) {
            y = 1
        } else {
            y = 2
        }
         */
        XObject s;
        s = _If(
                _Variable(x),  // condition
                _Assign(_Variable(y), _Number(1)),  // consequence
                _Assign(_Variable(y), _Number(2)));  // alternative

        Machine machine = _Machine(s, env);
        machine.run();
    }

    /**
     * 执行以下代码
     * <pre>
     * x = true
     * y
     * if (x) {
     *     y = 1
     * }
     * </pre>
     * 结果为 y = 1
     */
    private static void test02() {
        String x = "x";
        String y = "y";

        // x = true
        XEnvironment env = _Environment();
        env.createVariable(x, _Boolean(true));

        /*
        if (x) {
            y = 1
        }
         */
        XObject s;
        s = _If(
                _Variable(x),  // condition
                _Assign(_Variable(y), _Number(1)),  // consequence
                _DoNothing());

        _Machine(s, env).run();
    }
}
