package hund.otto.ppob.core.Interactor.Model.ResponseModel.base;

import android.content.Intent;
import android.widget.Toast;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MetaModel {
    int code;
    boolean status;
    String message;

    public int getCode() {
        if (code == 498) {
//            RepositoryManager.logout();
//            Toast.makeText(OttoMartApp.getContext(), "Maaf sesi aplikasi kamu telah habis - mohon login ulang", Toast.LENGTH_SHORT).show();
//            Intent jenk = new Intent(OttoMartApp.getContext(), LoginActivity.class);
//            jenk.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//            OttoMartApp.getContext().startActivity(jenk);

        }
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
