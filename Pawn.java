import java.util.*;

public class Pawn extends Piece {
    public Pawn(Color c) {
        color=c;
//        throw new UnsupportedOperationException();
    }
    // implement appropriate methods

    public String toString() {
//        throw new UnsupportedOperationException();
        if (color==null)
            throw new UnsupportedOperationException();
        String s = color.getColorStr()+"p";
        return s;
    }

    public List<String> moves(Board b, String loc) {
//        throw new UnsupportedOperationException();
        if (color==null)
            throw new UnsupportedOperationException();
        int[] locArray = Helper.getLocArray(loc);
        List<String> retList = new ArrayList<>();

        // valid moves
        if(color.getColorStr()=="b"){
//            black

            // 1 step vertically
            if(locArray[1]>0)
                retList.add(Helper.getLocStr(locArray[0],locArray[1]-1));

            // 2 step vertically
            if(locArray[1]==6){
                if(b.isOccupied(Helper.getLocStr(locArray[0],5))==null &&
                        b.isOccupied(Helper.getLocStr(locArray[0],4))==null)
                    retList.add(Helper.getLocStr(locArray[0],4));
            }

            // diagonally capture
            for(int i: new int[]{1,-1}) {
                for (int j: new int[]{1,-1}) {
                    if (locArray[0]+i>=0 && locArray[0]+i <8 && locArray[1]+j>=0 && locArray[1]+j <8){
                        String dest = Helper.getLocStr(locArray[0]+i,locArray[1]+j);
                        if(b.isOccupied(dest)=="w")
                            retList.add(dest);
                    }
                }
            }
        }else {
//            white

            // 1 step vertically
            if (locArray[1] < 7)
                retList.add(Helper.getLocStr(locArray[0], locArray[1] + 1));

            // 2 step vertically
            if (locArray[1] == 1) {
                if (b.isOccupied(Helper.getLocStr(locArray[0], 2)) == null &&
                        b.isOccupied(Helper.getLocStr(locArray[0], 3)) == null)
                    retList.add(Helper.getLocStr(locArray[0], 3));
            }

            // diagonally capture
            for(int i: new int[]{1,-1}) {
                for (int j: new int[]{1,-1}) {
                    if (locArray[0]+i>=0 && locArray[0]+i <8 && locArray[1]+j>=0 && locArray[1]+j <8){
                        String dest = Helper.getLocStr(locArray[0]+i,locArray[1]+j);
                        if(b.isOccupied(dest)=="b")
                            retList.add(dest);
                    }
                }
            }
        }

        return retList;
    }


}