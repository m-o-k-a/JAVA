package Match;

public class MatchResult {
    private int host;
    private int guest;
    private int hostScore = 0;
    private int guestScore = 0;

    public MatchResult(int host, int guest, int hostScore, int guestScore) {
        this.host = host;
        this.guest = guest;
        this.hostScore = hostScore;
        this.guestScore = guestScore;
    }

    public int getHost() { return host; }
    public int getHostScore() {return hostScore; }
    public int getGuest() { return guest;}
    public int getGuestScore() { return guestScore; }

    public String toString() {
        return (getHostScore() + "-" + getGuestScore());
    }



}
