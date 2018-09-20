package bracket;

import java.util.ArrayList;

public class Generator {
    private ArrayList<Team> teamData; //key data that is not touched or modified!

    public Generator(ArrayList<Team> teamData) {
        this.teamData = teamData;
    }

    public Bracket getBracket() {
        
        // download the data
        ArrayList<Team> teams = new ArrayList<>();
        teams.addAll(teamData);

        // find number of teams and fill in all placeholders
        int numberOfTeams = teams.size();
        int maxNumberOfTeams = roundPowerTwo(numberOfTeams);
        for (int i = numberOfTeams; i < maxNumberOfTeams; i++) {
            teams.add(new Team("ph", -i));
        }

        // find number of rounds
        int winningRounds = (int)(Math.log(maxNumberOfTeams) / Math.log(2) + 2);
        int losingRounds = (winningRounds - 3) * 2;
        int numberOfRounds = Math.max(winningRounds, losingRounds);

        // create the brackets
        ArrayList<Match>[] winnerBracket = generateWinnerBracket(winningRounds);
        ArrayList<Match>[] loserBracket = generateLoserBracket(losingRounds);

        // create the Bracket object
        Bracket bracket = new Bracket(teams, numberOfRounds, numberOfRounds, winnerBracket, loserBracket);
        return bracket;
    }

    private ArrayList<Match>[] generateWinnerBracket(int winningRounds) {
        ArrayList<Match>[] winnerBracket = new ArrayList[winningRounds];

        //... do something
        for (int i = 0; i < winningRounds; i++) {
            winnerBracket[i] = new ArrayList<>();
            for (int j = 0; j < Math.pow(2, i); j++) {
                winnerBracket[i].add(new Match());
            }
        }

        return winnerBracket;
    }

    public ArrayList<Match>[] generateLoserBracket(int losingRounds) {
        ArrayList<Match>[] loserBracket = new ArrayList[losingRounds];

        //... do something
        for (int i = 0; i < losingRounds; i += 2) {
            loserBracket[i] = new ArrayList<>();
            loserBracket[i+1] = new ArrayList<>();
            for (int j = 0; j < Math.pow(2, i); j++) {
                loserBracket[i].add(new Match());
                loserBracket[i + 1].add(new Match());
            }
        }
        return loserBracket;
    }

    private int roundPowerTwo(int num) {
        return (int) Math.pow(2, Math.ceil(Math.log(num) / Math.log(2)));
    }
}
