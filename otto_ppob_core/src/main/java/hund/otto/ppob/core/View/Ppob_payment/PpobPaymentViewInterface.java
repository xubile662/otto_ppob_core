package hund.otto.ppob.core.View.Ppob_payment;

import android.content.Intent;
import android.net.Uri;

public interface PpobPaymentViewInterface {
    void showErrorMessage(int code, String title, String message);

    void showLoadingDialog(String loadingMessage, boolean showtoolbar, boolean iscancelable);

    void hideActiveLoadingDialog();

    void resetViewState();

    void toggleNextView();

    void toggleOnPaymentDoneActivity(Intent intent);

    void togglePayTypeView();

    void callPinInputDialog();

    void addWalletData(String ownerNae, String accountNum, Uri logo, String bal);

    void showQrDialog(String qrString, String productNae, String paybleValue);

    void updateQrDialog(String qrString, String productNae, String paybleValue);

    void showPaymentConfirmPage(String modal, String komisi, String total);


}
