public class Board {

    private Piece[][] pieces = new Piece[8][8];

    private Board() {
    }

    public static Board theBoard() {
        if ()
        return null; // implement this
    }

    public Int column2int(String colume) {
        int temp = (int) colume.toLowerCase();
        int temp_integer = 96; // for lower case

        try{
            if(temp <= 122 & temp >= 97) {
                return (temp - temp_integer);
            }
            else{
                throw new UnsupportedOperationException();
            }
        }catch (Exception e) {
            System.out.println("Something went wrong with `column2int`.");
        }

    // Returns piece at given loc or null if no such piece
    // exists
    public Piece getPiece(String loc) {
        Int i = column2int(loc[0]);
        Int j = (int) loc[1];
        return pieces[i][j];
        // throw new UnsupportedOperationException();
    }

    public void addPiece(Piece p, String loc) {
        throw new UnsupportedOperationException();
    }

    public void movePiece(String from, String to) {
        throw new UnsupportedOperationException();
    }

    public void clear() {
        throw new UnsupportedOperationException();
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