package main;

import objects.*;

import java.util.HashSet;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        User eddy = new User("Eddy", new Account(500), new HashSet<>());
        User oanh = new User("Oanh", new Account(200), new HashSet<>());
        User doraemon = new User("Doraemon", new Account(100), new HashSet<>());
        Article baguette = new Article("baguette", eddy);
        Article milkTea = new Article("milk tea", oanh);
        Article japan = new Article("japan", doraemon);
        eddy.receive(baguette);
        oanh.receive(milkTea);
        doraemon.receive(japan);
        System.out.println(baguette.getOwner());

        Auction firstAuction = new Auction(baguette, 50, eddy);
        firstAuction.add(new Bid(doraemon, 100));
        firstAuction.add(new Bid(oanh, 150));
        System.out.println(firstAuction.close());

        Auction secondAuction = new Auction(milkTea, 300, oanh);
        secondAuction.add(new Bid(eddy, 305));
        System.out.println(secondAuction.close());

        System.out.println(eddy.getAccount().getBalance());
        System.out.println(eddy.getArticlesOwned());
        System.out.println(oanh.getAccount().getBalance());
        System.out.println(oanh.getArticlesOwned());
        System.out.println(doraemon.getAccount().getBalance());
        System.out.println(doraemon.getArticlesOwned());
    }
}
