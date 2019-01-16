package hund.otto.ppob.core.View.Ppob_landing;

import hund.otto.ppob.core.View.Ppob_product.PpobBaseProductFragment;

public interface PpobBaseViewInterface {

    void loadPaymentFragment();

    void loadProductFragment(PpobBaseProductFragment productFragment);

    void reLoadPaymentFragment();

    void reLoadProductFragment(PpobBaseProductFragment ppobBaseProductFragment);

    void showPaymentFragment();

    void hidePaymentFragment();

    void nsvScrollToBottom();

    void nsvScrollToTop();
}
