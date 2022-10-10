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
        return color.getColorStr()+"b";
    }

    public List<String> moves(Board b, String loc) {
//	throw new UnsupportedOperationException();
        int[] locArray = Helper.getLocArray(loc);
        List<String> retList = new ArrayList<>();

        // find all valid moves
        Map<String, Boolean> isBlocked=new HashMap<>();
        isBlocked.put("lup", Boolean.FALSE);
        isBlocked.put("ldown", Boolean.FALSE);
        isBlocked.put("rup", Boolean.FALSE);
        isBlocked.put("rdown", Boolean.FALSE);

        // 4 path with different direction, stop until blocked
        for(int i = 1;i<8;i++) {
            //# region : diagonal: lup, ldown, rup, rdown
            // lup -i,+i
            if (locArray[0]-i >= 0 && locArray[1]+i < 8) {
            String lupLoc = Helper.getLocStr(locArray[0]-i, locArray[1]+i);
            if (!isBlocked.get("lup"))
                if (b.isOccupied(lupLoc) == null) {
                    // empty at lup
                    retList.add(lupLoc);
                } else if (! color.getColorStr().equals(b.isOccupied(lupLoc))) {
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
                } else if (!Objects.equals(b.isOccupied(ldownLoc), color.getColorStr())) {
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
                } else if (!color.getColorStr().equals(b.isOccupied(rupLoc))) {
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
                } else if (!color.getColorStr().equals(b.isOccupied(rdownLoc))) {
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