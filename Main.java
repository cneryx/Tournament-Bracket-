import java.util.ArrayList;

// dummy testing class
public class Main {
    public static void main(String[] args) {
        ArrayList<Team> teams = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            teams.add(new Team(genID(i), i));
        }

        long checkpoint = System.currentTimeMillis();
        DoubleEliminationBracket bracket = new DoubleEliminationBracket(teams);
        printTime("Create Bracket", checkpoint);
    }

    public static String genID(int i) {
        return i < 0 ? "" : genID((i / 26) - 1) + (char)(65 + i % 26);
    }

    public static void printTime(String action, long startTime) {
        System.out.println(action + ": " + (System.currentTimeMillis() - startTime));
    }
}
