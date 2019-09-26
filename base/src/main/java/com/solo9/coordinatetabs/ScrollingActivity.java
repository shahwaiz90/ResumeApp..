package com.solo9.coordinatetabs;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Build;
import android.os.Bundle;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.tabs.TabLayout;
import com.rhexgomez.typer.roboto.TyperRoboto;
import com.solo9.coordinatetabs.base.R;
import com.squareup.picasso.Picasso;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import android.os.Handler;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.BulletSpan;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import java.util.Objects;
public class ScrollingActivity extends AppCompatActivity {
    TabLayout tabLayout;
    @RequiresApi(api = Build.VERSION_CODES.P)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scrolling);
        tabLayout                          = findViewById(R.id.tabs);
        Toolbar toolbar                    = findViewById(R.id.toolbar);
        ViewPager mViewPager               = findViewById(R.id.viewpager);
        ImageView profileImage             = findViewById(R.id.profile);
        ViewPagerAdapter mViewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        toolbar.setTitle(R.string.user_name);
        setSupportActionBar(toolbar);
        CollapsingToolbarLayout collapsingToolbarLayout = findViewById(R.id.toolbar_layout);
        collapsingToolbarLayout.setExpandedTitleColor(Color.parseColor("#00FFFFFF"));
        collapsingToolbarLayout.setCollapsedTitleTypeface(TyperRoboto.ROBOTO_REGULAR());
        collapsingToolbarLayout.setExpandedTitleTypeface(TyperRoboto.ROBOTO_REGULAR());
        Picasso.get().load(R.mipmap.profile).into(profileImage);
        mViewPagerAdapter.addFragment(BlankFragment.newInstance(), "About");
        mViewPagerAdapter.addFragment(BlankFragment2.newInstance(), "Education");
        mViewPagerAdapter.addFragment(BlankFragment3.newInstance(), "Experience");
        mViewPager.setAdapter(mViewPagerAdapter);
        tabLayout.setupWithViewPager(mViewPager);
        setupTabIcons();



    }



    private void setupTabIcons() {
       final int[] tabIcons = {
                R.drawable.ic_person_black_24dp,
                R.mipmap.education,
                R.mipmap.tool
        };
        Objects.requireNonNull(tabLayout.getTabAt(0)).setIcon(tabIcons[0]);
        Objects.requireNonNull(tabLayout.getTabAt(1)).setIcon(tabIcons[1]);
        Objects.requireNonNull(tabLayout.getTabAt(2)).setIcon(tabIcons[2]);

        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                if(tab.getPosition() == 0) {
                    Objects.requireNonNull(tab.getIcon()).setColorFilter(Color.parseColor("#2B2B2B"), PorterDuff.Mode.SRC_IN); }
                if(tab.getPosition() == 1){
                    Objects.requireNonNull(tab.getIcon()).setColorFilter(Color.parseColor("#2B2B2B"), PorterDuff.Mode.SRC_IN); }
                if(tab.getPosition() == 2){
                    Objects.requireNonNull(tab.getIcon()).setColorFilter(Color.parseColor("#2B2B2B"), PorterDuff.Mode.SRC_IN); }
            }
            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                    Objects.requireNonNull(tab.getIcon()).setColorFilter(Color.parseColor("#0A6CEB"), PorterDuff.Mode.SRC_IN);
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