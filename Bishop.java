import java.util.*;

public class Bishop extends Piece {
    public Bishop(Color c) {
        color=c;
//        throw new UnsupportedOperationException();
    }
    // implement appropriate methods

    public String toString() {
//	throw new UnsupportedOperationException();
        if (color==null)
            throw new UnsupportedOperationException();
        String s = color.getColorStr()+"b";
        return s;
    }

    public List<String> moves(Board b, String loc) {
	throw new UnsupportedOperationException();
    }

}