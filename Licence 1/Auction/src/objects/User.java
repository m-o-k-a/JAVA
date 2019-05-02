package objects;

import java.util.HashSet;
import java.util.Set;

public class User {

    private String name;
    private Account account;
    private Set<Article> articlesOwned = new HashSet<>();

    public User(String name, Account account, Set<Article> articlesOwned) {
        this.name = name;
        this.account = account;
        this.articlesOwned = articlesOwned;
    }

    public String getArticlesOwned() {
        String articles = "";
        for (Article article : articlesOwned) {
            articles += article.getDescription()+"\n";
        }return  articles;
    }

    public String getName() { return name; }

    public Account getAccount() { return account; }

    public void giveBack(Article article) { articlesOwned.remove(article); }
    public void receive(Article article) { articlesOwned.add(article); }

    public Auction sell(Article article, double initialPrice) {
        if (articlesOwned.contains(article)) {
            return new Auction(article, initialPrice, this);
        }return null;
    }
    public void bid(Auction auction, double maximumPrice) {
        auction.add(new Bid(this, maximumPrice));
    }
}
