package rickyxe.dfa.example;

import rickyxe.dfa.DFA;
import rickyxe.dfa.DFARulebook;

import static rickyxe.dfa.Utils._println;
import static rickyxe.dfa.XBuilder.*;
import static rickyxe.dfa.XBuilder._FAState;

public class Example02 {
    public static void main(String[] args) {
        test01();
    }

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
                _acceptStates(_FAState(1), _FAState(3)),
                rulebook);
        _println(dfa.accepting());

        DFA dfa2 = _DFA(
                _FAState(1),
                _acceptStates(_FAState(3)),
                rulebook);
        _println(dfa2.accepting());
    }
}
