import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Chess {
	public static void main(String[] args) {
		if (args.length != 2) {
			System.out.println("Usage: java Chess layout moves");
		}

		// initially register Pieces with Factories
		Piece.registerPiece(new KingFactory());
		Piece.registerPiece(new QueenFactory());
		Piece.registerPiece(new KnightFactory());
		Piece.registerPiece(new BishopFactory());
		Piece.registerPiece(new RookFactory());
		Piece.registerPiece(new PawnFactory());
		Board.theBoard().registerListener(new Logger());

		// args[0] is the layout file name
		// args[1] is the moves file name
		// Put your code to read the layout file and moves files
		// here.
		File layout = new File(args[0]);
		File moves = new File(args[1]);
		try {
			// read layout
			Scanner myReader = new Scanner(layout);
			while (myReader.hasNextLine()) {
				String line = myReader.nextLine();
				if (line.startsWith("#")) {
					// not read the layout input beginning with '#'
					continue;
				}
				// do sth
				String[] splitArray = line.split("=",2);
				Piece p = Piece.createPiece(splitArray[1]);
//				System.out.println(p.toString()+" at "+splitArray[0]);
				Board.theBoard().addPiece(p, splitArray[0]);
			}

			// print original board
//			System.out.println("Original board:");
//			Board.theBoard().iterate(new BoardPrinter());
			for(String loc: new String[] {"b7","d7","b1","e1","h1","f1"})
				Helper.printMoves(Board.theBoard(), loc);

			// read moves
			myReader = new Scanner(moves);
			while (myReader.hasNextLine()) {
				String line = myReader.nextLine();
				if (line.startsWith("#")) {
					continue;
				}
				// do sth
				String[] splitArray = line.split("-",2);
				Board.theBoard().movePiece(splitArray[0],splitArray[1]);
			}
			myReader.close();
		} catch (FileNotFoundException e) {
			System.out.println("An error occurred while reading the file.");
			e.printStackTrace();
		}

		// Leave the following code at the end of the simulation:
		System.out.println("Final board:");
		Board.theBoard().iterate(new BoardPrinter());
	}
}