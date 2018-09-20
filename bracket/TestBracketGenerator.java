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
        maxTeams = roundPowerTwo(teams.size());
        System.out.println(maxTeams + " " + winningRounds + " " + losingRounds);
        winningRounds = (int) (Math.log(maxTeams) / Math.log(2) + 2);
        losingRounds = (winningRounds - 3) * 2;
        winnerTournament = new ArrayList[winningRounds];
        loserTournament = new ArrayList[losingRounds];
        placeholders = maxTeams - teams.size();
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
        for (int i = 0; i < losingRounds; i += 2) {
            for (int j = 0; j < Math.pow(2, i); j++) {
                loserTournament[i].add(new Match());
                loserTournament[i + 1].add(new Match());
            }
        }
        return loserTournament;
    }

    private int roundPowerTwo(int num) {
        return (int) Math.pow(2, Math.ceil(Math.log(num) / Math.log(2)));
    }
}
