import java.awt.*;

public class main {
    public static void main(String[] args) {
        Board board = new Board();
        board.printBoard();
        board.movePiece(new ChessCoordinate('G',1), new ChessCoordinate('F',3));

    }


}