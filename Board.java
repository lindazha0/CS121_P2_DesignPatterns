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

    // if loc is occupied by any Piece, return the color char, else return '0'
    public String isOccupied(String loc){
        int[] locArray = Helper.getLocArray(loc);

        if (pieces[locArray[0]][locArray[1]] == null)
            return null;
        return pieces[locArray[0]][locArray[1]].color().getColorStr();
    }

    // Returns piece at given loc or null if no such piece
    // exists
    public Piece getPiece(String loc) {
        int[] locArray = Helper.getLocArray(loc);
        int i=locArray[0], j=locArray[1];

        // if invalid loc
        if(i >=8 || j >=8)
            throw new ArrayIndexOutOfBoundsException();

        return pieces[i][j];
        // throw new UnsupportedOperationException();
    }

    public void addPiece(Piece p, String loc) {
        int[] locArray = Helper.getLocArray(loc);
        int i=locArray[0], j=locArray[1];

        // if invalid loc
        if(i >=8 || j >=8 || pieces[i][j]!=null)
            throw new ArrayIndexOutOfBoundsException();

        pieces[i][j] = p;
    }

    public void movePiece(String from, String to) {
        int[] fromArray = Helper.getLocArray(from);
        int[] toArray = Helper.getLocArray(to);

        // if invalid loc
        if(fromArray[0] >=8 || fromArray[1] >=8 || toArray[0] >=8 || toArray[1] >=8)
            throw new ArrayIndexOutOfBoundsException();

//        if invalid move
        Piece p = pieces[fromArray[0]][fromArray[1]];
        if(!p.moves(b_instance, from).contains(to)){
            System.out.println("invalid move: "+p.toString()+" from " + from + " to " + to);
            throw new UnsupportedOperationException();
        }

        // make a move
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
        if(listenerList.contains(bl))
            listenerList.remove(bl);
        throw new UnsupportedOperationException();
    }

    public void removeAllListeners() {
        listenerList = new LinkedList<>();
//        throw new UnsupportedOperationException();
    }

    public void iterate(BoardInternalIterator bi) {
        for(int i=0;i<8;i++){
            for(int j=0;j<8;j++){
                bi.visit(Helper.getLocStr(j,i), pieces[j][i]);
            }
        }
//        throw new UnsupportedOperationException();
    }
}