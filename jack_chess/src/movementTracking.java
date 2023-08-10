public class movementTracking {
    public static void main(String[] args) {
        int[][] board = new int[8][8];
        board[2][4] = 1;
        board[3][4] = 2;
        board[4][4] = 1;
        board[7][1] = 2;
        board[1][3] = 1;
        board[2][6] = 1;
        board[1][1] = 2;
        board[0][7] = 1;

        //loop through entire board
        for(int j = 7; j>=0; j--)
        {
            for(int i = 0; i<= 7; i++)
            {

                    System.out.print(board[i][j] + "  ");
            }
            System.out.println();
        }
        BishopTracking(board, new ChessCoordinate('B',2), new ChessCoordinate('E',5));
    }
    public static ChessCoordinate RookTracking(int[][] board, ChessCoordinate source, ChessCoordinate destination)
    {
        //test if a rooke piece will run into any other pieces

        //vetical line
        if(destination.getRawX() == source.getRawX())
        {
            System.out.println("moving in vertical line from " + source.getRawY() + " to " + destination.getRawY());
            for(int i = Math.min(source.getRawY(), destination.getRawY()); i <= Math.max(source.getRawY(), destination.getRawY()); i++)
            {
                //start at the lower point of the two, draw a line to the higher point
                if(board[source.getRawX()][i] != 0 && i != source.getRawY())
                {
                    //hit piece
                    System.out.println("rooke hit a piece");
                    //TODO check if piece is white or black
                    //TODO RETURN COORDINATES OF PIECES TO TAKE
                    //TODO THROW ERROR IF IT HITS A SAME COLOR PIECE
                }
            }
        }
        //horizontal line
        else {
            for(int i = Math.min(source.getRawX(), destination.getRawX()); i <= Math.max(source.getRawX(), destination.getRawX()); i++)
            {
                //start at the lower point of the two, draw a line to the higher point
                if(board[source.getRawY()][i] != 0 && i != source.getRawX())
                {
                    //hit piece
                    System.out.println("rooke hit a piece");
                    //TODO check if piece is white or black
                    //TODO RETURN COORDINATE OF PIECE TO TAKE
                    //TODO THROW ERROR IF IT HITS A SAME COLOR PIECE
                }
            }
        }

        return new ChessCoordinate('A', 1);
    }
    //return true if piece is good to move or capture
    //return false if there is a piece in between source and destination, thus making it an invalid move
    public static boolean BishopTracking(int[][] board, ChessCoordinate source, ChessCoordinate destination)
    {
            //int yStart= Math.source.getRawY();
            //moving left to right
            int xCursor = source.getRawX();
            int yCursor = source.getRawY();

            while(xCursor != destination.getRawX() && yCursor!= destination.getRawY())
            {
                System.out.println("Cursor: (" + xCursor + ", " + yCursor + ")");
                //check for colliosion
                if(board[xCursor][yCursor] != 0 && (xCursor != source.getRawX() && yCursor != source.getRawY()))
                {
                    System.out.println("there is a piece in the way!");
                    return false;
                }

                //MOVE X CURSOR
                if(destination.getRawX()< source.getRawX())
                {
                    //move x to the left
                    xCursor--;
                }
                else
                {
                    //move x to the right
                    xCursor++;
                }
                //MOVE Y CURSOR
                if(destination.getRawY() > source.getRawY())
                {
                    //move y up
                    yCursor++;
                }
                else
                {
                    //move y down
                    yCursor--;
                }
            }
        return true;
    }

}