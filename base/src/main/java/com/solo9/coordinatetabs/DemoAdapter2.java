package com.solo9.coordinatetabs;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.solo9.coordinatetabs.base.R;
import com.crowdfire.cfalertdialog.CFAlertDialog;


import java.util.List;

class DemoAdapter2 extends RecyclerView.Adapter {

    List<DemoItem> demoItems;
    Context        context;

    public DemoAdapter2(List<DemoItem> demoItems, Context context) {
        this.demoItems = demoItems;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(context);
          View row = inflater.inflate(R.layout.profession, parent, false);

        return new DemoItemHolder2(row);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {


        DemoAdapter2.DemoItemHolder2 demoItemHolder = (DemoAdapter2.DemoItemHolder2) holder;
    /*    demoItemHolder.textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CFAlertDialog.Builder builder = new CFAlertDialog.Builder(context)
                        .setDialogStyle(CFAlertDialog.CFAlertStyle.ALERT)
                        .setTitle("You've hit the limit")
                        .setMessage("Looks like you've hit your usage limit. Upgrade to our paid plan to continue without any limits.")
                        .addButton("UPGRADE", -1, -1, CFAlertDialog.CFAlertActionStyle.POSITIVE, CFAlertDialog.CFAlertActionAlignment.END, (dialog, which) -> {
                            // Toast.makeText(DemoAdapter2.this, "Upgrade tapped", Toast.LENGTH_SHORT).show();
                            dialog.dismiss();
                        });

// Show the alert
                builder.show();
            }
        });


        demoItemHolder.textView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               CFAlertDialog.Builder builder = new CFAlertDialog.Builder(context)
                        .setDialogStyle(CFAlertDialog.CFAlertStyle.ALERT)
                        .setTitle("You've hit the limit")
                        .setMessage("Looks like you've hit your usage limit. Upgrade to our paid plan to continue without any limits.")
                        .addButton("UPGRADE", -1, -1, CFAlertDialog.CFAlertActionStyle.POSITIVE, CFAlertDialog.CFAlertActionAlignment.END, (dialog, which) -> {
                            // Toast.makeText(DemoAdapter2.this, "Upgrade tapped", Toast.LENGTH_SHORT).show();
                            dialog.dismiss();
                        });
                builder.show();
            }
        });

        demoItemHolder.textView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CFAlertDialog.Builder builder = new CFAlertDialog.Builder(context)
                        .setDialogStyle(CFAlertDialog.CFAlertStyle.ALERT)
                        .setTitle("You've hit the limit")
                        .setMessage("Looks like you've hit your usage limit. Upgrade to our paid plan to continue without any limits.")
                        .addButton("UPGRADE", -1, -1, CFAlertDialog.CFAlertActionStyle.POSITIVE, CFAlertDialog.CFAlertActionAlignment.END, (dialog, which) -> {
                            // Toast.makeText(DemoAdapter2.this, "Upgrade tapped", Toast.LENGTH_SHORT).show();
                            dialog.dismiss();
                        });

                builder.show();
            }
        });

        demoItemHolder.textView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CFAlertDialog.Builder builder = new CFAlertDialog.Builder(context)
                        .setDialogStyle(CFAlertDialog.CFAlertStyle.ALERT)
                        .setTitle("You've hit the limit")
                        .setMessage("Looks like you've hit your usage limit. Upgrade to our paid plan to continue without any limits.")
                        .addButton("UPGRADE", -1, -1, CFAlertDialog.CFAlertActionStyle.POSITIVE, CFAlertDialog.CFAlertActionAlignment.END, (dialog, which) -> {
                          // Toast.makeText(DemoAdapter2.this, "Upgrade tapped", Toast.LENGTH_SHORT).show();
                            dialog.dismiss();
                        });

// Show the alert
                builder.show();
            }
        });

        demoItemHolder.textView4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                CFAlertDialog.Builder builder = new CFAlertDialog.Builder(context)
                        .setDialogStyle(CFAlertDialog.CFAlertStyle.ALERT)
                        .setTitle("You've hit the limit")
                        .setMessage("Looks like you've hit your usage limit. Upgrade to our paid plan to continue without any limits.")
                        .addButton("UPGRADE", -1, -1, CFAlertDialog.CFAlertActionStyle.POSITIVE, CFAlertDialog.CFAlertActionAlignment.END, (dialog, which) -> {
                            // Toast.makeText(DemoAdapter2.this, "Upgrade tapped", Toast.LENGTH_SHORT).show();
                            dialog.dismiss();
                        });

// Show the alert
                builder.show();

                       }
        });
        */
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((Activity) context).getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
    }

    @Override
    public int getItemCount() {
        return demoItems.size();
    }
    public class DemoItemHolder2 extends RecyclerView.ViewHolder {
     ImageView textView ,textView1, textView2, textView3, textView4;


        public DemoItemHolder2(View itemView) {
            super(itemView);
/*
            textView =itemView.findViewById(R.id.info1);
            textView1 =itemView.findViewById(R.id.info2);
            textView2 =itemView.findViewById(R.id.info3);
            textView3 =itemView.findViewById(R.id.info4);
            textView4=itemView.findViewById(R.id.info5);
*/
        }
    }

}
