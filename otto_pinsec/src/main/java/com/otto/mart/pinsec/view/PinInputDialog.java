package com.otto.mart.pinsec.view;

import android.app.Dialog;
import android.content.Context;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.otto.mart.R;
import com.otto.mart.pinsec.presenter.PinInputBasePresenter;
import com.otto.mart.pinsec.presenter.PinInputStandardPresenter;

import app.beelabs.com.codebase.base.BaseActivity;
import app.beelabs.com.codebase.base.BaseFragment;
import app.beelabs.com.codebase.di.component.AppComponent;
import glenn.base.viewmodule.dialog.ErrorDialog;

public class PinInputDialog extends Dialog implements PinInputViewInterface {

    final String TAG = getClass().getSimpleName();
    View backBtn, layout_retcontainer;
    TextView tv_text, tv_retries;
    ImageView dot1, dot2, dot3, dot4, dot5, dot6;
    View k1, k2, k3, k4, k5, k6, k7, k8, k9, k0, kb, kx;

    private PinInputBasePresenter presenter;
    private PinInputDialogInterface listener;


    public PinInputDialog(@NonNull Context context, AppComponent appComponent, BaseFragment parent, int themeResId, String ep) {
        super(context, themeResId);
        presenter = new PinInputStandardPresenter(this, appComponent, parent, ep);
        initComponent();
        initContent();
    }

    public PinInputDialog(@NonNull Context context, AppComponent appComponent, BaseActivity parent, int themeResId, String ep) {
        super(context, themeResId);
        presenter = new PinInputStandardPresenter(this, appComponent, parent, ep);
        initComponent();
        initContent();
    }

    public PinInputDialog(@NonNull Context context, int themeResId, PinInputBasePresenter presenter) {
        super(context, themeResId);
        this.presenter = presenter;
        initComponent();
        initContent();
    }

    public void setListener(PinInputDialogInterface listener) {
        this.listener = listener;
    }

    public void initComponent() {
        ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        this.addContentView(LayoutInflater.from(getContext()).inflate(R.layout.view_pinpad, null), params);
        tv_text = findViewById(R.id.tv_jenk);
        dot1 = findViewById(R.id.pin1);
        dot2 = findViewById(R.id.pin2);
        dot3 = findViewById(R.id.pin3);
        dot4 = findViewById(R.id.pin4);
        dot5 = findViewById(R.id.pin5);
        dot6 = findViewById(R.id.pin6);

        k1 = findViewById(R.id.l_1);
        k2 = findViewById(R.id.l_2);
        k3 = findViewById(R.id.l_3);
        k4 = findViewById(R.id.l_4);
        k5 = findViewById(R.id.l_5);
        k6 = findViewById(R.id.l_6);
        k7 = findViewById(R.id.l_7);
        k8 = findViewById(R.id.l_8);
        k9 = findViewById(R.id.l_9);
        k0 = findViewById(R.id.l_0);
        kb = findViewById(R.id.l_b);
        kx = findViewById(R.id.l_x);
        backBtn = findViewById(R.id.layout_back);
        tv_retries = findViewById(R.id.tv_pinchance);
        layout_retcontainer = findViewById(R.id.layout_pinchance);
    }

