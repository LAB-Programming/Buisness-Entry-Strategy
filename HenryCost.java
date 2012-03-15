
/**
 * Write a description of class HenryCost here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class HenryCost extends Player
{
    public String getName() {
        return "Henry Costello";
    }

    protected boolean doesJoin(Game game, int c) {
        switch(c) {
            case 2:
                return true;
            case 4:
                return RAND.nextInt(2) == 0;
            case 6:
                return false;
            default:
                throw new IllegalArgumentException("c = "+c);
        }
    }
}
