public class Team implements Comparable<Team>{
    private String name;
    private int seed;

    public Team(String name, int seed) {
        this.name = name;
        this.seed = seed;
    }

    public String getName() {
        return name;
    }

    public int getSeed() {
        return seed;
    }

    @Override
    public int compareTo(Team o) {
        if (this.seed > o.seed) {
            return 1;
        } else if (this.seed < o.seed) {
            return -1;
        } else {
            return 0;
        }
    }
}