    public void initContent() {
        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int i = v.getId();
                if (i == R.id.l_1)
                    presenter.addPinString(1 + "");
                else if (i == R.id.l_2)
                    presenter.addPinString(2 + "");
                else if (i == R.id.l_3)
                    presenter.addPinString(3 + "");
                else if (i == R.id.l_4)
                    presenter.addPinString(4 + "");
                else if (i == R.id.l_5)
                    presenter.addPinString(5 + "");
                else if (i == R.id.l_6)
                    presenter.addPinString(6 + "");
                else if (i == R.id.l_7)
                    presenter.addPinString(7 + "");
                else if (i == R.id.l_8)
                    presenter.addPinString(8 + "");
                else if (i == R.id.l_9)
                    presenter.addPinString(9 + "");
                else if (i == R.id.l_0)
                    presenter.addPinString(0 + "");
                else if (i == R.id.l_b)
                    presenter.delPinString();
                else if (i == R.id.l_x) {
                    //TODO go to forgotpin
                }
            }
        };
        k1.setOnClickListener(listener);
        k2.setOnClickListener(listener);
        k3.setOnClickListener(listener);
        k4.setOnClickListener(listener);
        k5.setOnClickListener(listener);
        k6.setOnClickListener(listener);
        k7.setOnClickListener(listener);
        k8.setOnClickListener(listener);
        k9.setOnClickListener(listener);
        k0.setOnClickListener(listener);
        kb.setOnClickListener(listener);
        kx.setOnClickListener(listener);
    }

    @Override
    public void doInputDoneState(String value) {
//        presenter.onInputDone(value);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

            }
        }, 1000);
    }

    @Override
    public void doSuccessState(String returnValue) {
        //todo successstate
        if (listener != null)
            listener.onSuccess(returnValue);
    }

    @Override
    public void doFailState() {
        //todo failstate
        if (listener != null)
            listener.onFail();
    }

    @Override
    public void doNoConnectionState() {
        ErrorDialog dialog = new ErrorDialog(getContext(), getOwnerActivity(), false, false, "error", "Tidak ada Koneksi ke server");
        dialog.show();
    }

    @Override
    public void showLoading() {
        listener.onLoading();
    }

    @Override
    public void hideLoading() {
        listener.onLoadingDone();
    }

    @Override
    public void setPinstate(int state) {
        switch (state) {
            case 0:
                dot1.setImageResource(R.drawable.circle_white_border);
                dot2.setImageResource(R.drawable.circle_white_border);
                dot3.setImageResource(R.drawable.circle_white_border);
                dot4.setImageResource(R.drawable.circle_white_border);
                dot5.setImageResource(R.drawable.circle_white_border);
                dot6.setImageResource(R.drawable.circle_white_border);
                break;
            case 1:
                dot1.setImageResource(R.drawable.circle_white_solid);
                dot2.setImageResource(R.drawable.circle_white_border);
                dot3.setImageResource(R.drawable.circle_white_border);
                dot4.setImageResource(R.drawable.circle_white_border);
                dot5.setImageResource(R.drawable.circle_white_border);
                dot6.setImageResource(R.drawable.circle_white_border);
                break;
            case 2:
                dot1.setImageResource(R.drawable.circle_white_solid);
                dot2.setImageResource(R.drawable.circle_white_solid);
                dot3.setImageResource(R.drawable.circle_white_border);
                dot4.setImageResource(R.drawable.circle_white_border);
                dot5.setImageResource(R.drawable.circle_white_border);
                dot6.setImageResource(R.drawable.circle_white_border);
                break;
            case 3:
                dot1.setImageResource(R.drawable.circle_white_solid);
                dot2.setImageResource(R.drawable.circle_white_solid);
                dot3.setImageResource(R.drawable.circle_white_solid);
                dot4.setImageResource(R.drawable.circle_white_border);
                dot5.setImageResource(R.drawable.circle_white_border);
                dot6.setImageResource(R.drawable.circle_white_border);
                break;
            case 4:
                dot1.setImageResource(R.drawable.circle_white_solid);
                dot2.setImageResource(R.drawable.circle_white_solid);
                dot3.setImageResource(R.drawable.circle_white_solid);
                dot4.setImageResource(R.drawable.circle_white_solid);
                dot5.setImageResource(R.drawable.circle_white_border);
                dot6.setImageResource(R.drawable.circle_white_border);
                break;
            case 5:
                dot1.setImageResource(R.drawable.circle_white_solid);
                dot2.setImageResource(R.drawable.circle_white_solid);
                dot3.setImageResource(R.drawable.circle_white_solid);
                dot4.setImageResource(R.drawable.circle_white_solid);
                dot5.setImageResource(R.drawable.circle_white_solid);
                dot6.setImageResource(R.drawable.circle_white_border);
                break;
            case 6:
                dot1.setImageResource(R.drawable.circle_white_solid);
                dot2.setImageResource(R.drawable.circle_white_solid);
                dot3.setImageResource(R.drawable.circle_white_solid);
                dot4.setImageResource(R.drawable.circle_white_solid);
                dot5.setImageResource(R.drawable.circle_white_solid);
                dot6.setImageResource(R.drawable.circle_white_solid);
                break;
            default:

                break;
        }
    }

    public interface PinInputDialogInterface {
        void onSuccess(String returnValue);

        void onFail();

        void onLoading();

        void onLoadingDone();
    }
}
