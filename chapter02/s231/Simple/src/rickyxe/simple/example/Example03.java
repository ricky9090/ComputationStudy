package rickyxe.simple.example;

import rickyxe.simple.XEnvironment;
import rickyxe.simple.base.XObject;

import static rickyxe.simple.utils.XBuilder.*;

public class Example03 {

    public static void main(String[] args) {
        test01();
    }

    /**
     * 执行以下代码
     * <pre>
     * x = 2
     * x = x + 1
     * x = 3
     * </pre>
     */
    private static void test01() {
        String x = "x";

        // x = 2
        XEnvironment env = _Environment();
        env.createVariable(x, _Number(2));

        // x = x + 1
        XObject s;
        s = _Assign(
                _Variable(x),
                _Add(
                        _Variable(x),
                        _Number(1)));

        _Machine(s, env).run();
    }
}
