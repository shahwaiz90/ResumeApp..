package com.solo9.coordinatetabs;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.ActionBar;
import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;

import com.crowdfire.cfalertdialog.CFAlertDialog;

import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.tabs.TabLayout;

import com.rhexgomez.typer.roboto.TyperRoboto;
import com.squareup.picasso.Picasso;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.text.ClipboardManager;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.io.File;
import java.io.IOException;



public class ScrollingActivity extends AppCompatActivity {
    TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scrolling);
        Toolbar toolbar = findViewById(R.id.toolbar);
        //RecyclerView mRecyclerView = findViewById(R.id.recycler_view);
        TextView userName = findViewById(R.id.userName);
        tabLayout = findViewById(R.id.tabs);
        ViewPager mViewPager = findViewById(R.id.viewpager);
        ImageView profileImage = findViewById(R.id.profile);
        toolbar.setTitle(R.string.user_name);
        setSupportActionBar(toolbar);
        CollapsingToolbarLayout collapsingToolbarLayout = findViewById(R.id.toolbar_layout);
        collapsingToolbarLayout.setExpandedTitleColor(Color.parseColor("#00FFFFFF"));
        collapsingToolbarLayout.setCollapsedTitleTypeface(TyperRoboto.ROBOTO_REGULAR());
        collapsingToolbarLayout.setExpandedTitleTypeface(TyperRoboto.ROBOTO_REGULAR());
        int width = getWindowManager().getDefaultDisplay().getWidth();
        int height = getWindowManager().getDefaultDisplay().getHeight();
        Log.e("width", String.valueOf(width));
        Log.e("height", String.valueOf(height));

        Picasso.get().load(R.drawable.profile).into(profileImage);
        // Picasso.get().load(R.drawable.cover1).into(coverImage);
        ViewPagerAdapter mViewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        mViewPagerAdapter.addFragment(BlankFragment.newInstance(), "About");
        mViewPagerAdapter.addFragment(BlankFragment2.newInstance(), "Education");
        mViewPagerAdapter.addFragment(BlankFragment3.newInstance(), "Profession");
        mViewPager.setAdapter(mViewPagerAdapter);
        tabLayout.setupWithViewPager(mViewPager);


        userName.setOnLongClickListener(new View.OnLongClickListener() {

            @SuppressLint({"NewApi", "NewApi", "NewApi", "NewApi"})
            @SuppressWarnings("deprecation")
            // User-defined onClick Listener
            @TargetApi(11)
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public boolean onLongClick(View arg0) {


                int sdk_Version = android.os.Build.VERSION.SDK_INT;
                if (sdk_Version < android.os.Build.VERSION_CODES.HONEYCOMB) {
                    android.text.ClipboardManager clipboard = (android.text.ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
                    clipboard.setText(getString(R.string.email));   // Assuming that you are copying the text from a TextView
                    Toast.makeText(getApplicationContext(), "Copied to Clipboard!", Toast.LENGTH_SHORT).show();
                } else {
                    android.content.ClipboardManager clipboard = (android.content.ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
                    android.content.ClipData clip = (ClipData) ClipData.newPlainText("Text Label", getString(R.string.email));
                    clipboard.setPrimaryClip(clip);
                    Toast.makeText(getApplicationContext(), "Copied to Clipboard!", Toast.LENGTH_SHORT).show();
                }
                return false;
            }

        });


        setupTabIcons();
        // ATTENTION: This was auto-generated to handle app links.
       
    }

    private void setupTabIcons() {

       final int[] tabIcons = {
                R.drawable.ic_person_black_24dp,
                R.drawable.education,
                R.drawable.tool
        };

        tabLayout.getTabAt(0).setIcon(tabIcons[0]);
        tabLayout.getTabAt(1).setIcon(tabIcons[1]);
        tabLayout.getTabAt(2).setIcon(tabIcons[2]);


        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {

                if(tab.getPosition() == 0) {

                    tab.getIcon().setColorFilter(Color.parseColor("#2B2B2B"), PorterDuff.Mode.SRC_IN);

                }
                if(tab.getPosition() == 1){

                    tab.getIcon().setColorFilter(Color.parseColor("#2B2B2B"), PorterDuff.Mode.SRC_IN);

                }
                if(tab.getPosition() == 2){

                    tab.getIcon().setColorFilter(Color.parseColor("#2B2B2B"), PorterDuff.Mode.SRC_IN);


                }
            }


            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

                    tab.getIcon().setColorFilter(Color.parseColor("#0A6CEB"), PorterDuff.Mode.SRC_IN);




            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });



    }





        @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.

        getMenuInflater().inflate(R.menu.menu_scrolling, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {

            Intent i=new Intent(android.content.Intent.ACTION_SEND);
            i.setType("text/plain");
            i.putExtra(android.content.Intent.EXTRA_SUBJECT,"Subject test");
            i.putExtra(android.content.Intent.EXTRA_TEXT, "extra text that you want to put");
            startActivity(Intent.createChooser(i,"Share via"));

            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
