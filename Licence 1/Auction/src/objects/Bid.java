package objects;

public class Bid {

    private User bidder;
    private double offer;

    public User getBidder() { return bidder; }

    public double getOffer() { return offer; }

    public Bid(User bidder, double offer) {
        this.bidder = bidder;
        this.offer = offer;
    }
}
