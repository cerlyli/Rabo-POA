package nl.rabobank.powerofattorney.api.products;

public class DebitCard extends GenericCard{

        AtmLimit AtmLimitObject;
        PosLimit PosLimitObject;
        private boolean contactless;

        // Getter Methods
        public AtmLimit getAtmLimit() {
            return AtmLimitObject;
        }

        public PosLimit getPosLimit() {
            return PosLimitObject;
        }

        public boolean getContactless() {
            return contactless;
        }

        // Setter Methods
        public void setAtmLimit(AtmLimit atmLimitObject) {
            this.AtmLimitObject = atmLimitObject;
        }

        public void setPosLimit(PosLimit posLimitObject) {
            this.PosLimitObject = posLimitObject;
        }

        public void setContactless(boolean contactless) {
            this.contactless = contactless;
        }
}

class Limit {
    private float limit;
    private String periodUnit;


    // Getter Methods

    public float getLimit() {
        return limit;
    }

    public String getPeriodUnit() {
        return periodUnit;
    }

    // Setter Methods
    public void setLimit(float limit) {
        this.limit = limit;
    }

    public void setPeriodUnit(String periodUnit) {
        this.periodUnit = periodUnit;
    }
}

class PosLimit extends Limit{};
class AtmLimit extends Limit{};