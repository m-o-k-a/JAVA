package Club;

public class Team {
    private String clubName;
    private int identifier;

    /**
     * Constructor
     * @param clubName
     * @param identifier
     */
    public Team(String clubName, int identifier) {
        this.clubName = clubName;
        this.identifier = identifier;
    }

    public String getName() { return clubName; }
    public int getIdentifier() { return identifier;}

    public String toString() {
        return ("This is the club " + getName() + "(\n(identifier: " + getIdentifier() + ")");
    }
}
