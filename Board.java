import java.util.*;

public class Board {
    private Piece[][] pieces = new Piece[8][8]; // initially null
    private static Board b_instance = null;
    private List<BoardListener> listenerList = new LinkedList<>(); // store all listeners

    private Board() {
    }

    public static Board theBoard() {
        if (b_instance == null)
            b_instance = new Board();
        return b_instance; // implement this
    }

    // if loc is occupied by any Piece
    public boolean isOccupied(String loc){
        int[] locArray = Helper.getLocArray(loc);
        return pieces[locArray[0]][locArray[1]] != null;
    }

    // Returns piece at given loc or null if no such piece
    // exists
    public Piece getPiece(String loc) {
        int[] locArray = Helper.getLocArray(loc);

        // if invalid loc
        if(locArray[0] >=8 || locArray[1] >=8)
            throw new ArrayIndexOutOfBoundsException();

        return pieces[locArray[0]][locArray[1]];
        // throw new UnsupportedOperationException();
    }

    public void addPiece(Piece p, String loc) {
        int[] locArray = Helper.getLocArray(loc);

        // if invalid loc
        if(locArray[0] >=8 || locArray[1] >=8 || pieces[locArray[0]][locArray[1]]!=null)
            throw new ArrayIndexOutOfBoundsException();

        pieces[locArray[0]][locArray[1]] = p;
    }

    public void movePiece(String from, String to) {
        int[] fromArray = Helper.getLocArray(from);
        int[] toArray = Helper.getLocArray(to);

        // if invalid loc
        if(fromArray[0] >=8 || fromArray[1] >=8 || toArray[0] >=8 || toArray[1] >=8)
            throw new ArrayIndexOutOfBoundsException();

//        if invalid move
        if(!pieces[fromArray[0]][fromArray[1]].moves(b_instance, from).contains(to))
            throw new UnsupportedOperationException();

        // make a move
        Piece p = pieces[fromArray[0]][fromArray[1]];
        // call the observers
        for(BoardListener listener : listenerList){
            listener.onMove(from, to, p);
//            if capture sth
            if(pieces[toArray[0]][toArray[1]]!=null){
                listener.onCapture(p,pieces[toArray[0]][toArray[1]]);
            }
        }
        // modify the board pieces
        pieces[toArray[0]][toArray[1]] = p;
        pieces[fromArray[0]][fromArray[1]] = null;
    }

    public void clear() {
        pieces = new Piece[8][8];
        // throw new UnsupportedOperationException();
    }

    public void registerListener(BoardListener bl) {
        listenerList.add(bl);
//        throw new UnsupportedOperationException();
    }

    public void removeListener(BoardListener bl) {
        listenerList.remove(bl);
//        throw new UnsupportedOperationException();
    }

    public void removeAllListeners() {
        listenerList = new LinkedList<>();
//        throw new UnsupportedOperationException();
    }

    public void iterate(BoardInternalIterator bi) {
        for(int i=0;i<8;i++){
            for(int j=0;j<8;j++){
                bi.visit(Helper.getLocStr(i,j),pieces[i][j]);
            }
        }
//        throw new UnsupportedOperationException();
    }
}