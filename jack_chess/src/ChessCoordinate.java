import java.util.HashMap;

public class ChessCoordinate {
        private final char x;
        private final int y;

        HashMap<Character, Integer> coordinateLetters = new HashMap<>();
        public ChessCoordinate(char x, int y)
        {
            this.x = x;
            this.y = y;
            coordinateLetters.put('a', 0);
            coordinateLetters.put('b', 1);
            coordinateLetters.put('c', 2);
            coordinateLetters.put('d', 3);
            coordinateLetters.put('e', 4);
            coordinateLetters.put('f', 5);
            coordinateLetters.put('g', 6);
            coordinateLetters.put('h', 7);
        }
        public char getX()
        {
            return this.x;
        }
        public int getY()
        {
            return this.y;
        }

        public int getRawX()
        {
            return this.coordinateLetters.get(Character.toLowerCase(this.getX()));
        }
        public int getRawY()
        {
            return this.getY()-1;
        }
}
