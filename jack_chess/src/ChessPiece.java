public abstract class ChessPiece {
    private final boolean color;
    private int pos_x;
    private int pos_y;
    String name;

    public ChessPiece(boolean color, int x, int y)
    {
        this.color = color;
        this.setX(x);
        this.setY(y);
    }
    public move_status move(ChessPiece[][] board, ChessCoordinate destination){
        move_status returnValue = isValidMove(board, destination);
        if(returnValue == move_status.INVALID)
        {
            return move_status.INVALID;

        }
        this.setX(destination.getRawX());
        this.setY(destination.getRawY());
        return move_status.MOVE;
    };
    public String getName()
    {
        return this.name;
    }
    public boolean getColor()
    {
        return this.color;
    }
    public int getX()
    {
        return this.pos_x;
    }
    public void setX(int x)
    {
        this.pos_x = x;
    }
    public void setY(int y)
    {
        this.pos_y = y;
    }
    public String getColorString()
    {
        if(this.color)
        {
            return "White";
        }
        else
        {
            return "Black";
        }
    }
    public int getY()
    {
        return this.pos_y;
    }

    abstract move_status isValidMove(ChessPiece[][] board, ChessCoordinate destination);

    abstract move_status collisionTracking(ChessPiece[][] board, ChessCoordinate destination);
    //TODO possibly make a getter for position
}

class King extends ChessPiece
{
    public King(boolean color, int x, int y)
    {
        super(color, x, y);
        this.name = "King";
    }
    @Override
    public move_status move(ChessPiece[][] board, ChessCoordinate destination) {
        move_status returnValue = isValidMove(board, destination);
        if(returnValue == move_status.INVALID)
        {
            return move_status.INVALID;

        }
        this.setX(destination.getRawX());
        this.setY(destination.getRawY());
        return move_status.MOVE;
    }

    //takes in where the piece wants to move
    @Override
    public move_status isValidMove(ChessPiece[][] board, ChessCoordinate destination) {
        //the x move is within one space
        if(Math.abs(this.getX()-destination.getRawX()) <= 1
                && Math.abs(this.getY()-destination.getRawY()) <= 1)
        {
            return move_status.MOVE;
        }
        return move_status.INVALID;
    }
    @Override
    move_status collisionTracking(ChessPiece[][] board, ChessCoordinate destination) {

        return move_status.MOVE;
    }

}

class Queen extends ChessPiece
{
    public Queen(boolean color, int x, int y)
    {
        super(color, x, y);
        this.name = "Queen";
    }

    //takes in where the piece wants to move
    @Override
    public move_status isValidMove(ChessPiece[][] board, ChessCoordinate destination) {
        if(destination.getRawX() == this.getX() || destination.getRawY() == this.getY())
        {
            //then movement is on axis, like a rook
            return rookStyleCollisionTracking(board, destination);
        }

        // Calculate the absolute differences in x and y coordinates
        int dx = Math.abs(destination.getRawX() - this.getX());
        int dy = Math.abs(destination.getRawY() - this.getY());

        // Check if the move is diagonal
        if(dx == dy) {
            return collisionTracking(board, destination);
        }
        return move_status.INVALID;
    }
    //collision tracking when queen is moving in rook style
    move_status rookStyleCollisionTracking(ChessPiece[][] board, ChessCoordinate destination)
    {
        System.out.println("queeen rook type tracking");
        int xCursor = Math.min(destination.getRawX(), this.getX());
        int yCursor = Math.min(destination.getRawY(), this.getY());

        while(xCursor != Math.max(destination.getRawX(), this.getX()) || yCursor != Math.max(destination.getRawY(), this.getY()))
        {
            if(board[xCursor][yCursor] != null
            && (xCursor != Math.min(destination.getRawX(), this.getX()) || yCursor != Math.min(destination.getRawY(), this.getY())))
            {
                System.out.println("piece is at: " + xCursor + ", " + yCursor);
                System.out.println("there is a piece in the way");
                return move_status.INVALID;
            }
            //move along y-axis
            if(this.getX() == destination.getRawX())
            {
                if(yCursor<destination.getRawY())
                {
                    //move ycursor up
                    yCursor += 1;
                }
                else
                {
                    //move ycursor down
                    yCursor -= 1;
                }
            }
            //move along x-axis
            else if(this.getY() == destination.getRawY())
            {
                if(xCursor<destination.getRawX())
                {
                    xCursor += 1;
                }
                else
                {
                    xCursor -= 1;
                }
            }

        }
        return move_status.MOVE;
    }
    //collision tracking when queen is moving in bishop style
    @Override
    move_status collisionTracking(ChessPiece[][] board, ChessCoordinate destination)
    {
        //int yStart= Math.source.getRawY();
        //moving left to right
        int xCursor = this.getX();
        int yCursor = this.getY();

        while(xCursor != destination.getRawX() && yCursor!= destination.getRawY())
        {
            System.out.println("Cursor: (" + xCursor + ", " + yCursor + ")");
            //check for colliosion
            if(board[xCursor][yCursor] != null && (xCursor != this.getX() && yCursor != this.getY()))
            {

                System.out.println("there is a piece in-between source and destination!");
                return move_status.INVALID;
            }

            //MOVE X CURSOR
            if(destination.getRawX()< this.getX())
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
            if(destination.getRawY() > this.getY())
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
        return move_status.MOVE;
    }
}


class Rook extends ChessPiece
{
    public Rook(boolean color, int x, int y)
    {
        super(color, x, y);
        this.name = "Rook";
    }

