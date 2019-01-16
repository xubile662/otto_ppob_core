package hund.otto.ppob.core.Interactor.Model.Misc;

import hund.otto.ppob.core.Interactor.Model.KMB.Misc.ConfirmationModel;
import hund.otto.ppob.core.Interactor.Model.KMB.Misc.PaymentPriceModel;
import hund.otto.ppob.core.Interactor.Model.KMB.Misc.PulsaPaketModel;

public class PaymentConfirmationModel {
    private PaymentPriceModel paymentPriceModel;
    private PulsaPaketModel pulsaPaketModel;
    private ConfirmationModel listrikModel;


    public PulsaPaketModel getPulsaPaketModel() {
        return pulsaPaketModel;
    }

    public void setPulsaPaketModel(PulsaPaketModel pulsaPaketModel) {
        this.pulsaPaketModel = pulsaPaketModel;
    }

    public PaymentPriceModel getPaymentPriceModel() {
        return paymentPriceModel;
    }

    public void setPaymentPriceModel(PaymentPriceModel paymentPriceModel) {
        this.paymentPriceModel = paymentPriceModel;
    }

    public ConfirmationModel getListrikModel() {
        return listrikModel;
    }

    public void setListrikModel(ConfirmationModel listrikModel) {
        this.listrikModel = listrikModel;
    }
}
