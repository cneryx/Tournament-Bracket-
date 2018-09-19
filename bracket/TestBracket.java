package bracket;

import java.util.ArrayList;

public class TestBracket {

    private int numberOfTeams;
    private int[] matchesInRounds;
    private ArrayList<Match>[] bracket;

    public TestBracket(int numberOfTeams, int[] matchesInRounds, ArrayList<Match>[] bracket) {
        this.numberOfTeams = numberOfTeams;
        this.matchesInRounds = matchesInRounds;
        this.bracket = bracket;
    }

    public int getNumberOfTeams() {
        return numberOfTeams;
    }

    public int getNumberOfRounds() {
        return matchesInRounds.length;
    }

    public int getNumberOfMatchesInRound(int round) {
        return matchesInRounds[round - 1];
    }

    public String[] getTeamsInMatch(int round, int matchNumber) {
        return bracket[round - 1].get(matchNumber - 1).getTeamNames();
    }
}