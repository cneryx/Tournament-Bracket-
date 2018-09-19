package bracket;

import java.util.ArrayList;

public class TestBracketGenerator {

    ArrayList<Team> teams = new ArrayList<>();

    public TestBracketGenerator(ArrayList<Team> teams) {
        this.teams = teams;
    }

    public TestBracket getBracket() { 
    }
    
    private ArrayList<Match>[] generateWinningBracket() {

        // there will always be ceil(lg(N)) rounds
        int numberOfRounds = (int)Math.ceil(Math.log(teams.size())/Math.log(2));

        // populate the winning bracket;
        ArrayList<Match>[] winningBracket = new ArrayList[numberOfRounds];
        for (int i = 0; i < numberOfRounds; i++) {
            for (int j = 0; j < Math.pow(2, i); j++) {
                winningBracket[0].add(new Match());
            }
        }

        // populate the matches
        int index = 0;
        for (int i = 0; i < teams.size(); i++) {
            winningBracket[numberOfRounds - 1].get(index).addTeam(teams.get(i));
            index = (index + 1) % winningBracket[numberOfRounds - 1].size();
        }

        return winningBracket;
    }
}
