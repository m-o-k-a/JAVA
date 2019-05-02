package objects;

import java.util.HashSet;
import java.util.Set;

public class Auction {

    private Article article;
    private Set<Bid> bids = new HashSet<>();
    private double value;
    private User owner;

    public Article getArticle() { return article; }

    public double getValue() { return value; }

    public User getOwner() { return owner; }

    public Auction(Article article, double value, User owner) {
        this.article = article;
        this.value = value;
        this.owner = owner;
    }

    private Bid findBestBid(Set<Bid> bids) {
        Bid bestBid = new Bid(owner, value);
        for(Bid bid : bids) {
            if (bestBid.getOffer() < bid.getOffer()) {
                bestBid = bid;
            }
        }return bestBid;
    }

    private Bid findSecondBestBid() {
        Set<Bid> secondBids = new HashSet<>();
        Bid secondBestBid = new Bid(owner, 0);
        for (Bid bid : bids) {
            secondBids.add(bid);
        }
        secondBids.remove(secondBestBid);
        return findBestBid(secondBids);
    }

    public void add(Bid bid) {
        if (bid.getOffer() >= this.value) { bids.add(bid); }
    }

    public String close() {
        Bid first = findBestBid(bids);
        Bid second = findSecondBestBid();
        String toString = "AUCTION CLOSED FOR "+article.getDescription()+"\nSELLER(PRICE): "+article.getOwner()+"("+value+ ")\nWINNER: ";
        if (bids.size() == 1) {
            transfer(first.getBidder(), value);
            return toString+first.getBidder().getName()+"("+value+")";
        }
        else if (first.getOffer() == second.getOffer()) {
            transfer(second.getBidder(), second.getOffer());
            return toString+second.getBidder().getName()+"("+second.getOffer()+")";
        }
        else {
            transfer(first.getBidder(), first.getOffer());
            return toString+first.getBidder().getName()+"("+first.getOffer()+")";
        }
    }

    public void transfer(User newOwner, double price) {
        newOwner.receive(article);
        owner.giveBack(article);
        article.setOwner(newOwner);
        owner.getAccount().deposit(price);
        newOwner.getAccount().withdraw(price);
    }

}
