
/**
 * Write a description of class SimonHedges here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SimonHedges extends Player
{
    public String getName() {
        return "Simon Hedges";
    }
    
    protected boolean doesJoin(Game game, int c) {
        if(game.getLeastScoreDiff() < 5) {
            return !(c == 2 && game.getNumPlayersBelowAverage() >= 2);
        } else {
            if(game.getLastRound().didPlayerWin(this)) {
                return lastDecision;
            } else {
                return !lastDecision;
            }
        }
    }
}
