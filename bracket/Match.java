package bracket;

public class Match {
    private Team teamOne = null;
    private Team teamTwo = null;

    public Match() {
    }

    public String[] getTeamNames() {
        String[] names = {teamOne.getName(), teamTwo.getName()};
        return names;
    }

    public Team getTeamOne() {
        return teamOne;
    }

    public Team getTeamTwo() {
        return teamTwo;
    }

    public void addTeam(Team newTeam) {
        if (teamOne == null) {
            teamOne = newTeam;
        } else if (teamTwo == null) {
            teamTwo = newTeam;
        }
    }
}
