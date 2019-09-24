package com.solo9.coordinatetabs;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.ClipData;
import android.content.ComponentName;
import com.solo9.coordinatetabs.base.R;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Build;
import android.text.ClipboardManager;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

import static android.content.Context.CLIPBOARD_SERVICE;
import static androidx.core.content.ContextCompat.startActivity;

class DemoAdapter1 extends RecyclerView.Adapter {

    List<DemoItem> demoItems;
    Context context;

    public DemoAdapter1(List<DemoItem> demoItems, Context context) {
        this.demoItems = demoItems;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View row = inflater.inflate(R.layout.about, parent, false);

        return new DemoItemHolder1(row);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {


        DemoAdapter1.DemoItemHolder1 demoItemHolder = (DemoAdapter1.DemoItemHolder1) holder;

        Picasso.get().load(R.drawable.envelope).into(demoItemHolder.emailIcon);
        Picasso.get().load(R.drawable.placeholder).into(demoItemHolder.addressIcon);
        Picasso.get().load(R.drawable.smartphone).into(demoItemHolder.phoneIcon);
        Picasso.get().load(R.drawable.linkedin).into(demoItemHolder.linkedinIcon);
        Picasso.get().load(R.drawable.twitter).into(demoItemHolder.twitterIcon);
        Picasso.get().load(R.drawable.github).into(demoItemHolder.githubIcon);
        Picasso.get().load(R.drawable.stackoverflow).into(demoItemHolder.stackOverFlowIcon);


       demoItemHolder.email.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {

               Intent intent=new Intent(Intent.ACTION_SEND);
               String[] recipients={context.getString(R.string.email)};
               intent.putExtra(Intent.EXTRA_EMAIL, recipients);
               intent.setType("text/html");
               intent.setPackage("com.google.android.gm");
               context.startActivity(Intent.createChooser(intent, "Send mail"));
           }
       });




