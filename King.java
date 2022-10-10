import java.util.*;

public class King extends Piece {
    public King(Color c) {
        this.color = c;
//        throw new UnsupportedOperationException()
    }
    // implement appropriate methods

    public String toString() {
        if (color==null)
        	throw new UnsupportedOperationException();
        String s = this.color.getColorStr()+"k";
        return s;
    }

    public List<String> moves(Board b, String loc) {
        int[] locArray = Helper.getLocArray(loc);
        List<String> retList = new ArrayList<>();

        // valid moves
        for(int i=Math.max(0,locArray[0]-1);i<=Math.min(locArray[0]+1,7);i++) {
            for (int j = Math.max(0,locArray[1]-1); j <=Math.min(locArray[1] + 1,7); j++) {
                if(color.getColorStr().equals(b.isOccupied(Helper.getLocStr(i,j))) && (i!=locArray[0] || j!=locArray[1])) {
                    retList.add(Helper.getLocStr(i,j));
                }
            }
        }

        return retList;
//	throw new UnsupportedOperationException();
    }

}