import java.text.NumberFormat;
/**
 * Write a description of class Dummy here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Dummy extends Player
{
    private final float enterProb;
    
   public String getName() {
        return "Dummy (" + NumberFormat.getInstance().format(enterProb*100F) + "%)";
    }
    
    public Dummy(float theEnterProb) {
        enterProb = theEnterProb;
    }

    protected boolean doesJoin(Game game, int c) {
        return RAND.nextFloat() < enterProb;
    }
}
