
/**
 * Write a description of class StrategyTester here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class StrategyTester
{
    private static Player[] players = {
            new JeremyMack(),
            new FranCap(),
            new SimonHedges(),
            new JackMcNeil(),
            new NatLevyWest(),
            new HenryCost(),
            new MilesBergner(),
            new Dummy(0),
        };

    private final int howManyGames;

    private int totalScore = 0;
    private int totalRounds = 0;
    private int totalWinningScore = 0;

    public static void main(String[] args) {
        int numGames = 1000;
        try {
            numGames = new Integer(args[0]);
        } catch(RuntimeException re) {
            System.err.println("numGames defaulting to "+numGames);
        }
        StrategyTester test = new StrategyTester(numGames);
        test.run();
    }

    public StrategyTester(int numGames) {
        howManyGames = numGames;
    }

    public void run() {
        System.err.println();
        for(int i = 0; i < howManyGames; i++) {
            Game game = new Game(players);
            System.err.print(">");
            while(true) {
                System.err.print(".");
                game.playRound();
                Player winner = game.getWinner();
                if(winner != null) {
                    winner.incrementWinCount();
                    break;
                }
            }
            System.err.println("<");
            totalScore += game.getTotalScore();
            totalRounds += game.getNumRounds();
            totalWinningScore += game.getLeadScore();
            resetPlayers();
        }
        System.err.println("Total Games Played: " + howManyGames);
        System.err.println("Average Game Length: " + (float)totalRounds/(float)howManyGames);
        System.err.println("Average Total Score: " + (float)totalScore/(float)howManyGames);
        System.err.println("Average Player Score: " + ((float)totalScore/(float)players.length)/(float)howManyGames);
        System.err.println("Average Winner Score: " + (float)totalWinningScore/(float)howManyGames);
        System.err.println();
        System.err.println();
        for(Player p : players) {
            System.err.println(p + ": " + p.getWinCount() + "  ("+(float)p.getWinCount()*100F/(float)howManyGames+"%)");
            System.err.println("    YES: "+ p.getYes()+ "/" + totalRounds + "  (" + (float)p.getYes()*100F/(float)totalRounds + "%)");
            System.err.println("    NO: " + p.getNo() + "/" + totalRounds + "  (" + (float)p.getNo()*100F/(float)totalRounds + "%)");
            System.err.println();
        }
    }

    private void resetPlayers() {
        for(Player p : players) {
            p.reset();
        }
    }
}
