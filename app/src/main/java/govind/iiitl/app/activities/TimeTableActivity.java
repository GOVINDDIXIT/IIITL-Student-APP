package govind.iiitl.app.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
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
                int white = ContextCompat.getColor(getBaseContext(), R.color.white);
                int accentColor = ContextCompat.getColor(getBaseContext(), R.color.colorAccent);
                Mon.setTextSize(20);
                Mon.setTextColor(white);
                Tue.setTextSize(20);
                Tue.setTextColor(white);
                Wed.setTextSize(20);
                Wed.setTextColor(white);
                Thu.setTextSize(20);
                Thu.setTextColor(white);
                Fri.setTextSize(20);
                Fri.setTextColor(white);

                switch(position){
                    case 0:
                        Mon.setTextSize(28);
                        Mon.setTextColor(accentColor);
                        break;
                    case 1:
                        Tue.setTextSize(28);
                        Tue.setTextColor(accentColor);
                        break;
                    case 2:
                        Wed.setTextSize(28);
                        Wed.setTextColor(accentColor);
                        break;
                    case 3:
                        Thu.setTextSize(28);
                        Thu.setTextColor(accentColor);
                        break;
                    default:
                        Fri.setTextSize(28);
                        Fri.setTextColor(accentColor);
                        break;
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
