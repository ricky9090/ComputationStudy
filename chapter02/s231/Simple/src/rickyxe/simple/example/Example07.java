package rickyxe.simple.example;

import rickyxe.simple.XEnvironment;
import rickyxe.simple.base.XObject;

import static rickyxe.simple.utils.XBuilder.*;

public class Example07 {

    public static void main(String[] args) {
        test01();
    }

    /**
     * 对Boolean类型进行+1操作，引起崩溃
     */
    private static void test01() {
        XEnvironment env = _Environment();
        String x = "x";

        XObject s;
        s = _Sequence(
                _Assign(_Variable(x), _Boolean(true)),
                _Assign(_Variable(x),
                        _Add(_Variable(x), _Number(1))));

        _Machine(s, env).run();
    }
}
