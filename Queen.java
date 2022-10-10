import java.util.*;

public class Queen extends Piece {
    public Queen(Color c) {
        this.color = c;
        // throw new UnsupportedOperationException();
    }
    // implement appropriate methods

    public String toString() {
        // throw new UnsupportedOperationException();
        if (color==null)
            throw new UnsupportedOperationException();
        return color.getColorStr()+"q";
    }


    public List<String> moves(Board b, String loc) {
        // throw new UnsupportedOperationException();
        int[] locArray = Helper.getLocArray(loc);
        List<String> retList = new ArrayList<>();

        // find all valid moves
        Map<String, Boolean> isBlocked=new HashMap<>();
        isBlocked.put("left", Boolean.FALSE);
        isBlocked.put("right", Boolean.FALSE);
        isBlocked.put("up", Boolean.FALSE);
        isBlocked.put("down", Boolean.FALSE);
        isBlocked.put("lup", Boolean.FALSE);
        isBlocked.put("ldown", Boolean.FALSE);
        isBlocked.put("rup", Boolean.FALSE);
        isBlocked.put("rdown", Boolean.FALSE);

        // 8 path with different direction, stop until blocked
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

            //# region : diagonal: lup, ldown, rup, rdown
            // lup -i,+i
            if (locArray[0]-i >= 0 && locArray[1]+i < 8) {
                String lupLoc = Helper.getLocStr(locArray[0]-i, locArray[1]+i);
                if (!isBlocked.get("lup"))
                    if (b.isOccupied(lupLoc) == null) {
                        // empty at lup
                        retList.add(lupLoc);
                    } else if (!b.isOccupied(lupLoc).equals(color.getColorStr())) {
                        // enemy at lup
                        retList.add(lupLoc);
                        isBlocked.put("lup", Boolean.TRUE);
                    } else {
                        // same color at lup
                        isBlocked.put("lup", Boolean.TRUE);
                    }
            }
            // ldown -i,-i
            if (locArray[0]-i >= 0 && locArray[1]-i >= 0) {
                String ldownLoc = Helper.getLocStr(locArray[0]-i, locArray[1]-i);
                if (!isBlocked.get("ldown"))
                    if (b.isOccupied(ldownLoc) == null) {
                        // empty at ldown
                        retList.add(ldownLoc);
                    } else if (!b.isOccupied(ldownLoc).equals(color.getColorStr())) {
                        // enemy at ldown
                        retList.add(ldownLoc);
                        isBlocked.put("ldown", Boolean.TRUE);
                    } else {
                        // same color at ldown
                        isBlocked.put("ldown", Boolean.TRUE);
                    }
            }
            // rup +i,+i
            if (locArray[0]+i < 8 && locArray[1]+i < 8) {
                String rupLoc = Helper.getLocStr(locArray[0]+i, locArray[1]+i);
                if (!isBlocked.get("rup"))
                    if (b.isOccupied(rupLoc) == null) {
                        // empty at rup
                        retList.add(rupLoc);
                    } else if (!b.isOccupied(rupLoc).equals(color.getColorStr())) {
                        // enemy at rup
                        retList.add(rupLoc);
                        isBlocked.put("rup", Boolean.TRUE);
                    } else {
                        // same color at rup
                        isBlocked.put("rup", Boolean.TRUE);
                    }
            }
            // rdown +i,-i
            if (locArray[0]+i < 8 && locArray[1]-i >= 0) {
                String rdownLoc = Helper.getLocStr(locArray[0]+i, locArray[1]-i);
                if (!isBlocked.get("rdown"))
                    if (b.isOccupied(rdownLoc) == null) {
                        // empty at rdown
                        retList.add(rdownLoc);
                    } else if (!b.isOccupied(rdownLoc).equals(color.getColorStr())) {
                        // enemy at rdown
                        retList.add(rdownLoc);
                        isBlocked.put("rdown", Boolean.TRUE);
                    } else {
                        // same color at rdown
                        isBlocked.put("rdown", Boolean.TRUE);
                    }
            }
            // #endregion
        }

        return retList;
    }

}