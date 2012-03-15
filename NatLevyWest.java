
/**
 * Write a description of class NatLevyWest here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class NatLevyWest extends Player
{
    public String getName() {
        return "Nat Levy-Westhead";
    }

    protected boolean doesJoin(Game game, int c) {
        if(points >= Math.round(game.getLeadScore()/2F)) {
            return (c == 6) && (RAND.nextInt(4) != 0);
        } else {
            return true;
        }
    }
}
