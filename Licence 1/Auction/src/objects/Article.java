package objects;

public class Article {

    private String description;
    private User owner;

    public Article(String description, User owner) {
        this.description = description;
        this.owner = owner;
    }

    public String getDescription() { return description; }
    public User getOwner() { return owner; }

    public void setOwner(User owner) { this.owner = owner; }
}
