import java.util.*;

public class Rook extends Piece {
    public Rook(Color c) {
        this.color=c;
//        throw new UnsupportedOperationException();
    }
    // implement appropriate methods

    public String toString() {
//	throw new UnsupportedOperationException();
        if (color==null)
            throw new UnsupportedOperationException();
        String s = color.getColorStr()+"r";
        return s;
    }

    public List<String> moves(Board b, String loc) {
//	throw new UnsupportedOperationException();
        int[] locArray = Helper.getLocArray(loc);
        List<String> retList = new ArrayList<>();

        // valid moves
        for(int i = 0;i<8;i++) {
            // horizontal & vertical
            if(i!=locArray[0])
                retList.add(Helper.getLocStr(i,locArray[1]));
            if(i!=locArray[1])
                retList.add(Helper.getLocStr(locArray[0],i));
        }

        return retList;
    }


}