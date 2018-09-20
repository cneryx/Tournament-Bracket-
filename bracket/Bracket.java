import java.util.ArrayList;

public class Bracket {
    private int rounds;
    private ArrayList[] winnerTournament;
    private ArrayList[] loserTournament;
    private ArrayList<Team> teams;
    private int maxTeams;
    private int placeholders;

    public Bracket(ArrayList<Team> teams, int numTeams, ArrayList<Match>[] winnerTournament, ArrayList<Match>[] loserTournament) {
        this.teams = teams;
        this.maxTeams = numTeams;
        this.winnerTournament = winnerTournament;
        this.loserTournament = loserTournament;
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

    private int roundPowerTwo(int num) {
        return (int) Math.pow(2, Math.ceil(Math.log(num) / Math.log(2)));
    }

}
