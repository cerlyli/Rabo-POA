package nl.rabobank.powerofattorney.api.products;

import java.util.List;

public class Poa {
        private String id;
        private String grantor;
        private String grantee;
        private String account;
        private String direction;
        private List< String > authorizations;
        private List <Card> cards;


        // Getter Methods
        public String getId() {
            return id;
        }

        public String getGrantor() {
            return grantor;
        }

        public String getGrantee() {
            return grantee;
        }

        public String getAccount() {
            return account;
        }

        public String getDirection() {
            return direction;
        }

        // Setter Methods
        public void setId(String id) {
            this.id = id;
        }

        public void setGrantor(String grantor) {
            this.grantor = grantor;
        }

        public void setGrantee(String grantee) {
            this.grantee = grantee;
        }

        public void setAccount(String account) {
            this.account = account;
        }

        public void setDirection(String direction) {
            this.direction = direction;
        }

    public List<String> getAuthorizations() {
        return authorizations;
    }

    public void setAuthorizations(List<String> authorizations) {
        this.authorizations = authorizations;
    }

    public List<Card> getCards() {
        return cards;
    }

    public void setCards(List<Card> cards) {
        this.cards = cards;
    }
}


