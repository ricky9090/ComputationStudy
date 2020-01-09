package rickyxe.simple.example;

import rickyxe.simple.XEnvironment;
import rickyxe.simple.base.XObject;

import static rickyxe.simple.utils.XBuilder.*;

public class Example05 {

    public static void main(String[] args) {
        test01();
    }

    /**
     * 执行以下代码
     * <pre>
     * x = 1 + 1
     * y = x + 3
     * </pre>
     */
    private static void test01() {
        String x = "x";
        String y = "y";

        XEnvironment env = _Environment();

        XObject s;
        s = _Sequence(
                _Assign(
                        _Variable(x),
                        _Add(_Number(1), _Number(1))),
                _Assign(
                        _Variable(y),
                        _Add(_Variable(x), _Number(3))));

        _Machine(s, env).run();
    }
}
