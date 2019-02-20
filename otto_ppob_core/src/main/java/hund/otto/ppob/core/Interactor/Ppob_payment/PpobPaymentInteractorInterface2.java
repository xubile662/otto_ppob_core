package hund.otto.ppob.core.Interactor.Ppob_payment;

import java.util.List;

import hund.otto.ppob.core.Interactor.Model.Misc.WalletDataModel;
import hund.otto.ppob.core.Interactor.Model.Misc.WidgetBuilderModel;

public interface PpobPaymentInteractorInterface2 extends aBaseIteractorInterface {

    void onPaymentSuccess(String productCode, String productType, String custRef, String uimsg, List<WidgetBuilderModel> keyval);

    void onRequestAdvice(String productPool);
    void onQrPaymentCanceled();

    void onRequestQrPaymentSuccess(String qrString, String productName, String paybleAmount);

    void onWalletRequestSuccess(List<WalletDataModel> walletDataModels);

    void onQrStringRequestSuccess(String qrString);




}
