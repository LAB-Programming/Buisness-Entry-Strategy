import java.util.Random;
import java.util.LinkedList;
import java.util.Iterator;
/**
 * Write a description of class Game here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Game
{   
    private static final Random RAND = new Random();

    private LinkedList<Round> rounds = new LinkedList<Round>();
    
    private final Player[] players;

    public Game(Player[] thePlayers) {
        players = thePlayers;
    }

    public Player getWinner() {
        int leadScore = getLeadScore();
        if(leadScore >= 20 && numLeadPlayers() < 2) {
            for(Player p : players) {
                if(p.getPoints() == leadScore) {
                    return p;
                }
            }
        }
        return null;
    }

    public void playRound() {
        int c = (RAND.nextInt(3)+1)*2;
        int entryNum = 0;
        for(Player p : players) {
            if(p.getDecision(this,c)) {
                entryNum++;
            }
        }
        for(Player p : players) {
            if(!p.getLastDecision()) {
                p.incrementPoints(1);
            }else if(entryNum <= c) {
                p.incrementPoints(2);
            }
        }
        rounds.add(new Round(players,c));
    }

    public int getLeadScore() {
        int highScore = 0;
        for(Player p : players) {
            if(p.getPoints() > highScore) {
                highScore = p.getPoints();
            }
        }
        return highScore;
    }

    public int numLeadPlayers() {
        int num = 0;
        int highScore = getLeadScore();
        for(Player p : players) {
            if(p.getPoints() == highScore) {
                num++;
            }
        }
        return num;
    }

    public int getTotalScore() {
        int total = 0;
        for(Player p : players) {
            total += p.getPoints();
        }
        return total;
    }

    public int getNumRounds() {
        return rounds.size();
    }

    public LinkedList<Round> getLastNumRounds(int num) {
        LinkedList<Round> ret = new LinkedList<Round>();
        Iterator<Round> iter = rounds.descendingIterator();
        for(int i = 0; i < num; i++) {
            if(!iter.hasNext()) break;
            ret.addFirst(iter.next());
        }
        return ret;
    }
    
    public Round getLastRound() {
        try {
            return rounds.getLast();
        } catch(RuntimeException re) {
            return null;
        }
    }

    public boolean isWinning(Player p) {
        return p.getPoints() == getLeadScore() && getLeadScore() != 0;
    }

    public boolean isStrictlyWinning(Player p) {
        return isWinning(p) && numLeadPlayers() == 0;
    }

    public float getAverageScore() {
        return (float)getTotalScore()/(float)players.length;
    }

    public int getLeastScoreDiff() {
        int diff = -1;
        for(Player p1 : players) {
            for(Player p2 : players) {
                if(p1 == p2) continue;
                int tempDiff = Math.abs(p1.getPoints() - p2.getPoints());
                if(tempDiff < diff || diff < 0 ) {
                    diff = tempDiff;
                }
            }
        }
        return diff;
    }
    
    public int getNumPlayersBelowAverage() {
        int num = 0;
        for(Player p : players) {
            if(p.getPoints() < getAverageScore()) num++;
        }
        return num;
    }
}
