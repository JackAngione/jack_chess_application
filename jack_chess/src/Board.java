import java.io.PrintWriter;
import java.util.HashMap;
import java.awt.Point;
public class Board {
    ChessPiece[][] pieces = new ChessPiece[8][8];

    //move status codes
    final int INVALID_MOVE = 0;
    HashMap<String, Character> pieceSymbol = new HashMap<>();
    //white = true, black = false
    boolean turnColor = true;

    public Board()
    {
        //setup pieces names
        pieceSymbol.put("Rook", 'R');
        pieceSymbol.put("Knight", 'k');
        pieceSymbol.put("Bishop", 'B');
        pieceSymbol.put("Queen", 'Q');
        pieceSymbol.put("King", 'K');
        pieceSymbol.put("Pawn", 'P');

        Rook testPiece = new Rook(true,0,0);
        //initialize white pieces
        pieces[0][0]= new Rook(true,0,0);
        pieces[1][0]= new Knight(true,1,0);
        pieces[2][0]= new Bishop(true,2,0);
        pieces[3][0]= new Queen(true,3,0);
        pieces[4][0]= new King(true,4,0);
        pieces[5][0]= new Bishop(true,5,0);
        pieces[6][0]= new Knight(true,6,0);
        pieces[7][0]= new Rook(true,7,0);
        //white pawns
        pieces[0][1]= new Pawn(true,0,1);
        pieces[1][1]= new Pawn(true,1,1);
        pieces[2][1]= new Pawn(true,2,1);
        pieces[3][1]= new Pawn(true,3,1);
        pieces[4][1]= new Pawn(true,4,1);
        pieces[5][1]= new Pawn(true,5,1);
        pieces[6][1]= new Pawn(true,6,1);
        pieces[7][1]= new Pawn(true,7,1);

        //initialize black pieces
        pieces[0][7]= new Rook(false,0,7);
        pieces[1][7]= new Knight(false,1,7);
        pieces[2][7]= new Bishop(false,2,7);
        pieces[3][7]= new Queen(false,3,7);
        pieces[4][7]= new King(false,4,7);
        pieces[5][7]= new Bishop(false,5,7);
        pieces[6][7]= new Knight(false,6,7);
        pieces[7][7]= new Rook(false,7,7);

        //black pawns
        pieces[0][6]= new Pawn(false,0,6);
        pieces[1][6]= new Pawn(false,1,6);
        pieces[2][6]= new Pawn(false,2,6);
        pieces[3][6]= new Pawn(false,3,6);
        pieces[4][6]= new Pawn(false,4,6);
        pieces[5][6]= new Pawn(false,5,6);
        pieces[6][6]= new Pawn(false,6,6);
        pieces[7][6]= new Pawn(false,7,6);
        System.out.println(testPiece.getName());
    }
    public void movePiece(ChessCoordinate source, ChessCoordinate destination)
    {
       //TODO MAKE SURE COORDINATES ARE VALID

        ChessPiece sourcePiece = this.pieces[source.getRawX()][source.getRawY()];
        System.out.println("source piece name: " + sourcePiece.getColorString());
        System.out.println("source piece location: (" + source.getX()+", " + source.getY() + ")");
        System.out.println("Destination location: (" + destination.getX()+", " + (destination.getY()) + ")");
        //quit if attempting to capture enemy piece

        //if piece at source is of proper color
        if(sourcePiece.getColor() == this.turnColor)
        {
            //check if move is valid
            if(sourcePiece.move(this.pieces, destination) == move_status.MOVE)
            {
                //piece was moved
                process_Move_Capture(sourcePiece, source, destination);
                this.turnColor = !this.turnColor;
                this.printBoard();
            }
            else {
                this.printBoard();
                System.out.println("piece move was invalid, try again");
            }
        }
        else {
            //wrong color
            this.printBoard();
            System.out.println("cannot move a piece of opposite color");
        }
    }
    public void printBoard()
    {
        for(int j = 7; j>=0; j--)
        {
            for(int i = 0; i<= 7; i++)
            {
                if(this.pieces[i][j] == null)
                {
                    System.out.print("  ");
                }
                else {
                   System.out.print(pieceSymbol.get(this.pieces[i][j].getName()) + " ");
                }
            }
            System.out.println();
        }
    }
    public void process_Move_Capture( ChessPiece sourcePiece, ChessCoordinate source, ChessCoordinate destination)
    {
        //if there is an enemy piece on the destination, remove it
        try
        {
            if(pieces[destination.getRawX()][destination.getRawY()].getColor() == this.turnColor)
            {
                System.out.println("can't capture piece of same color");
            }
            else
            {
                //move like normal
                //set old spot to null
                this.pieces[source.getRawX()][source.getRawY()] = null;
                //set new spot to the piece
                this.pieces[destination.getRawX()][destination.getRawY()] = sourcePiece;
                //swap turn color
                System.out.println("piece successfully moved");
            }
        }
        catch(NullPointerException e)
        {

            //capture has taken place
            //TODO ADD POINTS FEATURE WHEN CAPTURED
            //move like normal
            //set old spot to null
            this.pieces[source.getRawX()][source.getRawY()] = null;
            //set new spot to the piece
            this.pieces[destination.getRawX()][destination.getRawY()] = sourcePiece;
            //swap turn color
            System.out.println("enemy piece captured");
        }

    }
}
