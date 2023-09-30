import java.util.Scanner;

public class main {
    public static void main(String[] args) throws Exception {
        Board board = new Board();
        board.printBoard();

        System.out.println("Instructions: Enter the source of the piece you want to move, and it's destination separated by a space");
        System.out.println("Example: A2 B3");
        Scanner user_input = new Scanner(System.in);
        int move_counter = 1;
        //TODO MAKE LOOP STOP WHEN CHESS BOARD IS OVER
        while(move_counter<200)
        {
            System.out.print("Move " + move_counter + ": ");
            String next_move = user_input.nextLine();
            try
            {
                String[] src_dst = next_move.split(" ");
                String[] source_coord = src_dst[0].split("(?<=\\D)(?=\\d)|(?<=\\d)(?=\\D)");
                String[] destination_coord = src_dst[1].split("(?<=\\D)(?=\\d)|(?<=\\d)(?=\\D)");
                
                board.movePiece(new ChessCoordinate(source_coord[0].toCharArray()[0], Integer.parseInt(source_coord[1])),
                        new ChessCoordinate(destination_coord[0].toCharArray()[0], Integer.parseInt(destination_coord[1])));
                move_counter++;
            }
            catch (Exception invalidInput)
            {
                System.out.println("Invalid Move, try again");
            }
        }

        //TEST GAMES
        //PUT OWN PIECE IN CHECK
        board.movePiece(new ChessCoordinate('E',2), new ChessCoordinate('E',4));
        board.movePiece(new ChessCoordinate('D',7), new ChessCoordinate('D',6));
        board.movePiece(new ChessCoordinate('G',2), new ChessCoordinate('G',3));
        board.movePiece(new ChessCoordinate('D',2), new ChessCoordinate('D',4));
        board.movePiece(new ChessCoordinate('C',8), new ChessCoordinate('G',4));
        board.movePiece(new ChessCoordinate('E',1), new ChessCoordinate('E',2));
        /*

        //BISHOP TRACKING
        board.movePiece(new ChessCoordinate('D',2), new ChessCoordinate('D',4));

        board.movePiece(new ChessCoordinate('E',7), new ChessCoordinate('E',5));

        board.movePiece(new ChessCoordinate('C',1), new ChessCoordinate('F',4));

        board.movePiece(new ChessCoordinate('D',8), new ChessCoordinate('F',6));

        board.movePiece(new ChessCoordinate('F',4), new ChessCoordinate('E',5));

        //QUEEN KING CHECK TESTING
        board.movePiece(new ChessCoordinate('D',2), new ChessCoordinate('D',4));
        board.movePiece(new ChessCoordinate('F',7), new ChessCoordinate('F',5));
        board.movePiece(new ChessCoordinate('D',1), new ChessCoordinate('D',3));
        board.movePiece(new ChessCoordinate('E',8), new ChessCoordinate('F',7));
        board.movePiece(new ChessCoordinate('D',3), new ChessCoordinate('C',4));
        board.movePiece(new ChessCoordinate('F',7), new ChessCoordinate('F',6));
        board.movePiece(new ChessCoordinate('C',4), new ChessCoordinate('C',6));


        //PAWN CHECK TESTING
        board.movePiece(new ChessCoordinate('F',2), new ChessCoordinate('F',4));
        board.movePiece(new ChessCoordinate('G',7), new ChessCoordinate('G',6));
        board.movePiece(new ChessCoordinate('G',1), new ChessCoordinate('H',3));
        board.movePiece(new ChessCoordinate('G',6), new ChessCoordinate('G',5));
        board.movePiece(new ChessCoordinate('H',3), new ChessCoordinate('G',5));
        board.movePiece(new ChessCoordinate('H',7), new ChessCoordinate('H',6));
        board.movePiece(new ChessCoordinate('G',5), new ChessCoordinate('F',7));
        board.movePiece(new ChessCoordinate('H',8), new ChessCoordinate('H',7));
        board.movePiece(new ChessCoordinate('F',7), new ChessCoordinate('E',5));
        board.movePiece(new ChessCoordinate('E',7), new ChessCoordinate('E',6));
        board.movePiece(new ChessCoordinate('F',4), new ChessCoordinate('F',5));
        board.movePiece(new ChessCoordinate('D',7), new ChessCoordinate('D',6));
        board.movePiece(new ChessCoordinate('F',5), new ChessCoordinate('F',6));
        board.movePiece(new ChessCoordinate('D',8), new ChessCoordinate('D',7));
        board.movePiece(new ChessCoordinate('F',6), new ChessCoordinate('F',7));
        //KNIGHT CHECK TESTING
        board.movePiece(new ChessCoordinate('B',1), new ChessCoordinate('C',3));
        board.movePiece(new ChessCoordinate('E',7), new ChessCoordinate('E',5));
        board.movePiece(new ChessCoordinate('C',3), new ChessCoordinate('D',5));
        board.movePiece(new ChessCoordinate('F',7), new ChessCoordinate('F',6));
        board.movePiece(new ChessCoordinate('D',5), new ChessCoordinate('C',7));
        //QUEEN and KING tracking
        board.movePiece(new ChessCoordinate('D',2), new ChessCoordinate('D',4));

        board.movePiece(new ChessCoordinate('E',7), new ChessCoordinate('E',5));

        board.movePiece(new ChessCoordinate('D',1), new ChessCoordinate('D',3));

        board.movePiece(new ChessCoordinate('E',8), new ChessCoordinate('E',7));

        board.movePiece(new ChessCoordinate('D',3), new ChessCoordinate('E',3));

        board.movePiece(new ChessCoordinate('E',7), new ChessCoordinate('F',6));

        board.movePiece(new ChessCoordinate('E',3), new ChessCoordinate('E',5));

        board.movePiece(new ChessCoordinate('F',6), new ChessCoordinate('F',7));

        board.movePiece(new ChessCoordinate('E',5), new ChessCoordinate('C',7));
        */

        //TODO test rook capturing enemy piece

        /* //ROOK TRACKING
        board.movePiece(new ChessCoordinate('A',2), new ChessCoordinate('A',4));

        board.movePiece(new ChessCoordinate('D',7), new ChessCoordinate('D',5));

        board.movePiece(new ChessCoordinate('A',1), new ChessCoordinate('A',3));*/
        
        /* //white pawn capture black pawn
        board.movePiece(new ChessCoordinate('D',2), new ChessCoordinate('D',4));
        board.movePiece(new ChessCoordinate('C',7), new ChessCoordinate('C',5));
        board.movePiece(new ChessCoordinate('D', 4), new ChessCoordinate('C', 5));
        */
        /*
        board.movePiece(new ChessCoordinate('D',2), new ChessCoordinate('D',4));

        board.movePiece(new ChessCoordinate('C',7), new ChessCoordinate('C',5));

        board.movePiece(new ChessCoordinate('C',1), new ChessCoordinate('E',3));

        board.movePiece(new ChessCoordinate('G',7), new ChessCoordinate('G',6));

        board.movePiece(new ChessCoordinate('E',3), new ChessCoordinate('D',4));

         */
    }
}