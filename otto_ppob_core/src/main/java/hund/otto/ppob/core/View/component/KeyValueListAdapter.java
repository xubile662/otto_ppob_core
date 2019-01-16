package hund.otto.ppob.core.View.component;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import glenn.base.viewmodule.textView.LazyTextview;
import hund.otto.ppob.core.Interactor.Model.Misc.WidgetBuilderModel;
import hund.otto.ppob.core.R;

public class KeyValueListAdapter extends RecyclerView.Adapter<KeyValueListAdapter.KudaHolder> {
    private List<WidgetBuilderModel> models = new ArrayList<>();
    private int layoutID;

    public KeyValueListAdapter(int layoutID) {
        this.layoutID = layoutID;
    }

    public KeyValueListAdapter(List<WidgetBuilderModel> models, int layoutID) {
        if (models != null)
            this.models = models;
        this.layoutID = layoutID;
    }

    @NonNull
    @Override
    public KeyValueListAdapter.KudaHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(layoutID, parent, false);
        return new KeyValueListAdapter.KudaHolder(itemView);

    }

    @Override
    public void onBindViewHolder(@NonNull KudaHolder holder, int position) {
        WidgetBuilderModel model = models.get(position);
        holder.let_tv.setTitle(model.getKey() != null ? model.getKey() : "");
        holder.let_tv.setText(model.getValue() != null ? model.getValue() : "");
    }

    @Override
    public int getItemCount() {
        return models.size();
    }

    public void replaceModel(List<WidgetBuilderModel> models) {
        this.models = models;
        this.notifyDataSetChanged();
    }

    public void clearModel() {
        this.models.clear();
        this.notifyDataSetChanged();
    }

    public class KudaHolder extends RecyclerView.ViewHolder {
        LazyTextview let_tv;

        public KudaHolder(View itemView) {
            super(itemView);
            let_tv = itemView.findViewById(R.id.let_item);
        }

    }
}
