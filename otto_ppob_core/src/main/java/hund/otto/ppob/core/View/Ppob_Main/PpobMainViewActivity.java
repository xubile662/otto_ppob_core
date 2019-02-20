package hund.otto.ppob.core.View.Ppob_Main;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;

import com.jaeger.library.StatusBarUtil;
import com.ogaclejapan.smarttablayout.SmartTabLayout;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItemAdapter;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItems;
import com.otto.hund.pinsec.view.PinInputDialog;

import org.greenrobot.eventbus.EventBus;

import java.util.List;

import app.beelabs.com.codebase.base.BaseActivity;
import app.beelabs.com.codebase.component.ProgressDialogComponent;
import hund.otto.ppob.core.CORE;
import hund.otto.ppob.core.Interactor.Model.Event.FragmentTransactionEvent;
import hund.otto.ppob.core.Interactor.Model.Event.PinInteractorCallDoneEvent;
import hund.otto.ppob.core.Interactor.Model.Event.PinInteractorCallFailEvent;
import hund.otto.ppob.core.Presenter.Ppob_main.OttoPpobPresenter;
import hund.otto.ppob.core.R;
import hund.otto.ppob.core.View.aBaseViewActivity;

public class PpobMainViewActivity extends aBaseViewActivity implements PpobMainViewInterface {

    private SmartTabLayout smt;
    private ViewPager vp;
    private FragmentPagerItemAdapter smtAdpt;
    private int selectedItemIndex;
    private ImageView toolbarBack;
    private boolean isPinActivityCanceled, isPinActivityTriggered;
    private FragmentPagerItems fragments;
    private OttoPpobPresenter presenter;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ppob);
        initComponent();
        initContent();
    }

    @Override
    public void onStart() {
        super.onStart();
        presenter.onStart();
    }

    @Override
    public void onStop() {
        presenter.onStop();
        super.onStop();
    }

    private void initComponent() {
        vp = findViewById(R.id.viewpager);
        smt = findViewById(R.id.viewpagertab);
        toolbarBack = findViewById(R.id.toolbar_back);
        fragments = new FragmentPagerItems(this);
        presenter = new OttoPpobPresenter(this);
    }

    private void initContent() {
        StatusBarUtil.setDarkMode(this);
        StatusBarUtil.setColor(this, ContextCompat.getColor(this, R.color.prussian_blue));

        if (selectedItemIndex != 0) {
            vp.setCurrentItem(selectedItemIndex, true);
        }

        toolbarBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        List<FragmentTransactionEvent> evt = CORE.getPages();
        FragmentPagerItems.Creator fragtems = FragmentPagerItems.with(this);
        for (FragmentTransactionEvent ev :
                evt) {
            fragtems.add(ev.getTitle(), ev.getFragmentClass());
        }

        smtAdpt = new FragmentPagerItemAdapter(getSupportFragmentManager(), fragtems.create());
        vp.setAdapter(smtAdpt);
        smt.setViewPager(vp);
    }

    //interface func
    @Override
    public void callCheckPinActivity() {
        final PinInputDialog pinInputDialog = new PinInputDialog(this, CORE.getAppComponent(), this, R.style.CoconutDialogFullScreen, CORE.getEndpoint());
        pinInputDialog.setListener(new PinInputDialog.PinInputDialogInterface() {
            @Override
            public void onSuccess(String returnValue) {
                EventBus.getDefault().post(new PinInteractorCallDoneEvent(returnValue));
                isPinActivityTriggered = false;
                pinInputDialog.dismiss();
            }

            @Override
            public void onFail() {
                EventBus.getDefault().post(new PinInteractorCallFailEvent());
                isPinActivityCanceled = true;
                isPinActivityTriggered = false;
            }

            @Override
            public void onLoading() {

            }

            @Override
            public void onLoadingDone() {

            }
        });
        isPinActivityTriggered = true;

        pinInputDialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
            @Override
            public void onDismiss(DialogInterface dialog) {
                isPinActivityCanceled = true;
                isPinActivityTriggered = false;
            }
        });
        pinInputDialog.show();
    }

    @Override
    public void activateProgressDialog() {
        ProgressDialogComponent.showProgressDialog(this, "Memproses Permintaan", false).show();
    }

    @Override
    public void removeProgressDialog() {
        ProgressDialogComponent.dismissProgressDialog(this);
    }

}
