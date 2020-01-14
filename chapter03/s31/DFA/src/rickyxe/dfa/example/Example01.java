package rickyxe.dfa.example;

import rickyxe.dfa.DFARulebook;

import static rickyxe.dfa.Utils._println;
import static rickyxe.dfa.XBuilder.*;

public class Example01 {
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

        _println(rulebook.nextState(_FAState(1), 'a').inspect());
        _println(rulebook.nextState(_FAState(1), 'b').inspect());
        _println(rulebook.nextState(_FAState(2), 'b').inspect());
    }
}
