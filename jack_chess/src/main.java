
public class main {
    public static void main(String[] args) throws Exception {
        Board board = new Board();
        board.printBoard();
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