public interface ChessPiece {
    char color = 'w';
    int pos_x = 0;
    int pos_y = 0;
    void move(int x, int y);
    boolean isValidMove(int x, int y);
    //TODO possibly make a getter for position
}

class King implements ChessPiece
{
    char color;
    int pos_x;
    int pos_y;
    public King(char color, int x, int y)
    {
        this.color = color;
        this.pos_x = x;
        this.pos_y = y;
    }
    @Override
    public void move(int x, int y) {
        if(isValidMove(x,y))
        {
            this.pos_x = x;
            this.pos_y = y;
        }
    }

    //takes in where the piece wants to move
    @Override
    public boolean isValidMove(int x, int y) {
        //the x move is within one space
        if(pos_x-1==x || pos_x+1 ==x)
        {
            if(pos_y-1 == y || pos_y+1 == y)
            {
                //valid x and y move
                return true;
            }
        }
        return false;
    }
}

class Queen implements ChessPiece
{
    char color;
    int pos_x;
    int pos_y;
    public Queen(char color, int x, int y)
    {
        this.color = color;
        this.pos_x = x;
        this.pos_y = y;
    }
    @Override
    public void move(int x, int y) {
        if(isValidMove(x,y))
        {
            //set new position
            this.pos_x = x;
            this.pos_y = y;
        }
    }

    //takes in where the piece wants to move
    @Override
    public boolean isValidMove(int x, int y) {
        if(x == pos_x || y== pos_y)
        {
            //then movement is on axis, like a rook
            return true;
        }

        // Calculate the absolute differences in x and y coordinates
        int dx = Math.abs(x - pos_x);
        int dy = Math.abs(y - pos_y);

        // Check if the move is diagonal
        return dx == dy;
    }
}


class Rook implements ChessPiece
{
    char color;
    int pos_x;
    int pos_y;
    public Rook(char color, int x, int y)
    {
        this.color = color;
        this.pos_x = x;
        this.pos_y = y;
    }
    @Override
    public void move(int x, int y) {
        if(isValidMove(x,y))
        {
            this.pos_x = x;
            this.pos_y = y;
        }
    }

    //takes in where the piece wants to move
    @Override
    public boolean isValidMove(int x, int y) {

        if(x == pos_x || y == pos_y)
        {
            //then movement is on axis
            return true;
        }
        return false;
    }
}
class Bishop implements ChessPiece
{
    char color;
    int pos_x;
    int pos_y;
    public Bishop(char color, int x, int y)
    {
        this.color = color;
        this.pos_x = x;
        this.pos_y = y;
    }
    @Override
    public void move(int x, int y) {
        if(isValidMove(x,y))
        {
            this.pos_x = x;
            this.pos_y = y;
        }
    }

    //takes in where the piece wants to move
    @Override
    public boolean isValidMove(int x, int y) {

        // Calculate the absolute differences in x and y coordinates
        int dx = Math.abs(x - pos_x);
        int dy = Math.abs(y - pos_y);

        // Check if the move is diagonal
        return dx == dy;
    }
}

class Knight implements ChessPiece
{
    char color;
    int pos_x;
    int pos_y;
    public Knight(char color, int x, int y)
    {
        this.color = color;
        this.pos_x = x;
        this.pos_y = y;
    }
    @Override
    public void move(int x, int y) {
        if(isValidMove(x,y))
        {
            this.pos_x = x;
            this.pos_y = y;
        }
    }

    //takes in where the piece wants to move
    @Override
    public boolean isValidMove(int x, int y) {
        // Calculate the absolute differences in x and y coordinates
        int dx = Math.abs(x - pos_x);
        int dy = Math.abs(y - pos_y);

        // Check if it's a valid knight move
        return (dx == 1 && dy == 2) || (dx == 2 && dy == 1);
    }
}
class Pawn implements ChessPiece
{
    char color;
    int pos_x;
    int pos_y;
    public Pawn(char color, int x, int y)
    {
        this.color = color;
        this.pos_x = x;
        this.pos_y = y;
    }
    @Override
    public void move(int x, int y) {
        if(isValidMove(x,y))
        {
            this.pos_x = x;
            this.pos_y = y;
        }
    }

    //takes in where the piece wants to move
    @Override
    public boolean isValidMove(int x, int y) {
        //white
        if(this.color == 'w')
        {
            //pawn first move, can go two spaces
            if(y==1)
            {
                if(x == pos_x && y == pos_y-2)
                {
                    return true;
                }
            }
            if(x == pos_x && y == pos_y-1)
            {
                return true;
            }
        }
        //black
        else
        {
            //pawn first move, can go two spaces
            if(y==1)
            {
                if(x == pos_x && y == pos_y+2)
                {
                    return true;
                }
            }
            if(x == pos_x && y == pos_y+1)
            {
                return true;
            }
        }
        //TODO add diagonal take move for pawn
        return false;
    }
}