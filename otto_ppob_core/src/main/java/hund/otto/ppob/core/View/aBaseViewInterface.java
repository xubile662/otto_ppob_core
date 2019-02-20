package hund.otto.ppob.core.View;

public interface aBaseViewInterface {
    void showLoading();
    void hideLoading();
    void showErrorDialog(String title, String msg);
    void terminate();
}
