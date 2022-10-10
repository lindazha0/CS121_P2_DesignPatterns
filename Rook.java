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
        return color.getColorStr()+"r";
    }

    public List<String> moves(Board b, String loc) {
//	throw new UnsupportedOperationException();
        int[] locArray = Helper.getLocArray(loc);
        List<String> retList = new ArrayList<>();

        // find all valid moves
        Map<String, Boolean> isBlocked=new HashMap<>();
        isBlocked.put("left", Boolean.FALSE);
        isBlocked.put("right", Boolean.FALSE);
        isBlocked.put("up", Boolean.FALSE);
        isBlocked.put("down", Boolean.FALSE);


        // 4 path with different direction, stop until blocked
        for(int i = 1;i<8;i++) {
            // horizontal: to left & right
            // left -i
            if (locArray[0] >= i) {
                String leftLoc = Helper.getLocStr(locArray[0] - i, locArray[1]);
                if (!isBlocked.get("left"))
                    if (b.isOccupied(leftLoc) == null) {
                        // empty at left
                        retList.add(leftLoc);
                    } else if (!b.isOccupied(leftLoc).equals(color.getColorStr())) {
                        // enemy at left
                        retList.add(leftLoc);
                        isBlocked.put("left", Boolean.TRUE);
                    } else {
                        // same color at left
                        isBlocked.put("left", Boolean.TRUE);
                    }
            }
            // right +i
            if (locArray[0]+i < 8) {
                String rightLoc = Helper.getLocStr(locArray[0] + i, locArray[1]);
                if (!isBlocked.get("right"))
                    if (b.isOccupied(rightLoc) == null) {
                        // empty at right
                        retList.add(rightLoc);
                    } else if (!b.isOccupied(rightLoc).equals(color.getColorStr())) {
                        // enemy at right
                        retList.add(rightLoc);
                        isBlocked.put("right", Boolean.TRUE);
                    } else {
                        // same color at right
                        isBlocked.put("right", Boolean.TRUE);
                    }
            }
            // vertical: up & down
            // up +1
            if (locArray[1]+i < 8) {
                String upLoc = Helper.getLocStr(locArray[0], locArray[1] + i);
                if (!isBlocked.get("up"))
                    if (b.isOccupied(upLoc) == null) {
                        // empty at up
                        retList.add(upLoc);
                    } else if (!b.isOccupied(upLoc).equals(color.getColorStr())) {
                        // enemy at up
                        retList.add(upLoc);
                        isBlocked.put("up", Boolean.TRUE);
                    } else {
                        // same color at up
                        isBlocked.put("up", Boolean.TRUE);
                    }
            }
            // down -1
            if (locArray[1]-i >= 0) {
                String downLoc = Helper.getLocStr(locArray[0], locArray[1] - i);
                if (!isBlocked.get("down"))
                    if (b.isOccupied(downLoc) == null) {
                        // empty at down
                        retList.add(downLoc);
                    } else if (!b.isOccupied(downLoc).equals(color.getColorStr())) {
                        // enemy at down
                        retList.add(downLoc);
                        isBlocked.put("down", Boolean.TRUE);
                    } else {
                        // same color at down
                        isBlocked.put("down", Boolean.TRUE);
                    }
            }
        }


        return retList;
    }


}