public class Helper {
    // char column -> int from 0 (with input check)
    public static int column2int(char column) {
        int temp = column;
        int temp_integer = 97; // for lower case only: begin from 0

        if (temp <= 105 && temp >= 97) {
            return (temp - temp_integer);
        } else {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    // String loc -> int[] both from 0
    public static int[] getLocArray(String loc){
        int i = column2int(loc.charAt(0));
        int j = loc.charAt(1) - '1';

        return new int[] {i,j};
    }

    // int, int -> String loc
    public static String getLocStr(int col, int row){
        char i = "abcdefgh".charAt(col);
        char j = "12345678".charAt(row);

        return (""+i+j);
    }


    // 'b/w' -> Color
    public static Color getColor(char c) {
        return switch (c) {
            case 'b' -> Color.BLACK;
            case 'w' -> Color.WHITE;
            default -> throw new UnsupportedOperationException();
        };
    }

    // print possible moves
    public static void printMoves(Board b, String loc){
        Piece p = b.getPiece(loc);
        System.out.println("Possible moves of "+p.toString()+" at "+loc+": ");
        for(String move: p.moves(b, loc)){
            System.out.println(move);
        }
    }

}
