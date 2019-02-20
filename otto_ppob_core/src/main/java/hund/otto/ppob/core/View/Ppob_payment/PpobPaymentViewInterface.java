package hund.otto.ppob.core.View.Ppob_payment;

import android.content.Intent;
import android.net.Uri;

import hund.otto.ppob.core.View.aBaseViewInterface;

public interface PpobPaymentViewInterface extends aBaseViewInterface {
    void showPaymentView();

    void resetViewState();

    void toggleNextView();

    void togglePayTypeView();

    void callPinInputDialog();

    void addWalletData(String ownerNae, String accountNum, Uri logo, String bal);

    void showQrDialog(String qrString, String productNae, String paybleValue);

    void updateQrDialog(String qrString, String productNae, String paybleValue);

    void showPaymentConfirmPage(String modal, String komisi, String total);

    void toggleOnPaymentDoneActivity(Intent intent);
}
