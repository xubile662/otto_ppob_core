package hund.otto.ppob.core.View.Receipt;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.jaeger.library.StatusBarUtil;

import java.util.ArrayList;
import java.util.List;

import app.beelabs.com.codebase.base.BaseActivity;
import app.beelabs.com.codebase.base.response.BaseResponse;
import app.beelabs.com.codebase.component.ProgressDialogComponent;
import hund.otto.ppob.core.Interactor.Model.Misc.WidgetBuilderModel;
import hund.otto.ppob.core.Interactor.Model.ResponseModel.base.BaseResponseModel;
import hund.otto.ppob.core.R;
import hund.otto.ppob.core.View.component.KeyValueListAdapter;
import retrofit2.Response;

public class PayDetailActivity extends BaseActivity {

    ImageView closeButton;
    LinearLayout shareButton;
    RecyclerView rv_asd;
    KeyValueListAdapter displayAdapter;
    NestedScrollView nsv_parent;

    View header;
    TextView tv_header;

    List<WidgetBuilderModel> saleData = new ArrayList();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        StatusBarUtil.setColor(this, ContextCompat.getColor(this, R.color.dark_grey_blue));
        setContentView(R.layout.activity_pay_detail);

        initComponent();
        initContent();
    }

    private void initComponent() {
        closeButton = findViewById(R.id.closeButton);
        shareButton = findViewById(R.id.shareButton);
        rv_asd = findViewById(R.id.rv_asd);
        rv_asd.setFocusable(false);
        nsv_parent = findViewById(R.id.nsv_parent);
        header = findViewById(R.id.header);

        tv_header = findViewById(R.id.tv_header);
    }

    private void initContent() {
        header.requestFocus();

        if (getIntent().hasExtra("data")) {
            saleData = getIntent().getParcelableArrayListExtra("data");

            displayAdapter = new KeyValueListAdapter(saleData, R.layout.cw_textview_c_letwrapper);
            rv_asd.setAdapter(displayAdapter);
            rv_asd.setLayoutManager(new LinearLayoutManager(this));
            displayAdapter.notifyDataSetChanged();
            shareButton.setVisibility(View.VISIBLE);
        }

        if (getIntent().hasExtra("uimsg")) {
            tv_header.setText(getIntent().getStringExtra("uimsg"));
            tv_header.setVisibility(View.VISIBLE);
        }

        closeButton.setOnClickListener(new View.OnClickListener()

        {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        if (shareButton != null)
            shareButton.setOnClickListener(new View.OnClickListener()

            {
                @Override
                public void onClick(View v) {
                    shareReceipt(saleData);
                }
            });
    }

    @Override
    public void onBackPressed() {
        finish();
    }

    @Override
    protected void onApiResponseCallback(BaseResponse br, int responseCode, Response response) {
        ProgressDialogComponent.dismissProgressDialog(this);
        if (response.isSuccessful()) {
            switch (responseCode) {
                case 100:
                    if (((BaseResponseModel) br).getMeta().getCode() == 200) {
                        Toast.makeText(this, "Data Telah Tersimpan", Toast.LENGTH_SHORT).show();
                    } else
                        Toast.makeText(this, ((BaseResponseModel) br).getMeta().getMessage(), Toast.LENGTH_SHORT).show();
                    break;
                default:

                    break;
            }
        }
    }

    private void shareReceipt(List<WidgetBuilderModel> saleData) {
        String receiptContent = "Transaksi Berhasil\n\n Detail transaksi anda:\n";

        for (WidgetBuilderModel wbm : saleData) {
            receiptContent += wbm.getKey() + ": " + wbm.getValue() + "\n";
        }

        Intent sendIntent = new Intent();
        sendIntent.setAction(Intent.ACTION_SEND);
        sendIntent.putExtra(Intent.EXTRA_TEXT, receiptContent);
        sendIntent.setType("text/plain");
        startActivity(Intent.createChooser(sendIntent, "Bagikan melalui..."));
    }
}
