package nl.rabobank.powerofattorney.api.products;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Account {
    @Id
    @GeneratedValue
    private Long id;
    private String owner;
    private double balance;
    private String created;
    private String ended;

    // Getter Methods

    public String getOwner() {
        return owner;
    }

    public double getBalance() {
        return balance;
    }

    public String getCreated() {
        return created;
    }

    public String getEnded() {
        return ended;
    }

    // Setter Methods

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public void setEnded(String ended) {
        this.ended = ended;
    }

}
