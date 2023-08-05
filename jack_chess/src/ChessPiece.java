public interface ChessPiece {
    int pos_x = 0;
    int pos_y = 0;
    void move(int x, int y);
    boolean isValidMove(int x, int y);

}

class King implements ChessPiece
{
    int pos_x;
    int pos_y;
    public King(Character color)
    {
        this.pos_x = 4;
        if(color == 'w' )
        {
            this.pos_y = 0;
        }
        else
        {
            this.pos_y = 7;
        }

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
        if(pos_x-1 >= x-1 && pos_x+1 < x+1)
        {
            //y move is within one space
            if(pos_y-1 )
            {

            }
        }
        return false;
    }
}