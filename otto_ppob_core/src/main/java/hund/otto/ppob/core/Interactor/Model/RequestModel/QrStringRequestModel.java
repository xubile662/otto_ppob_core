package hund.otto.ppob.core.Interactor.Model.RequestModel;

public class QrStringRequestModel {

    int amount;
    String bill_ref_num;

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getBill_ref_num() {
        return bill_ref_num;
    }

    public void setBill_ref_num(String bill_ref_num) {
        this.bill_ref_num = bill_ref_num;
    }
}
