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
    public abstract boolean move(int x, int y);
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

    public abstract boolean isValidMove(int x, int y);
    //TODO possibly make a getter for position
}

class King extends ChessPiece
{
    boolean color;
    int pos_x;
    int pos_y;
    public King(boolean color, int x, int y)
    {
        super(color, x, y);
        this.name = "King";
    }
    @Override
    public boolean move(int x, int y) {
        if(isValidMove(x,y))
        {
            this.setX(x);
            this.setY(y);
            return true;
        }
        return false;
    }

    //takes in where the piece wants to move
    @Override
    public boolean isValidMove(int x, int y) {
        //the x move is within one space
        if(this.getX()-1==x || this.getX()+1 ==x)
        {
            if(this.getY()-1 == y || this.getY()+1 == y)
            {
                //valid x and y move
                return true;
            }
        }
        return false;
    }
}

class Queen extends ChessPiece
{
    boolean color;
    int pos_x;
    int pos_y;
    public Queen(boolean color, int x, int y)
    {
        super(color, x, y);
        this.name = "Queen";


    }
    @Override
    public boolean move(int x, int y) {
        if(isValidMove(x,y))
        {
            //set new position
            this.setX(x);
            this.setY(y);
            return true;
        }
        return false;
    }

    //takes in where the piece wants to move
    @Override
    public boolean isValidMove(int x, int y) {
        if(x == this.getX() || y== this.getY())
        {
            //then movement is on axis, like a rook
            return true;
        }

        // Calculate the absolute differences in x and y coordinates
        int dx = Math.abs(x - this.getX());
        int dy = Math.abs(y - this.getY());

        // Check if the move is diagonal
        return dx == dy;
    }
}


class Rook extends ChessPiece
{
    boolean color;
    int pos_x;
    int pos_y;
    public Rook(boolean color, int x, int y)
    {
        super(color, x, y);
        this.name = "Rook";
    }
    @Override
    public boolean move(int x, int y) {
        if(isValidMove(x,y))
        {
            this.setX(x);
            this.setY(y);
            return true;
        }
        return false;
    }

    //takes in where the piece wants to move
    @Override
    public boolean isValidMove(int x, int y) {

        if(x == this.getX() || y == this.getY())
        {
            //then movement is on axis
            return true;
        }
        return false;
    }
}
class Bishop extends ChessPiece
{
    boolean color;
    int pos_x;
    int pos_y;
    public Bishop(boolean color, int x, int y)
    {
        super(color, x, y);
        this.name = "Bishop";
    }
    @Override
    public boolean move(int x, int y) {
        if(isValidMove(x,y))
        {
            this.setX(x);
            this.setY(y);
            return true;
        }
        return false;
    }

    //takes in where the piece wants to move
    @Override
    public boolean isValidMove(int x, int y) {

        // Calculate the absolute differences in x and y coordinates
        int dx = Math.abs(x - this.getX());
        int dy = Math.abs(y - this.getY());

        // Check if the move is diagonal
        return dx == dy;
    }
}

class Knight extends ChessPiece
{
    boolean color;
    int pos_x;
    int pos_y;
    public Knight(boolean color, int x, int y)
    {
        super(color, x, y);
        this.name = "Knight";
    }
    @Override
    public boolean move(int x, int y) {
        if(isValidMove(x,y))
        {
            this.setX(x);
            this.setY(y);
            return true;
        }
        return false;
    }

    //takes in where the piece wants to move
    @Override
    public boolean isValidMove(int x, int y) {
        // Calculate the absolute differences in x and y coordinates
        int dx = Math.abs(x - this.getX());
        int dy = Math.abs(y - this.getY());
        // Check if it's a valid knight move
        return (dx == 1 && dy == 2) || (dx == 2 && dy == 1);
    }
}
class Pawn extends ChessPiece
{
    public Pawn(boolean color, int x, int y)
    {
        super(color, x, y);
        this.name = "Pawn";
    }
    @Override
    public boolean move(int x, int y) {
        if(isValidMove(x,y))
        {
            this.setX(x);
            this.setY(y);
            return true;
        }
        return false;
    }

    //takes in where the piece wants to move
    @Override
    public boolean isValidMove(int x, int y) {
        //white
        if(this.getColor())
        {
            if(this.getY()==1 && y-this.getY() == 2)
            {
                System.out.println("position: " + this.getX() + this.getY());
                System.out.println("moving to " + x + ", " + y);
                //pawn first move, can go two spaces
                return x == this.getX() && y == (this.getY() + 2);
            }
            //return true if pawn is moving forward 1
            return x == this.getX() && y == (this.getY() + 1);
        }

        //black
        if(this.getY() == 1)
        {
            //pawn first move, can go two spaces
            return x == this.getX() && y == this.getY() - 2;
        }
        //return if black moving forward one space
        else return x == this.getX() && y == this.getY() - 1;

        //TODO add diagonal take move for pawn
    }
}