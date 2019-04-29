package demo;

public class Model {

    public Model(String clientName, Integer amount) {
        this.clientName = clientName;
        this.amount = amount;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    String clientName;
    Integer amount;

}
