package gov.iti.jets.domain.dtos;

public class CardDto {

    private String number;
    private String cvc;
    private long expMonth;
    private long expYear;

    public CardDto( String number, String cvc, long expMonth, long expYear ) {
        this.number = number;
        this.cvc = cvc;
        this.expMonth = expMonth;
        this.expYear = expYear;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber( String number ) {
        this.number = number;
    }

    public String getCvc() {
        return cvc;
    }

    public void setCvc( String cvc ) {
        this.cvc = cvc;
    }

    public long getExpMonth() {
        return expMonth;
    }

    public void setExpMonth( long expMonth ) {
        this.expMonth = expMonth;
    }

    public long getExpYear() {
        return expYear;
    }

    public void setExpYear( long expYear ) {
        this.expYear = expYear;
    }
}
