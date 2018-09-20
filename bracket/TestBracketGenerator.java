package bracket;

import java.util.ArrayList;

public class Generator {
    private ArrayList<Team> teams;
    private int numberOfTeams;  
    
    private int maxTeams;
    private int placeholders;
    private ArrayList[] winnerTournament;
    private ArrayList[] loserTournament;
    private int winningRounds;
    private int losingRounds;

    public Generator(ArrayList<Team> teams) {
        this.teams = teams;
        this.numberOfTeams = teams.size();
        
        maxTeams = roundPowerTwo(teams.size());
        winningRounds = (int) (Math.log(maxTeams) / Math.log(2));
        losingRounds = (winningRounds - 2) * 2;
        winnerTournament = new ArrayList[winningRounds];
        loserTournament = new ArrayList[losingRounds];
        
        placeholders = maxTeams - numberOfTeams;
        for (int i = 0; i < placeholders; i++) {
            teams.add(new Team("ph", -i));
        }
    }

//    public Bracket getBracket() {
//    }


    public int getNumberOfTeams() {
        return numberOfTeams;
    }

    public int getNumberOfRounds() {
        //return rounds;
    }

    private ArrayList<Match>[] generateWinningBracket() {
        ArrayList<Match>[] winningBracket = new ArrayList[winningRounds];
        for (int i = 0; i < winningRounds; i++) {
            for (int j = 0; j < Math.pow(2, i); j++) {
                winningBracket[0].add(new Match());
            }
        }
    }
    
    public ArrayList<Team>[] getLosingBracket() {
        loserTournament[0].add(new Match());
        for (int i = 1; i < losingRounds; i += 2) {
            for (int j = 0; j < Math.pow(2, i); j++) {
                loserTournament[i].add(new Match());
                loserTournament[i + 1].add(new Match());
            }
        }
    }

    private int roundPowerTwo(int num) {
        return (int) Math.pow(2, Math.ceil(Math.log(num) / Math.log(2)));
    }
}
