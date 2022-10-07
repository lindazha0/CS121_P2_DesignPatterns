import java.util.*;

public class Queen extends Piece {
    public Queen(Color c) {
        this.color = c;
        // throw new UnsupportedOperationException();
    }
    // implement appropriate methods

    public String toString() {
//        throw new UnsupportedOperationException();
        if (color==null)
            throw new UnsupportedOperationException();
        return color.getColorStr()+"q";
    }


    public List<String> moves(Board b, String loc) {
//        throw new UnsupportedOperationException();
        int[] locArray = Helper.getLocArray(loc);
        List<String> retList = new ArrayList<>();

        // valid moves
        for(int i = 0;i<8;i++) {
            // horizontal & vertical
            if(i!=locArray[0]){
                retList.add(Helper.getLocStr(i,locArray[1]));
                if(locArray[0]+locArray[1]-i>=0 && locArray[0]+locArray[1]-i<8)
                    retList.add(Helper.getLocStr(i,locArray[0]+locArray[1]-i));
                if(locArray[0]-locArray[1]+i>=0 && locArray[0]-locArray[1]+i<8)
                    retList.add(Helper.getLocStr(i,locArray[0]-locArray[1]+i));
            }
            if(i!=locArray[1])
                retList.add(Helper.getLocStr(locArray[0],i));
            // diagonal

        }

        return retList;
    }

}