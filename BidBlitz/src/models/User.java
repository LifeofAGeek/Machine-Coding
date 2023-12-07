package models;

public class User {
    private String id;
    private String name;
    private Integer superCoins;

    public User(String id, String name, Integer superCoins) {
        this.id = id;
        this.name = name;
        this.superCoins = superCoins;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSuperCoins() {
        return superCoins;
    }

    public void setSuperCoins(Integer superCoins) {
        this.superCoins = superCoins;
    }
}