        demoItemHolder.address.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://maps.google.com/maps?f=d&daddr="+context.getString(R.string.Address)));
               intent.setComponent(new ComponentName("com.google.android.apps.maps", "com.google.android.maps.MapsActivity"));
               context.startActivity(intent);
           }
       });

        demoItemHolder.phone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri u = Uri.parse("tel:" +context.getString(R.string.phoneNumber));
                Intent i = new Intent(Intent.ACTION_DIAL, u);
                try
                {
                    // Launch the Phone app's dialer with a phone
                    // number to dial a call.
                    context.startActivity(i);
                }
                catch (SecurityException s)
                {
                    // show() method display the toast with
                    // exception message.
                    Toast.makeText(context ,"issue check the code", Toast.LENGTH_LONG)
                            .show();
                }
            }
        });
        demoItemHolder.linkedin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("linkedin://add/%@" + context.getString(R.string.Linkedin_IdLink)));
                final PackageManager packageManager = context.getPackageManager();
                final List<ResolveInfo> list = packageManager.queryIntentActivities(intent, PackageManager.MATCH_DEFAULT_ONLY);
                if (list.isEmpty()) {
                    intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.linkedin.com/profile/view?id=" + (R.string.Linkedin_IdLink)));
                }
                context.startActivity(intent);
            }

        });
        demoItemHolder.twitter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Intent intent = null;
                try {
                    // get the Twitter app if possible
                    context.getPackageManager().getPackageInfo("com.twitter.android", 0);
                    intent = new Intent(Intent.ACTION_VIEW, Uri.parse("twitter://user?user_id=gulraiz_asmat"));
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                } catch (Exception e) {
                    // no Twitter app, revert to browser
                    intent = new Intent(Intent.ACTION_VIEW, Uri.parse(context.getString(R.string.Twitter_IdLink)));
                }
                context.startActivity(intent);

            }

        });

        demoItemHolder.github.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent  intent = new Intent(Intent.ACTION_VIEW, Uri.parse(context.getString(R.string.Github_IdLink)));

                context.startActivity(intent);
            }

        });

        demoItemHolder.stackOverFlow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               Intent  intent = new Intent(Intent.ACTION_VIEW, Uri.parse(context.getString(R.string.stackOverFlow_IdLink)));
                context.startActivity(intent);
            }

        });

            demoItemHolder.emailLinkCopy.setOnClickListener(new View.OnClickListener() {
            @Override
            @SuppressLint({ "NewApi", "NewApi", "NewApi", "NewApi" })
            @SuppressWarnings("deprecation")
            // User-defined onClick Listener
            @TargetApi(11)
            @RequiresApi(api = Build.VERSION_CODES.M)
            public void onClick(View view) {

                android.content.ClipboardManager clipboard = (android.content.ClipboardManager) context.getSystemService(CLIPBOARD_SERVICE);
                android.content.ClipData clip = ClipData.newPlainText("Text Label", context.getString(R.string.email));
                clipboard.setPrimaryClip(clip);
                Toast.makeText(context, "Copied to Clipboard!", Toast.LENGTH_SHORT).show();
            }
        });

        demoItemHolder.addressLinkCopy.setOnClickListener(new View.OnClickListener() {
            @Override
            @SuppressLint({ "NewApi", "NewApi", "NewApi", "NewApi" })
            @SuppressWarnings("deprecation")
            // User-defined onClick Listener
            @TargetApi(11)
            @RequiresApi(api = Build.VERSION_CODES.M)
            public void onClick(View view) {

                android.content.ClipboardManager clipboard = (android.content.ClipboardManager) context.getSystemService(CLIPBOARD_SERVICE);
                android.content.ClipData clip = ClipData.newPlainText("Text Label", context.getString(R.string.Address));
                clipboard.setPrimaryClip(clip);
                Toast.makeText(context, "Copied to Clipboard!", Toast.LENGTH_SHORT).show();
            }
        });

        demoItemHolder.phoneLinkCopy.setOnClickListener(new View.OnClickListener() {
            @Override
            @SuppressLint({ "NewApi", "NewApi", "NewApi", "NewApi" })
            @SuppressWarnings("deprecation")
            // User-defined onClick Listener
            @TargetApi(11)
            @RequiresApi(api = Build.VERSION_CODES.M)
            public void onClick(View view) {

                android.content.ClipboardManager clipboard = (android.content.ClipboardManager) context.getSystemService(CLIPBOARD_SERVICE);
                android.content.ClipData clip = ClipData.newPlainText("Text Label", context.getString(R.string.phoneNumber));
                clipboard.setPrimaryClip(clip);
                Toast.makeText(context, "Copied to Clipboard!", Toast.LENGTH_SHORT).show();
            }
        });

        demoItemHolder.phoneLinkCopy.setOnClickListener(new View.OnClickListener() {
            @Override
            @SuppressLint({ "NewApi", "NewApi", "NewApi", "NewApi" })
            @SuppressWarnings("deprecation")
            // User-defined onClick Listener
            @TargetApi(11)
            @RequiresApi(api = Build.VERSION_CODES.M)
            public void onClick(View view) {

                android.content.ClipboardManager clipboard = (android.content.ClipboardManager) context.getSystemService(CLIPBOARD_SERVICE);
                android.content.ClipData clip = ClipData.newPlainText("Text Label", context.getString(R.string.phoneNumber));
                clipboard.setPrimaryClip(clip);
                Toast.makeText(context, "Copied to Clipboard!", Toast.LENGTH_SHORT).show();
            }
        });

        demoItemHolder.phoneCallIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri u = Uri.parse("tel:" +context.getString(R.string.phoneNumber));
                Intent i = new Intent(Intent.ACTION_DIAL, u);
                try
                {
                    // Launch the Phone app's dialer with a phone
                    // number to dial a call.
                    context.startActivity(i);
                }
                catch (SecurityException s)
                {
                    // show() method display the toast with
                    // exception message.
                    Toast.makeText(context ,"issue check the code", Toast.LENGTH_LONG)
                            .show();
                }
            }
        });

        demoItemHolder.linkedinLinkCopy.setOnClickListener(new View.OnClickListener() {
            @Override
            @SuppressLint({ "NewApi", "NewApi", "NewApi", "NewApi" })
            @SuppressWarnings("deprecation")
            // User-defined onClick Listener
            @TargetApi(11)
            @RequiresApi(api = Build.VERSION_CODES.M)
            public void onClick(View view) {

                android.content.ClipboardManager clipboard = (android.content.ClipboardManager) context.getSystemService(CLIPBOARD_SERVICE);
                android.content.ClipData clip = ClipData.newPlainText("Text Label", context.getString(R.string.Linkedin_UserName));
                clipboard.setPrimaryClip(clip);
                Toast.makeText(context, "Copied to Clipboard!", Toast.LENGTH_SHORT).show();
            }
        });
        demoItemHolder.twitterLinkCopy.setOnClickListener(new View.OnClickListener() {
            @Override
            @SuppressLint({ "NewApi", "NewApi", "NewApi", "NewApi" })
            @SuppressWarnings("deprecation")
            // User-defined onClick Listener
            @TargetApi(11)
            @RequiresApi(api = Build.VERSION_CODES.M)
            public void onClick(View view) {

                android.content.ClipboardManager clipboard = (android.content.ClipboardManager) context.getSystemService(CLIPBOARD_SERVICE);
                android.content.ClipData clip = ClipData.newPlainText("Text Label", context.getString(R.string.Twitter_userName));
                clipboard.setPrimaryClip(clip);
                Toast.makeText(context, "Copied to Clipboard!", Toast.LENGTH_SHORT).show();
            }
        });
        demoItemHolder.githubLinkCopy.setOnClickListener(new View.OnClickListener() {
            @Override
            @SuppressLint({ "NewApi", "NewApi", "NewApi", "NewApi" })
            @SuppressWarnings("deprecation")
            // User-defined onClick Listener
            @TargetApi(11)
            @RequiresApi(api = Build.VERSION_CODES.M)
            public void onClick(View view) {

                android.content.ClipboardManager clipboard = (android.content.ClipboardManager) context.getSystemService(CLIPBOARD_SERVICE);
                android.content.ClipData clip = ClipData.newPlainText("Text Label", context.getString(R.string.Github_UserName));
                clipboard.setPrimaryClip(clip);
                Toast.makeText(context, "Copied to Clipboard!", Toast.LENGTH_SHORT).show();
            }
        });
        demoItemHolder.stackoverflowLinkCopy.setOnClickListener(new View.OnClickListener() {
            @Override
            @SuppressLint({ "NewApi", "NewApi", "NewApi", "NewApi" })
            @SuppressWarnings("deprecation")
            // User-defined onClick Listener
            @TargetApi(11)
            @RequiresApi(api = Build.VERSION_CODES.M)
            public void onClick(View view) {

                android.content.ClipboardManager clipboard = (android.content.ClipboardManager) context.getSystemService(CLIPBOARD_SERVICE);
                android.content.ClipData clip = ClipData.newPlainText("Text Label", context.getString(R.string.StackOverFlow_UserName));
                clipboard.setPrimaryClip(clip);
                Toast.makeText(context, "Copied to Clipboard!", Toast.LENGTH_SHORT).show();
            }
        });

        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((Activity) context).getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
    }








    @Override
    public int getItemCount() {
        return demoItems.size();
    }


    public class DemoItemHolder1 extends RecyclerView.ViewHolder {
        TextView email,address,phone,linkedin,twitter,github,stackOverFlow;
        ImageView emailIcon,addressIcon,phoneIcon,linkedinIcon,twitterIcon,githubIcon,stackOverFlowIcon, phoneCallIcon;
        ImageView emailLinkCopy,addressLinkCopy,phoneLinkCopy,linkedinLinkCopy,twitterLinkCopy,githubLinkCopy,stackoverflowLinkCopy;

        public DemoItemHolder1(View itemView) {
            super(itemView);
            /*--------------------TextView------------------*/
            email=itemView.findViewById(R.id.email);
            address=itemView.findViewById(R.id.address);
            phone=itemView.findViewById(R.id.phone);
            linkedin=itemView.findViewById(R.id.linkedin);
            twitter=itemView.findViewById(R.id.twitter);
            github=itemView.findViewById(R.id.github);
            stackOverFlow=itemView.findViewById(R.id.stackOverFlow);

            /*--------------------Icons------------------*/
            emailIcon=itemView.findViewById(R.id.emailIcon);
            addressIcon=itemView.findViewById(R.id.addressIcon);
            phoneIcon=itemView.findViewById(R.id.phoneIcon);
            linkedinIcon=itemView.findViewById(R.id.linkedinIcon);
            twitterIcon=itemView.findViewById(R.id.twitterIcon);
            githubIcon=itemView.findViewById(R.id.githubIcon);
            stackOverFlowIcon=itemView.findViewById(R.id.stackOverFlowIcon);

            /*--------------------Links------------------*/
            emailLinkCopy=itemView.findViewById(R.id.emaailCopyLink);
            addressLinkCopy=itemView.findViewById(R.id.addressCopyLink);
            phoneLinkCopy=itemView.findViewById(R.id.phoneCopyLink);
            linkedinLinkCopy=itemView.findViewById(R.id.linkedinCopyLink);
            twitterLinkCopy =itemView.findViewById(R.id.twitterCopyLink);
            githubLinkCopy=itemView.findViewById(R.id.githubCopyLink);
            stackoverflowLinkCopy=itemView.findViewById(R.id.stackOverFlowCopyLink);
            phoneCallIcon=itemView.findViewById(R.id.phoneCallLink);


        }
    }

}
