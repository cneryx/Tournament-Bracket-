package bracket;

import java.util.ArrayList;

public class Bracket {

    private int numberOfTeams;
    private int numberOfRounds;
    private ArrayList[] winnerBracket;
    private ArrayList[] loserBracket;

    public Bracket(int numberOfTeams, int numberOfRounds, ArrayList<Match>[] winnerBracket, ArrayList<Match>[] loserBracket) {
        this.numberOfTeams = numberOfTeams;
        this.numberOfRounds = numberOfRounds;
        this.winnerBracket = winnerBracket;
        this.loserBracket = loserBracket;
    }

    public int getNumberOfTeams() {
        return numberOfTeams;
    }

    public int getNumberOfRounds() {
        return numberOfRounds;
    }

    public void setMatchWinner(String teamName, int round, int matchNumber, int bracket) {
        if (round == 0 && bracket == 0) return;
        if (round == 0) {
            Match m = (Match) loserBracket[round].get(matchNumber);
            Match n = (Match) winnerBracket[1].get(1);
            if (m.getTeamOne().getName().equals(teamName)) {
                n.addTeam(m.getTeamOne());
            } else {
                n.addTeam(m.getTeamTwo());
            }
        }
        if (round == 1 && bracket == 0) {

        }
        if (bracket == 0 && round != winnerBracket.length - 1) {
            Match m = (Match) winnerBracket[round].get(matchNumber);
            Match n = (Match) winnerBracket[round - 1].get(matchNumber / 2);
            Match lose = (Match) loserBracket[(round - 2) * 2].get(matchNumber);
            setMatch(m, n, lose, teamName);
        } else if (bracket == 1) {
            Match m = (Match) loserBracket[round].get(matchNumber);
            Match n;
            if (round % 2 == 0) {
                n = (Match) loserBracket[round - 1].get(matchNumber / 2);
            } else {
                n = (Match) loserBracket[round - 1].get(matchNumber);
            }
            if (m.getTeamOne().getName().equals(teamName)) {
                n.addTeam(m.getTeamOne());
            } else {
                n.addTeam(m.getTeamTwo());
            }
        } else {
            Match m = (Match) winnerBracket[round].get(matchNumber);
            Match n = (Match) winnerBracket[round - 1].get(matchNumber / 2);
            Match lose = (Match) loserBracket[loserBracket.length - 1].get(matchNumber / 2);
            setMatch(m, n, lose, teamName);
        }
    }


    private void setMatch(Match m, Match n, Match lose, String teamName) {
        if (m.getTeamOne().getName().equals(teamName)) {
            n.addTeam(m.getTeamOne());
            lose.addTeam(m.getTeamTwo());
        } else {
            n.addTeam(m.getTeamTwo());
            lose.addTeam(m.getTeamOne());
        }
    }
}
