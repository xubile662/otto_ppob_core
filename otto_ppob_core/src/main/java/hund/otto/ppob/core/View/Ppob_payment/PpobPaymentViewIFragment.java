package hund.otto.ppob.core.View.Ppob_payment;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.otto.hund.pinsec.view.PinInputDialog;
import com.otto.mart.viewmodule.dialog.QrDynamicDialog;

import net.cachapa.expandablelayout.ExpandableLayout;

import glenn.base.viewmodule.textView.LazyTextview;
import hund.otto.ppob.core.CORE;
import hund.otto.ppob.core.Presenter.Ppob_payment.PpobPaymentPresenter;
import hund.otto.ppob.core.R;
import hund.otto.ppob.core.View.aBaseViewFragment;

public class PpobPaymentViewIFragment extends aBaseViewFragment implements PpobPaymentViewInterface {
    private Context mContext;
    private View mView, action0, action1, tv_action, footer;
    private RadioGroup rb_rg;
    private TextView tv_phone, tv_amount, tv_peoplename;
    private ExpandableLayout el1, el2, el3;
    private LinearLayout ll_payconfirm;

    private LazyTextview modal, komisi, total;
    private PpobPaymentPresenter presenter;
    private QrDynamicDialog qrDialog;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mContext = getParentFragment().getActivity();
        mView = inflater.inflate(R.layout.fragment_ppob_payment, container, false);
        initComponent();
        initContent();
        return mView;
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    public void onStart() {
        super.onStart();
        presenter.onResume();
    }


    @Override
    public void onStop() {
        presenter.onPause();
        super.onStop();
    }

    private void initComponent() {
        action1 = mView.findViewById(R.id.tv_action1);
        rb_rg = mView.findViewById(R.id.rb_rg);
        tv_action = mView.findViewById(R.id.tv_action);
        tv_phone = mView.findViewById(R.id.phone);
        tv_peoplename = mView.findViewById(R.id.name);
        tv_amount = mView.findViewById(R.id.balance);
        action0 = mView.findViewById(R.id.tv_action_0);

        el1 = mView.findViewById(R.id.ex1);
        el2 = mView.findViewById(R.id.ex2);
        el3 = mView.findViewById(R.id.ex3);

        modal = mView.findViewById(R.id.ltv_modal);
        komisi = mView.findViewById(R.id.ltv_komisi);
        total = mView.findViewById(R.id.ltv_total);
        footer = mView.findViewById(R.id.footer);

        presenter = new PpobPaymentPresenter(getContext(), this, this);
        qrDialog = new QrDynamicDialog(getContext(), getActivity(), true);

        ll_payconfirm = mView.findViewById(R.id.ll_payconfirm);

        action1 = mView.findViewById(R.id.tv_action1);
    }

    private void initContent() {
        action0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                el1.setExpanded(false);
                el2.setExpanded(true);
                el3.setExpanded(true);
                presenter.postScrollRequest(true);
            }
        });

        rb_rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.rb_cash) {
                    presenter.setPayentType(false);
                } else if (checkedId == R.id.rb_qr) {
                    presenter.setPayentType(true);
                }
            }
        });
        action1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.callOttoagPayment();
            }
        });
    }

    /**
     * lanjutkan arrowdown view
     *
     * @return el1.isExpanded()
     */
    public boolean toggleEl1() {
        el1.toggle();
        return el1.isExpanded();
    }

    public boolean el1IsExpanded() {
        return el1.isExpanded();
    }

    /**
     * qr-cash radiogroup view
     *
     * @return el2.isExpanded()
     */
    public boolean toogleEl2() {
        el2.toggle();
        return el2.isExpanded();
    }

    public boolean el2IsExpanded() {
        return el2.isExpanded();
    }

    /**
     * qr-cash the rest view
     *
     * @return el3.isExpanded()
     */
    public boolean toogleEl3() {
        el3.toggle();
        return el3.isExpanded();
    }

    public boolean el3IsExpanded() {
        return el3.isExpanded();
    }

    public PpobPaymentPresenter getPresenter() {
        return presenter;
    }

    @Override
    public void showPaymentView() {

    }

    /**
     * reset all all view on payment
     */
    @Override
    public void resetViewState() {
        el1.setExpanded(true);
        el2.setExpanded(false);
        el3.setExpanded(false);
    }

    @Override
    public void toggleNextView() {
        resetViewState();
    }

    @Override
    public void toggleOnPaymentDoneActivity(Intent intent) {
        startActivity(intent);
        getActivity().finish();
    }

    @Override
    public void togglePayTypeView() {
        el2.toggle();
        el3.setExpanded(el2.isExpanded());
    }

    @Override
    public void callPinInputDialog() {
        PinInputDialog pinDialog = new PinInputDialog(getContext(), CORE.getAppComponent(), this, R.style.CoconutDialogFullScreen, CORE.getEndpoint());
        pinDialog.setListener(new PinInputDialog.PinInputDialogInterface() {
            @Override
            public void onSuccess(String returnValue) {
                presenter.addPayentPin(returnValue);
            }

            @Override
            public void onFail() {
                //todo onfailed, call activity callback
            }

            @Override
            public void onLoading() {
                //nothing
            }

            @Override
            public void onLoadingDone() {
                //nothing
            }
        });
    }

    /**
     * @param ownerNae
     * @param accountNum
     * @param logo
     * @param bal        balance
     */
    @Override
    public void addWalletData(String ownerNae, String accountNum, Uri logo, String bal) {
        tv_phone.setText(accountNum);
        tv_peoplename.setText(ownerNae);
        tv_amount.setText(bal);
    }

    /**
     * @param qrString
     * @param productNae
     * @param paybleValue
     */
    @Override
    public void showQrDialog(String qrString, String productNae, String paybleValue) {
        qrDialog.show();
    }

    /**
     * @param qrString
     * @param productNae
     * @param paybleValue
     */
    @Override
    public void updateQrDialog(String qrString, String productNae, String paybleValue) {
        qrDialog.dismiss();
    }

    /**
     * @param modal
     * @param komisi
     * @param total
     */
    @Override
    public void showPaymentConfirmPage(String modal, String komisi, String total) {
        this.modal.setText(modal);
        this.komisi.setText(komisi);
        this.total.setText(total);
        ll_payconfirm.setVisibility(View.VISIBLE);
    }

}
