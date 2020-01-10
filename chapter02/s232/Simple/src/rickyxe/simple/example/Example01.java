package rickyxe.simple.example;

import rickyxe.simple.XEnvironment;
import rickyxe.simple.base.XObject;

import static rickyxe.simple.utils.StringUtils.println;
import static rickyxe.simple.utils.XBuilder.*;

public class Example01 {

    public static void main(String[] args) {
        test01();
        test02();
        test03();
    }

    /**
     * 表达式求值
     * <pre>
     * 23
     * </pre>
     */
    private static void test01() {
        XEnvironment env = _Environment();
        println(_Number(23).evaluate(env).inspect());
    }

    /**
     * 表达式求值
     * <pre>
     * x = 23
     * </pre>
     */
    private static void test02() {
        String x = "x";
        XEnvironment env = _Environment();
        env.createVariable(x, _Number(23));

        println(_Variable(x).evaluate(env).inspect());
    }

    /**
     * 表达式求值
     * <pre>
     * x = 2
     * y = 5
     * x + 2 < y ?
     * </pre>
     */
    private static void test03(){
        String x = "x";
        String y = "y";
        XEnvironment env = _Environment();
        env.createVariable(x, _Number(2));
        env.createVariable(y, _Number(5));

        XObject r;
        r = _LessThan(
                _Add(_Variable(x), _Number(2)),
                _Variable(y)
        ).evaluate(env);

        println(r.inspect());
    }






}
