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
//	throw new UnsupportedOperationException();
        int[] locArray = Helper.getLocArray(loc);
        List<String> retList = new ArrayList<>();

        // valid moves
        for(int i = 0;i<8;i++) {
            if(locArray[0]+locArray[1]-i>=0 && locArray[0]+locArray[1]-i<8)
                retList.add(Helper.getLocStr(i,locArray[0]+locArray[1]-i));

            if(locArray[0]-locArray[1]+i>=0 && locArray[0]-locArray[1]+i<8)
                retList.add(Helper.getLocStr(i,locArray[0]-locArray[1]+i));
        }

        return retList;
    }

}