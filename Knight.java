import java.util.*;

public class Knight extends Piece {
    public Knight(Color c) {
        color = c;
//        throw new UnsupportedOperationException();
    }
    // implement appropriate methods

    public String toString() {
//	throw new UnsupportedOperationException();
        if (color==null)
            throw new UnsupportedOperationException();
        String s = color.getColorStr()+"n";
        return s;
    }

    public List<String> moves(Board b, String loc) {
//	throw new UnsupportedOperationException();
        int[] locArray = Helper.getLocArray(loc);
        List<String> retList = new ArrayList<>();

        // valid moves
        for(int i: new int[]{2,-2}) {
            for (int j: new int[]{1,-1}) {
                if (locArray[0]+i>=0 && locArray[0]+i <8 && locArray[1]+j>=0 && locArray[1]+j <8)
                    retList.add(Helper.getLocStr(locArray[0]+i,locArray[1]+j));
            }
        }

        for(int j: new int[]{2,-2}) {
            for (int i: new int[]{1,-1}) {
                if (locArray[0]+i>=0 && locArray[0]+i <8 && locArray[1]+j>=0 && locArray[1]+j <8)
                    retList.add(Helper.getLocStr(locArray[0]+i,locArray[1]+j));
            }
        }

        return retList;
    }

}