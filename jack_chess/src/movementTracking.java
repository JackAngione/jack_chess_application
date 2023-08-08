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
        RookTracking(board, new ChessCoordinate('B',2), new ChessCoordinate('H',2));
    }
    public static ChessCoordinate RookTracking(int[][] board, ChessCoordinate source, ChessCoordinate destination)
    {
        //test if a rooke piece will run into any other pieces

        //vetical line
        if(destination.getRawX() == source.getRawX())
        {
            System.out.println("moving in vertical line from " + source.getRawY() + " to " + destination.getRawY());
            for(int i = Math.min(source.getRawY(), destination.getRawY()); i<=Math.max(source.getRawY(), destination.getRawY()); i++)
            {
                //start at the lower point of the two, draw a line to the higher point
                if(board[source.getRawX()][i] != 0 && i != source.getRawY())
                {
                    //hit piece
                    System.out.println("rooke hit a piece");
                    //TODO check if piece is white or black
                    //TODO RETURN COORDINATE OF PIECE TO TAKE
                }
            }
        }
        //horizontal line
        else {
            for(int i = Math.min(source.getRawX(), destination.getRawX()); i<=Math.max(source.getRawX(), destination.getRawX()); i++)
            {
                //start at the lower point of the two, draw a line to the higher point
                if(board[source.getRawY()][i] != 0 && i != source.getRawX())
                {
                    //hit piece
                    System.out.println("rooke hit a piece");
                    //TODO check if piece is white or black
                    //TODO RETURN COORDINATE OF PIECE TO TAKE

                }
            }
        }

        return new ChessCoordinate('A', 1);
    }


}