    //takes in where the piece wants to move
    @Override
    public move_status isValidMove(ChessPiece[][] board, ChessCoordinate destination) {

        if(destination.getRawX() == this.getX() || destination.getRawY() == this.getY())
        {
            //then movement is on axis
            return collisionTracking(board, destination);
        }
        return move_status.INVALID;
    }

    @Override
    move_status collisionTracking(ChessPiece[][] board, ChessCoordinate destination) {
        int xCursor = Math.min(destination.getRawX(), this.getX());
        int yCursor = Math.min(destination.getRawY(), this.getY());

        while(xCursor != Math.max(destination.getRawX(), this.getX()) || yCursor != Math.max(destination.getRawY(), this.getY()))
        {
            if(board[xCursor][yCursor] != null
                    && (xCursor != Math.min(destination.getRawX(), this.getX()) || yCursor != Math.min(destination.getRawY(), this.getY())))
            {
                System.out.println("piece is at: " + xCursor + ", " + yCursor);
                System.out.println("there is a piece in the way");
                return move_status.INVALID;
            }
            //move along y-axis
            if(this.getX() == destination.getRawX())
            {
                if(yCursor<destination.getRawY())
                {
                    //move ycursor up
                    yCursor += 1;
                }
                else
                {
                    //move ycursor down
                    yCursor -= 1;
                }
            }
            //move along x-axis
            else if(this.getY() == destination.getRawY())
            {
                if(xCursor<destination.getRawX())
                {
                    xCursor += 1;
                }
                else
                {
                    xCursor -= 1;
                }
            }
        }
        return move_status.MOVE;
    }
}
class Bishop extends ChessPiece
{
    public Bishop(boolean color, int x, int y)
    {
        super(color, x, y);
        this.name = "Bishop";
    }

    //takes in where the piece wants to move
    @Override
    public move_status isValidMove(ChessPiece[][] board, ChessCoordinate destination) {

        // Calculate the absolute differences in x and y coordinates
        int dx = Math.abs(destination.getRawX() - this.getX());
        int dy = Math.abs(destination.getRawY() - this.getY());
        try{
            if(board[destination.getRawX()][destination.getRawY()].getColor() == this.getColor())
            {
                //trying to capture a piece of the same color :/
                return move_status.INVALID;
            }
        }
        catch(NullPointerException ignored)
        {

        }
        // Check if the move is diagonal/ valid in the first place, then check for collision results
        if( dx == dy)
        {
            //TODO IMPLEMENT
            return collisionTracking(board, destination);
        }

        return move_status.INVALID;
    }
    @Override
    move_status collisionTracking(ChessPiece[][] board, ChessCoordinate destination)
    {
        //int yStart= Math.source.getRawY();
        //moving left to right
        int xCursor = this.getX();
        int yCursor = this.getY();

        while(xCursor != destination.getRawX() && yCursor!= destination.getRawY())
        {
            System.out.println("Cursor: (" + xCursor + ", " + yCursor + ")");
            //check for colliosion
            if(board[xCursor][yCursor] != null && (xCursor != this.getX() && yCursor != this.getY()))
            {
                
                System.out.println("there is a piece in-between source and destination!");
                return move_status.INVALID;
            }

            //MOVE X CURSOR
            if(destination.getRawX()< this.getX())
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
            if(destination.getRawY() > this.getY())
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
        return move_status.MOVE;
    }
}

class Knight extends ChessPiece
{
    public Knight(boolean color, int x, int y)
    {
        super(color, x, y);
        this.name = "Knight";
    }

