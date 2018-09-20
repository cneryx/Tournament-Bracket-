import java.util.ArrayList;

public class Bracket {
    private int rounds;
    private ArrayList[] winnerTournament;
    private ArrayList[] loserTournament;
    private ArrayList<Team> teams;
    private int maxTeams;
    private int placeholders;
    private int winningRounds;
    private int losingRounds;

    public Bracket(ArrayList<Team> teams, int numTeams, ArrayList<Match>[] winnerTournament, ArrayList<Match>[] loserTournament, int winningRounds, int losingRounds) {
        this.teams = teams;
        this.maxTeams = numTeams;
        this.winnerTournament = winnerTournament;
        this.loserTournament = loserTournament;
        this.winningRounds = winningRounds;
        this.losingRounds = losingRounds;
    }

    void setMatchWinner(String teamName, int round, int matchNumber, int bracket) {
        if (round == 0 && bracket == 0) return;
        if (round == 0) {
            Match m = (Match) loserTournament[round].get(matchNumber);
            Match n = (Match) winnerTournament[1].get(1);
            if (m.getTeamOne().getName().equals(teamName)) {
                n.addTeam(m.getTeamOne());
            } else {
                n.addTeam(m.getTeamTwo());
            }
        }
        if (round == 1 && bracket == 0) {

        }
        if (bracket == 0 && round != winningRounds - 1) {
            Match m = (Match) winnerTournament[round].get(matchNumber);
            Match n = (Match) winnerTournament[round - 1].get(matchNumber / 2);
            Match lose = (Match) loserTournament[(round - 2) * 2].get(matchNumber);
            setMatch(m, n, lose, teamName);
        } else if (bracket == 1) {
            Match m = (Match) loserTournament[round].get(matchNumber);
            Match n;
            if (round % 2 == 0) {
                n = (Match) loserTournament[round - 1].get(matchNumber / 2);
            } else {
                n = (Match) loserTournament[round - 1].get(matchNumber);
            }
            if (m.getTeamOne().getName().equals(teamName)) {
                n.addTeam(m.getTeamOne());
            } else {
                n.addTeam(m.getTeamTwo());
            }
        } else {
            Match m = (Match) winnerTournament[round].get(matchNumber);
            Match n = (Match) winnerTournament[round - 1].get(matchNumber / 2);
            Match lose = (Match) loserTournament[losingRounds - 1].get(matchNumber / 2);
            setMatch(m, n, lose, teamName);
        }
    }

    private int roundPowerTwo(int num) {
        return (int) Math.pow(2, Math.ceil(Math.log(num) / Math.log(2)));
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
