package rickyxe.dfa.example;

import rickyxe.dfa.DFADesign;
import rickyxe.dfa.DFARulebook;

import static rickyxe.dfa.Utils._println;
import static rickyxe.dfa.XBuilder.*;
import static rickyxe.dfa.XBuilder._FAState;

public class Example05 {
    public static void main(String[] args) {
        test01();
    }

    /**
     * <pre>
     *    ___         ___         ___
     *    | |b        | |a        | |a,b
     * -->[1] ------> [2] ------> (3)
     *           a           b
     * </pre>
     */
    private static void test01() {
        DFARulebook rulebook = _DFARulebook(
                _FARule(_FAState(1), 'a', _FAState(2)),
                _FARule(_FAState(1), 'b', _FAState(1)),
                _FARule(_FAState(2), 'a', _FAState(2)),
                _FARule(_FAState(2), 'b', _FAState(3)),
                _FARule(_FAState(3), 'a', _FAState(3)),
                _FARule(_FAState(3), 'b', _FAState(3))
        );

        DFADesign design = _DFADesign(
                _FAState(1),
                _acceptStates(_FAState(3)),
                rulebook);

        _println(design.accepts("a"));
        _println(design.accepts("baa"));
        _println(design.accepts("baba"));
    }
}
