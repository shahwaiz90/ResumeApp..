package com.solo9.coordinatetabs;

import android.app.Activity;
import android.content.Context;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;



import java.util.List;

class DemoAdapter extends RecyclerView.Adapter {

    List<DemoItem> demoItems;
    Context context;

    public DemoAdapter(List<DemoItem> demoItems, Context context) {
        this.demoItems = demoItems;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {


        LayoutInflater inflater = LayoutInflater.from(context);


          View row = inflater.inflate(R.layout.education, parent, false);

        return
                new DemoItemHolder(row);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        DemoItem currentDemoItem = demoItems.get(position);

  //      demoItemHolder.Description.setText(currentDemoItem.Description);
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((Activity) context).getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);

    }

    @Override
    public int getItemCount() {
        return demoItems.size();
    }


    public class DemoItemHolder extends RecyclerView.ViewHolder {

        TextView Title, Description;

        public DemoItemHolder(View itemView) {
            super(itemView);

        //Title=itemView.findViewById(R.id.info1) ;
          //  Description = itemView.findViewById(R.id.textViewDes);
        }
    }

}
