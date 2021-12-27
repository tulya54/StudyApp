package com.lol.studyapp.adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.lol.studyapp.R;
import java.util.ArrayList;
import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    private final Context context;
    private final List<String> arrayList = new ArrayList<>();

    private final List<MyPOJO> myPOJOS = new ArrayList<>();

    public RecyclerViewAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        switch(viewType) {
            case 1:
                return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_list_data, parent, false));
            case 2:
                return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_list_data2, parent, false));
            case 3:
                return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_list_data3, parent, false));
            default:
                return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_list_data, parent, false));
        }
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bind(myPOJOS.get(position));
    }

    @Override
    public int getItemCount() {
        return myPOJOS.size();
    }

    @Override
    public int getItemViewType(int position) {
        return myPOJOS.get(position).getIndex();
    }

    @SuppressLint("NotifyDataSetChanged")
    public void setData(List<String> list) {
        if (arrayList.size() > 0)
            arrayList.clear();
        arrayList.addAll(list);
        notifyDataSetChanged();
    }

    @SuppressLint("NotifyDataSetChanged")
    public void setData2(List<MyPOJO> list) {
        if (myPOJOS.size() > 0)
            myPOJOS.clear();
        myPOJOS.addAll(list);
        notifyDataSetChanged();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        private final TextView tvText;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvText = itemView.findViewById(R.id.tvText);
        }

        public void bind(String data) {
            if (tvText != null && data != null)
                tvText.setText(data);
        }

        public void bind(MyPOJO data) {
            if (tvText != null && data != null)
                tvText.setText(data.getText());
        }
    }
}
