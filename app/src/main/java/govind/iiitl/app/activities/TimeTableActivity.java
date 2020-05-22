package govind.iiitl.app.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import govind.iiitl.app.R;
import govind.iiitl.app.adapter.PagerViewAdapter;

public class TimeTableActivity extends AppCompatActivity {
    ViewPager viewPager;
    TextView Mon,Tue,Wed,Thu,Fri;


    PagerViewAdapter pagerViewAdapter;
    String s = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time_table);
        viewPager=findViewById(R.id.fragmentContainer);
        Mon = findViewById(R.id.Mon);
        Tue = findViewById(R.id.Tue);
        Wed = findViewById(R.id.Wed);
        Thu = findViewById(R.id.Thu);
        Fri = findViewById(R.id.Fri);

        Intent intent = getIntent();
        s = intent.getStringExtra("cs2sem.json");
        pagerViewAdapter = new PagerViewAdapter(getSupportFragmentManager());

        viewPager.setAdapter(pagerViewAdapter);

        Mon.setOnClickListener( (View view) -> viewPager.setCurrentItem(0));
        Tue.setOnClickListener( (View view) -> viewPager.setCurrentItem(1));
        Wed.setOnClickListener( (View view) -> viewPager.setCurrentItem(2));
        Thu.setOnClickListener( (View view) -> viewPager.setCurrentItem(3));
        Fri.setOnClickListener( (View view) -> viewPager.setCurrentItem(4));


        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                onChangeTab(position);

            }

            private void onChangeTab(int position) {
                if(position==0)
                {
                    Mon.setTextSize(32);
                    Mon.setTextColor(getResources().getColor(R.color.colorAccent));
                    Tue.setTextSize(25);
                    Tue.setTextColor(getResources().getColor(R.color.white));
                    Wed.setTextSize(25);
                    Wed.setTextColor(getResources().getColor(R.color.white));
                    Thu.setTextSize(25);
                    Thu.setTextColor(getResources().getColor(R.color.white));
                    Fri.setTextSize(25);
                    Fri.setTextColor(getResources().getColor(R.color.white));
                }
                if(position==1)
                {
                    Mon.setTextSize(25);
                    Mon.setTextColor(getResources().getColor(R.color.white));
                    Tue.setTextSize(32);
                    Tue.setTextColor(getResources().getColor(R.color.colorAccent));
                    Wed.setTextSize(25);
                    Wed.setTextColor(getResources().getColor(R.color.white));
                    Thu.setTextSize(25);
                    Thu.setTextColor(getResources().getColor(R.color.white));
                    Fri.setTextSize(25);
                    Fri.setTextColor(getResources().getColor(R.color.white));
                }
                if(position==2)
                {
                    Mon.setTextSize(25);
                    Mon.setTextColor(getResources().getColor(R.color.white));
                    Tue.setTextSize(25);
                    Tue.setTextColor(getResources().getColor(R.color.white));
                    Wed.setTextSize(32);
                    Wed.setTextColor(getResources().getColor(R.color.colorAccent));
                    Thu.setTextSize(25);
                    Thu.setTextColor(getResources().getColor(R.color.white));
                    Fri.setTextSize(25);
                    Fri.setTextColor(getResources().getColor(R.color.white));
                }
                if(position==3)
                {
                    Mon.setTextSize(25);
                    Mon.setTextColor(getResources().getColor(R.color.white));
                    Tue.setTextSize(25);
                    Tue.setTextColor(getResources().getColor(R.color.white));
                    Wed.setTextSize(25);
                    Wed.setTextColor(getResources().getColor(R.color.white));
                    Thu.setTextSize(32);
                    Thu.setTextColor(getResources().getColor(R.color.colorAccent));
                    Fri.setTextSize(25);
                    Fri.setTextColor(getResources().getColor(R.color.white));
                }
                if(position==4)
                {
                    Mon.setTextSize(25);
                    Mon.setTextColor(getResources().getColor(R.color.white));
                    Tue.setTextSize(25);
                    Tue.setTextColor(getResources().getColor(R.color.white));
                    Wed.setTextSize(25);
                    Wed.setTextColor(getResources().getColor(R.color.white));
                    Thu.setTextSize(25);
                    Thu.setTextColor(getResources().getColor(R.color.white));
                    Fri.setTextSize(32);
                    Fri.setTextColor(getResources().getColor(R.color.colorAccent));
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    public String SendData() {
        return s;
    }
}
