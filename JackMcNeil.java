
/**
 * Write a description of class JackMcNeil here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class JackMcNeil extends Player
{
    public String getName() {
        return "Jack McNeil";
    }

    protected boolean doesJoin(Game game, int c) {
        switch(c) {
            case 2:
                return RAND.nextInt(100) < 7;
            case 4:
                return RAND.nextInt(25) < 3;
            case 6:
                return RAND.nextInt(20) < 3;
            default:
                throw new IllegalArgumentException("c = "+c);
        }
    }
}
