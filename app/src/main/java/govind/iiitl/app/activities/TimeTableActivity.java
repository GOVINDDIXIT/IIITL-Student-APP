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
                Mon.setTextSize(20);
                Mon.getResources().getColor(R.color.light_color);
                Tue.setTextSize(20);
                Tue.getResources().getColor(R.color.light_color);
                Wed.setTextSize(20);
                Wed.getResources().getColor(R.color.light_color);
                Thu.setTextSize(20);
                Thu.getResources().getColor(R.color.light_color);
                Fri.setTextSize(20);
                Fri.getResources().getColor(R.color.light_color);

                switch(position){
                    case 0:
                        Mon.setTextSize(28);
                        Mon.getResources().getColor(R.color.bright);
                        break;
                    case 1:
                        Tue.setTextSize(28);
                        Tue.getResources().getColor(R.color.bright);
                        break;
                    case 2:
                        Wed.setTextSize(28);
                        Wed.getResources().getColor(R.color.bright);
                        break;
                    case 3:
                        Thu.setTextSize(28);
                        Thu.getResources().getColor(R.color.bright);
                        break;
                    default:
                        Fri.setTextSize(28);
                        Fri.getResources().getColor(R.color.bright);
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
