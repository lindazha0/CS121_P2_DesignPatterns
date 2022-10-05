import java.util.*;

public class Board {
    private Piece[][] pieces = new Piece[8][8]; // initially null
    private Board b_instance = null;

    private Board() {
    }

    public static Board theBoard() {
        if (b_instance == null)
            b_instance = new Board();
        return null; // implement this
    }

    // Returns piece at given loc or null if no such piece
    // exists
    public Piece getPiece(String loc) {
        int[] locArray = Helper.getlocarray(loc);

        // if invalid loc
        if(locArray[0] >=8 || locArray[1] >=8)
            throw new ArrayIndexOutOfBoundsException();

        return pieces[locArray[0]][locArray[1]];
        // throw new UnsupportedOperationException();
    }

    public void addPiece(Piece p, String loc) {
        throw new UnsupportedOperationException();
    }

    public void movePiece(String from, String to) {
        throw new UnsupportedOperationException();
    }

    public void clear() {
        pieces = new Piece[8][8];
        // throw new UnsupportedOperationException();
    }

    public void registerListener(BoardListener bl) {
        throw new UnsupportedOperationException();
    }

    public void removeListener(BoardListener bl) {
        throw new UnsupportedOperationException();
    }

    public void removeAllListeners() {
        throw new UnsupportedOperationException();
    }

    public void iterate(BoardInternalIterator bi) {
        throw new UnsupportedOperationException();
    }
}