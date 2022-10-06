import java.util.Objects;

public class Test {

    // Run "java -ea Test" to run with assertions enabled (If you run
    // with assertions disabled, the default, then assert statements
    // will not execute!)

    public static void test1() {
        Board b = Board.theBoard();
        Piece.registerPiece(new PawnFactory());
        Piece p = Piece.createPiece("bp");
        b.addPiece(p, "a3");
         assert b.getPiece("a3") == p;
    }

    public static void test2() {
        Board b = Board.theBoard();

        // initially register Pieces with Factories
		Piece.registerPiece(new KingFactory());
		Piece.registerPiece(new QueenFactory());
		Piece.registerPiece(new KnightFactory());
		Piece.registerPiece(new BishopFactory());
		Piece.registerPiece(new RookFactory());
		Piece.registerPiece(new PawnFactory());

        // two listeners to the list
        Logger listener = new Logger();
        b.registerListener(listener);
        b.registerListener(new Logger());

        // operate piece
        Piece bk = Piece.createPiece("bk");
        assert bk.color() == Color.BLACK;
        assert bk.color() != Color.WHITE;
        assert Objects.equals(bk.toString(), "bk");
        b.addPiece(bk, "c4");
        assert b.getPiece("c4") == bk;
        b.addPiece(Piece.createPiece("wq"), "b1");
        assert bk.moves(b, "c4").contains("c3");
        assert !bk.moves(b, "c4").contains("c1");
        b.movePiece("c4", "c3");
        b.removeListener(listener);
        b.removeAllListeners();
        b.clear();
    }

    public static void main(String[] args) {
        test1();
        test2();
    }

}