    //takes in where the piece wants to move
    @Override
    public move_status isValidMove(ChessPiece[][] board, ChessCoordinate destination) {
        // Calculate the absolute differences in x and y coordinates
        int dx = Math.abs(destination.getRawX() - this.getX());
        int dy = Math.abs(destination.getRawY() - this.getY());
        // Check if it's a valid knight move
        if((dx == 1 && dy == 2) || (dx == 2 && dy == 1))
        {
            return collisionTracking(board, destination);
        }
        return move_status.INVALID;
    }

    @Override
    move_status collisionTracking(ChessPiece[][] board, ChessCoordinate destination) {
        return move_status.MOVE;
    }
}
class Pawn extends ChessPiece
{
    public Pawn(boolean color, int x, int y)
    {
        super(color, x, y);
        this.name = "Pawn";
    }
    //takes in where the piece wants to move
    @Override
    public move_status isValidMove(ChessPiece[][] board, ChessCoordinate destination) {
        //white
        if(this.getColor())
        {
            //pawn first move, going two spaces
            if(destination.getRawX()== this.getX() && this.getY() == 1 && destination.getRawY()-this.getY() == 2)
            {
                return collisionTracking(board, destination);
            }
            //pawn is moving forward 1
            else if(destination.getRawX() == this.getX() && destination.getRawY() == (this.getY() + 1))
            {

               return collisionTracking(board, destination);
            }
            //piece is trying to capture
            else if (Math.abs(destination.getRawX()-this.getX()) ==1 && destination.getRawY() == (this.getY()+1))
            {
                return captureCollisionTracking(board, destination);
            }
            System.out.println("failing pawn check??");
        }
        //black
        if(destination.getRawX()== this.getX() && this.getY() == 6 && destination.getRawY()-this.getY() == -2)
        {
            System.out.println("position: " + this.getX() + this.getY());
            System.out.println("moving to " + destination.getRawX() + ", " + destination.getRawY());
            //pawn first move, going two spaces
            return collisionTracking(board, destination);
        }

        else if(destination.getRawX() == this.getX() && destination.getRawY() == (this.getY() - 1))
        {
            //pawn is moving forward 1
            return collisionTracking(board, destination);
        }
        //piece is trying to capture
        else if (Math.abs(destination.getRawX()-this.getX()) == 1 && destination.getRawY() == (this.getY() - 1))
        {
            return captureCollisionTracking(board, destination);
        }
        System.out.println("failing pawn check??");
        return move_status.INVALID;
        //TODO add diagonal take move for pawn
    }
    //special pawn method, since
    move_status captureCollisionTracking(ChessPiece[][] board, ChessCoordinate destination)
    {
        //make sure pawn special capture is valid
        try
        {
            if(board[destination.getRawX()][destination.getRawY()].getColor() != this.getColor())
            {
                return move_status.MOVE;
            }
        }
        catch (NullPointerException e)
        {
            System.out.println("pawn can only move diagonal to capture a piece!");
            return move_status.INVALID;
        }
        System.out.println("cannot capture same color piece!");
        return move_status.INVALID;
    }
    @Override
    move_status collisionTracking(ChessPiece[][] board, ChessCoordinate destination) {
        //pawn collision check only needs to know if there is a piece infront of it
        if(board[destination.getRawX()][destination.getRawY()] == null)
        {
            return move_status.MOVE;
        }
        return move_status.INVALID;
    }
}