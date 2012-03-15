
/**
 * Write a description of class JeremyMack here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class JeremyMack extends Player
{
    public String getName() {
        return "Jeremy Mack";
    }
    
    protected boolean doesJoin(Game game, int c) {
        if(game.isWinning(this)) {
            return c == 4;
        } else {
            return c != 2;
        }
    }
}
