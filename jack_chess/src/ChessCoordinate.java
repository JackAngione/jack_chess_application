import java.util.HashMap;
import java.util.Map;

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
        public ChessCoordinate(int x, int y) throws Exception {
            char x1;
            coordinateLetters.put('a', 0);
            coordinateLetters.put('b', 1);
            coordinateLetters.put('c', 2);
            coordinateLetters.put('d', 3);
            coordinateLetters.put('e', 4);
            coordinateLetters.put('f', 5);
            coordinateLetters.put('g', 6);
            coordinateLetters.put('h', 7);
            //set x1 to 'Z' as a backup
            x1 = 'Z';
            //loop through hashmap and assign x to the letter which has it's numeric value
            for (Map.Entry<Character, Integer> entry : coordinateLetters.entrySet()) {
                Character key = entry.getKey();
                Integer value = entry.getValue();
                //System.out.println("Key: " + key + ", Value: " + value);
                if(value == x)
                {
                    x1 = key;
                    break;
                }
            }
            if(x1 == 'Z')
            {
             throw new Exception("Incorrect X coordinate given to ChessCoordinate object");
            }
            this.x = x1;
            if(y>7||y<0)
            {
                throw new Exception("Y value out of bounds");
            }
            else {
                this.y = y+1;
            }

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
