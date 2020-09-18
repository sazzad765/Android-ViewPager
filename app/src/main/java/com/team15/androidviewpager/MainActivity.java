package com.team15.androidviewpager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.TextView;

import com.google.android.material.tabs.TabLayout;
import com.team15.androidviewpager.adapter.PagerAdapter;

public class MainActivity extends AppCompatActivity {
    //sazzad765

    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private int[] tabIcons = {
            R.drawable.ic_baseline_home_24,
            R.drawable.ic_baseline_work_24,
            R.drawable.ic_baseline_watch_later_24,
    };
    private String[] tabTitles = {
            "Home", "Work", "Watch"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewPager = findViewById(R.id.pager);
        setupViewPager(viewPager);

        tabLayout = findViewById(R.id.tab_layout);
        tabLayout.setupWithViewPager(viewPager);
        setupTabIcons();
    }

    private void setupTabIcons() {
        for (int i = 0; i < tabIcons.length; i++) {
            TextView tabOne = (TextView) LayoutInflater.from(this).inflate(R.layout.custom_tab, null);
            tabOne.setText(tabTitles[i]);
            tabOne.setCompoundDrawablesWithIntrinsicBounds(0, tabIcons[i], 0, 0);
            tabLayout.getTabAt(i).setCustomView(tabOne);
        }
    }

    private void setupViewPager(ViewPager viewPager) {
        PagerAdapter adapter = new PagerAdapter(getSupportFragmentManager());
        adapter.addFrag(new HomeFragment());
        adapter.addFrag(new WorkFragment());
        adapter.addFrag(new WatchLaterFragment());
        viewPager.setAdapter(adapter);
    }
}
