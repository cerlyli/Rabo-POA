package nl.rabobank.powerofattorney.api.products;

public class GenericCard {
    private String id;
    private String status;
    private float cardNumber;
    private float sequenceNumber;
    private String cardHolder;

    // Getter Methods

    public String getId() {
        return id;
    }

    public String getStatus() {
        return status;
    }

    public float getCardNumber() {
        return cardNumber;
    }

    public float getSequenceNumber() {
        return sequenceNumber;
    }

    public String getCardHolder() {
        return cardHolder;
    }
    // Setter Methods

    public void setId(String id) {
        this.id = id;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setCardNumber(float cardNumber) {
        this.cardNumber = cardNumber;
    }

    public void setSequenceNumber(float sequenceNumber) {
        this.sequenceNumber = sequenceNumber;
    }

    public void setCardHolder(String cardHolder) {
        this.cardHolder = cardHolder;
    }
}