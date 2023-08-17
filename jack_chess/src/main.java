
public class main {
    public static void main(String[] args) {
        Board board = new Board();
        board.printBoard();
        //TEST GAMES

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