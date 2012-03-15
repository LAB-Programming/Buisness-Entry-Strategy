
/**
 * Write a description of class MilesBergner here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MilesBergner extends Player
{
    public String getName() {
        return "Miles Bergner";
    }

    protected boolean doesJoin(Game game, int c) {
        if(points < 8) {
            return c != 2;
        } else {
            Round[] rounds = game.getLastNumRounds(2).toArray(new Round[2]);
            if(rounds[0].didEnterersWin() && rounds[1].didEnterersWin()) {
                return true;
            } else if (rounds[0].didEnterersWin() && !rounds[1].didEnterersWin()) {
                return RAND.nextInt(3) != 0;
            } else if (!rounds[0].didEnterersWin() && rounds[1].didEnterersWin()) {
                return RAND.nextInt(3) == 0;
            } else {
                return false;
            }
        }
    }
}
