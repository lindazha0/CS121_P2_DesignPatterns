import java.util.*;

abstract public class Piece {
    public static HashMap<Character, PieceFactory> pf_map = new HashMap<>();
    protected Color color;

    public static void registerPiece(PieceFactory pf) {
        Character pf_key = pf.symbol();
        pf_map.put(pf_key, pf);
//        throw new UnsupportedOperationException();
    }

    public static Piece createPiece(String name) {
        Character pf_key = name.charAt(1);
        Color color = Helper.getColor(name.charAt(0));

        return pf_map.get(pf_key).create(color);
//        throw new UnsupportedOperationException();
    }

    public Color color() {
        // You should write code here and just inherit it in
        // subclasses. For this to work, you should know
        // that subclasses can access superclass fields.
        if (color==null)
            throw new UnsupportedOperationException();
        return color;
    }

    abstract public String toString();

    abstract public List<String> moves(Board b, String loc);
}