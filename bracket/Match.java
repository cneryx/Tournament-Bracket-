package bracket;

public class Match {

    private Team[] teams = new Team[2];
    private Team winner = null;
    private Team loser = null;

    public Match() {
    }

    /**
     * @return the names of the two teams, or "unknown", if Match is not filled
     */
    public String[] getTeamNames() {
        String[] names = new String[2];
        names[0] = (teams[0] != null)? teams[0].getName() : "unknown";
        names[1] = (teams[1] != null)? teams[1].getName() : "unknown";
        return names;
    }

    /**
     * @return name of the Match winner, or "unknown", if the winner has not been decided
     */
    public String getWinnerName() {
        return (winner != null)? winner.getName() : "unknown";
    }

    /**
     * @return name of the Match loser, or "unknown", if the loser has not been decided
     */
    public String getLoserName() {
        return (loser != null)? loser.getName() : "unknown";
    }

    /**
     * Adds a team to the Match, if possible
     * @param newTeam the Team to be added
     * @return true, if the team was succesfully added. false, if unsuccessful
     */
    public boolean addTeam(Team newTeam) {
        if (teams[0] == null) {
            teams[0] = newTeam;
            return true;
        } else if (teams[1] == null) {
            teams[1] = newTeam;
            return true;
        }
        return false; //unsuccessful if Match is already filled
    }

    /**
     * Sets the winner of a Match, if possible
     * @param winnerName name of the winning team
     * @param winnerMatch Match that winner advances to
     * @param loserMatch Match that loser advances to
     * @return true, if the winner was succesfully set. false, if unsuccessful
     */
    public boolean setWinner(String winnerName, Match winnerMatch, Match loserMatch) {
        if (teams[0] == null || teams[1] == null) { //unsuccessful if Match is not filled
            return false;
        }

        if (winnerName.equals(teams[0].getName())) {
            winner = teams[0];
            loser = teams[1];
        } else if (winnerName.equals(teams[1].getName())) {
            winner = teams[1];
            loser = teams[0];
        } else {
            return false; //unsuccessful if winnerName doesn't match
        }

        // move winner and loser into their respective matches 
        if (winnerMatch != null) {
            winnerMatch.addTeam(winner);
        }
        if (loserMatch != null) {
            loserMatch.addTeam(loser);
        }

        return true;
    }
}
