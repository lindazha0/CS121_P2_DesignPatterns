import java.io.*; // Import the File class & FileNotFoundException
// import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files

public class Try {
    public static void main(String[] args) {
        // readFiles(args);
        String str = "abcdefgh";
        int temp_integer = 96; // for lower case
        for (char c : str.toCharArray()) {
            int temp = (int) c;
            if (temp <= 122 & temp >= 97)
                System.out.print(temp - temp_integer);
        }
    }

    public static void readFiles(String[] args) {
        File layout = new File(args[0]);
        File moves = new File(args[1]);
        try {
            // read layout
            Scanner myReader = new Scanner(layout);
            while (myReader.hasNextLine()) {
                String line = myReader.nextLine();
                if (line.startsWith("#")) {
                    continue;
                }
                // do sth
                System.out.println(line);
            }

            System.out.println("\n");
            // read moves
            myReader = new Scanner(moves);
            while (myReader.hasNextLine()) {
                String line = myReader.nextLine();
                if (line.startsWith("#")) {
                    continue;
                }
                // do sth
                System.out.println(line);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred while reading the file.");
            e.printStackTrace();
        }
    }
}
