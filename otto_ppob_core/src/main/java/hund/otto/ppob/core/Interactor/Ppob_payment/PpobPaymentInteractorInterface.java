package hund.otto.ppob.core.Interactor.Ppob_payment;

import java.util.List;

import hund.otto.ppob.core.Interactor.Model.Misc.WalletDataModel;
import hund.otto.ppob.core.Interactor.Model.Misc.WidgetBuilderModel;

public interface PpobPaymentInteractorInterface {

    interface PpobPaymentCallback {
        void onConnectionFailed(Throwable t);

        void onApiFailed(int code, String message);

        void onQrPaymentCanceled();

        void onPaymentSuccess(String productCode, String productType, String custRef, String uimsg, List<WidgetBuilderModel> keyval);

        void onRequestAdvice(String productPool);

        void onRequestQrPaymentSuccess(String qrString, String productName, String paybleAmount);
    }

    interface WalletInteractorInterface {
        void onConnectionFailed(Throwable t);

        void onApiFailed(int code, String message);

        void onWalletRequestSuccess(List<WalletDataModel> walletDataModels);
    }

    interface QrInteractorInterface {
        void onConnectionFailed(Throwable t);

        void onApiFailed(int code, String message);

        void onQrStringRequestSuccess(String qrString);
    }

}
