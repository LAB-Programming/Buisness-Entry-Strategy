
/**
 * Write a description of class FranCap here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class FranCap extends Player
{
    public String getName() {
        return "Francesca Capossela (fixed)";
    }
    
    protected boolean doesJoin(Game game, int c) {
        Round lastRound = game.getLastRound();
        if(c == 2) {
            if(lastRound == null) {
                return false;
            }
            int lastC = lastRound.getC();
            if(lastC == 2) {
                return false;
            } else if(lastC == 4) {
                return (!lastRound.didEnterersWin() && RAND.nextInt(10) < 3);
            } else {
                return (!lastRound.didEnterersWin() && RAND.nextInt(10) < 7);
            }
        } else if(c == 4) {
            if(game.isWinning(this) || points < game.getAverageScore()) {
                return true;
            } else {
                return RAND.nextInt(10) < 7;
            }
        } else if(c == 6) {
            if(lastRound == null || (!lastRound.areEnterersMostCommon() && lastRound.didEnterersWin())) {
                return false;
            } else {
                return true;
            }
        }else {
            throw new IllegalArgumentException("c = "+c);
        }
    }
}
