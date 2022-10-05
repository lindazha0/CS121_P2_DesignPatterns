public class Helper {
    // char column -> int from 0 (with input check)
    public int column2int(char colume) {
        int temp = (int) String.valueOf(colume).toLowerCase().chatAt(0);
        int temp_integer = 97; // for lower case only: begin from 0

        if (temp <= 122 & temp >= 97) {
            return (temp - temp_integer);
        } else {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    // String loc -> int[] both from 0
    public int[] getLocArray(String loc){
        int i = column2int(loc.charAt(0));
        int j = loc.charAt(1) - '1';

        return [i,j];
    }

    // 'b/w' -> Color
    public Color getColor(char c) {
        switch (c) {
            case 'b':
                return Color.BLACK;
            case 'w':
                return Color.WHITE;
            default:
                return null;
        }
    }

}
