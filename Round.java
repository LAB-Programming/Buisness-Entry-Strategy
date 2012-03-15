import java.util.HashMap;
/**
 * Write a description of class Round here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Round
{
    private final HashMap<Player,Boolean> decisions = new HashMap<Player,Boolean>();
    
    private final int c;
    
    private final int numEnterers;

    public Round(Player[] players, int c) {
        this.c = c;
        int enterers = 0;
        for(Player p : players) {
            if(p.getLastDecision()) enterers++;
            decisions.put(p,p.getLastDecision());
        }
        numEnterers = enterers;
    }
    
    public boolean didPlayerWin(Player p) {
        return decisions.get(p) == didEnterersWin();
    }
    
    public int getC() {
        return c;
    }
    
    public boolean getPlayerDecision(Player p) {
        return decisions.get(p);
    }
    
    public boolean didEnterersWin() {
        return numEnterers <= c;
    }
    
    public boolean areEnterersMostCommon() {
        return numEnterers > decisions.size()/2;
    }
    
    public int getNumEnterers() {
        return numEnterers;
    }
}
