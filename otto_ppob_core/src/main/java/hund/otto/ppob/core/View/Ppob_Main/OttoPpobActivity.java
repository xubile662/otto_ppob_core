package hund.otto.ppob.core.View.Ppob_Main;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;

import com.jaeger.library.StatusBarUtil;
import com.ogaclejapan.smarttablayout.SmartTabLayout;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItem;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItemAdapter;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItems;
import com.otto.mart.pinsec.view.PinInputDialog;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.List;

import app.beelabs.com.codebase.base.BaseActivity;
import app.beelabs.com.codebase.base.response.BaseResponse;
import app.beelabs.com.codebase.component.ProgressDialogComponent;
import hund.otto.ppob.core.CORE;
import hund.otto.ppob.core.Interactor.Model.Event.FragmentTransactionEvent;
import hund.otto.ppob.core.Interactor.Model.Event.PinInteractorCallDoneEvent;
import hund.otto.ppob.core.Interactor.Model.Event.PinInteractorCallFailEvent;
import hund.otto.ppob.core.R;
import retrofit2.Response;


//unit_test
public class OttoPpobActivity extends BaseActivity implements PpobMainViewInterface {
    private SmartTabLayout smt;
    private ViewPager vp;
    private FragmentPagerItemAdapter smtAdpt;
    private int selectedItemIndex;
    private PpobParentActivityCallback listener;
    private ImageView toolbarBack;
    private boolean isPinActivityCanceled, isPinActivityTriggered;
    private FragmentPagerItems fragments;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ppob);
        if (getIntent().hasExtra("extraInt")) {
            selectedItemIndex = getIntent().getIntExtra("extraInt", 0);
        }
        initContent();
        initComponent();
    }


    public void setListener(PpobParentActivityCallback listener) {
        this.listener = listener;
    }

    private void initContent() {
        vp = (ViewPager) findViewById(R.id.viewpager);
        smt = (SmartTabLayout) findViewById(R.id.viewpagertab);
        toolbarBack = findViewById(R.id.toolbar_back);
        fragments = FragmentPagerItems.with(this).create();
    }

    private void initComponent() {
        StatusBarUtil.setDarkMode(this);
        StatusBarUtil.setColor(this, ContextCompat.getColor(this, R.color.prussian_blue));
//        if (isProduction)
//            smtAdpt = new FragmentPagerItemAdapter(
//                    getSupportFragmentManager(), FragmentPagerItems.with(this)
//                    .add("Pulsa", PpobPulsaNominalParentFragment.class)
//                    .add("Paket Data", PpobPulsaPaketParentFragment.class)
//                    .add("Listrik", PpobListrikParentFragment.class)
//                    .add("Tagihan Air", PpobAirParentFragment.class, new Bundle())
//                    .add("BPJS", PpobBpjsParentFragment.class)
//                    .add("Telkom", PpobTelkomParentFragment.class)
////                    .add("Cicilan", PpobScamParentFragment.class)
////                    .add("Asuransi", PpobAsuParentFragment.class)
//                    .create());
//        else
//            smtAdpt = new FragmentPagerItemAdapter(
//                    getSupportFragmentManager(), FragmentPagerItems.with(this)
//                    .add("Pulsa", PpobPulsaNominalParentFragment.class)
//                    .add("Paket Data", PpobPulsaPaketParentFragment.class)
//                    .add("Listrik", PpobListrikParentFragment.class)
//                    .add("Tagihan Air", PpobAirParentFragment.class, new Bundle())
//                    .add("BPJS", PpobBpjsParentFragment.class)
//                    .add("Telkom", PpobTelkomParentFragment.class)
//                    .add("Cicilan", PpobScamParentFragment.class)
//                    .add("Asuransi", PpobAsuParentFragment.class)
//                    .add("Pendidikan", PpobPendidikanParentFragment.class)
//                    .add("Internet", PpobInternetParentFragment.class)
//                    .create());
        smtAdpt = new FragmentPagerItemAdapter(getSupportFragmentManager(), fragments);
        vp.setAdapter(smtAdpt);
        smt.setViewPager(vp);

        if (selectedItemIndex != 0) {
            vp.setCurrentItem(selectedItemIndex, true);
        }

        toolbarBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        //test
        List<FragmentTransactionEvent> evt = CORE.getPages();
        for (FragmentTransactionEvent ev :
                evt) {
            addProductFragment(ev.getTitle(), ev.getFragmentClass());
        }
    }


    @Override
    public void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    @Override
    public void onStop() {
        EventBus.getDefault().unregister(this);
        super.onStop();
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(FragmentTransactionEvent event) {
        addProductFragment(event.getTitle(), event.getFragmentClass());
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onPinInteractorCalledEvent(FragmentTransactionEvent event) {
        addProductFragment(event.getTitle(), event.getFragmentClass());
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 111 && requestCode != this.RESULT_OK) {
            isPinActivityCanceled = true;
        }
        if (listener != null) {
            listener.onActivityResult(requestCode, resultCode, data);
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    protected void onApiResponseCallback(BaseResponse br, int responseCode, Response response) {
        super.onApiResponseCallback(br, responseCode, response);
    }

    @Override
    public void callCheckPinActivity() {
        PinInputDialog pinDialog = new PinInputDialog(this, CORE.getAppComponent(), this, R.style.CoconutDialogFullScreen, CORE.getEndpoint());
        pinDialog.setListener(new PinInputDialog.PinInputDialogInterface() {
            @Override
            public void onSuccess(String returnValue) {
                EventBus.getDefault().post(new PinInteractorCallDoneEvent(returnValue));
            }

            @Override
            public void onFail() {
                EventBus.getDefault().post(new PinInteractorCallFailEvent());
            }

            @Override
            public void onLoading() {

            }

            @Override
            public void onLoadingDone() {

            }
        });
        isPinActivityTriggered = true;
    }

    @Override
    public void activateProgressDialog() {
        ProgressDialogComponent.showProgressDialog(this, "Memproses Permintaan", false).show();
    }

    @Override
    public void removeProgressDialog() {
        ProgressDialogComponent.dismissProgressDialog(this);
    }

    @Override
    public void addProductFragment(String title, Object classObject) {
        fragments.add(FragmentPagerItem.of(title, (Class<? extends Fragment>) classObject));
        smtAdpt.notifyDataSetChanged();
    }

    public boolean isPinActivityTriggered() {
        return isPinActivityTriggered;
    }

    public boolean isPinActivityCanceled() {
        return isPinActivityCanceled;
    }

    public void resetPinBoolTriggers() {
        isPinActivityTriggered = false;
        isPinActivityCanceled = false;
    }

    public interface PpobParentActivityCallback {
        void onActivityResult(int requestCode, int resultCode, Intent data);

        void onCallCheckPinTriggred();
    }

}
