package bracket;

import bracket.Match;

import java.util.ArrayList;

public class Bracket {
    private int numberOfTeams;
    private int numberOfRounds;
    private ArrayList[] winnerTournament;
    private ArrayList[] loserTournament;

    public Bracket(int numberOfTeams, int numberOfRounds, ArrayList<Match>[] winnerBracket, ArrayList<Match>[] loserBracket) {
        this.numberOfTeams = numberOfTeams;
        this.numberOfRounds = numberOfRounds;
        this.winnerTournament = winnerBracket;
        this.loserTournament = loserBracket;
    }

    public int getNumberOfTeams() {
        return numberOfTeams;
    }

    public int getNumberOfRounds() {
        return numberOfRounds;
    }

    void setMatchWinner(String teamName, int round, int matchNumber, int bracket) {
        if (round == 0 && bracket == 0) return;
        if (round == 0) {
            Match m = (Match) loserTournament[round].get(matchNumber);
            if (m.getTeamOne().getName().equals(teamName)) {
                Match n = (Match) winnerTournament[1].get(0);
                n.addTeam(m.getTeamOne());
            }
        }
        if (round == 1 && bracket == 0) {

        }

        if (bracket == 0) {
            Match m = (Match) winnerTournament[round].get(matchNumber);
            if (m.getTeamOne().getName().equals(teamName)) {
                Match n = (Match) (winnerTournament[round - 1].get(matchNumber / 2));
                n.addTeam(m.getTeamOne());

            }
        }
    }
}
