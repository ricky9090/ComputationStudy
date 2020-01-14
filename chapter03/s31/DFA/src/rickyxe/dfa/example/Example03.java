package rickyxe.dfa.example;

import rickyxe.dfa.DFA;
import rickyxe.dfa.DFARulebook;

import static rickyxe.dfa.Utils._println;
import static rickyxe.dfa.XBuilder.*;

public class Example03 {

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

        DFA dfa = _DFA(
                _FAState(1),
                _acceptStates(_FAState(3)),
                rulebook);

        _println(dfa.accepting());
        dfa.readCharacter('b');
        _println(dfa.accepting());
        dfa.readCharacter('a');
        dfa.readCharacter('a');
        dfa.readCharacter('a');
        _println(dfa.accepting());
        dfa.readCharacter('b');
        _println(dfa.accepting());
    }
}
