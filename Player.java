import java.util.Random;
/**
 * Abstract class Player - write a description of the class here
 * 
 * @author (your name here)
 * @version (version number or date here)
 */
public abstract class Player
{
    
    protected static final Random RAND = new Random();

    protected int winCount = 0;

    protected int points = 0;
    
    protected int yes = 0;
    
    protected int no = 0;

    protected boolean lastDecision;

    public int getPoints() {
        return points;
    }

    public void incrementPoints(int amount) {
        points += amount;
    }

    public boolean getLastDecision() {
        return lastDecision;
    }
    
    public int getWinCount() {
        return winCount;
    }
    
    public void incrementWinCount() {
        winCount++;
    }
    
    public void reset() {
        points = 0;
    }
    
    protected void setLastDecision(boolean decision) {
        if(decision) {
            yes++;
        } else {
            no++;
        }
        lastDecision = decision;
    }
    
    public int getYes() {
        return yes;
    }
    
    public int getNo() {
        return no;
    }
    
    public String toString() {
        return getName();
    }
    
    public final boolean getDecision(Game game, int c) {
        setLastDecision(doesJoin(game,c));
        return lastDecision;
    }
    
    protected abstract boolean doesJoin(Game game, int c);
    
    public abstract String getName();
}
