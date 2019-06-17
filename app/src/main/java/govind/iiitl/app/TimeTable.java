package govind.iiitl.app;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import govind.iiitl.app.Adapter.PagerViewAdapter;

public class TimeTable extends AppCompatActivity {
    ViewPager viewPager;
    TextView Mon,Tue,Wed,Thu,Fri;

    PagerViewAdapter pagerViewAdapter;

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


        pagerViewAdapter = new PagerViewAdapter(getSupportFragmentManager());

        viewPager.setAdapter(pagerViewAdapter);

        Mon.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                viewPager.setCurrentItem(0);
            }
        });
        Tue.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                viewPager.setCurrentItem(0);
            }
        });
        Wed.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                viewPager.setCurrentItem(0);
            }
        });
        Thu.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                viewPager.setCurrentItem(0);
            }
        });
        Fri.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                viewPager.setCurrentItem(0);
            }
        });


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
                    Mon.setTextSize(28);
                    Mon.getResources().getColor(R.color.bright);
                    Tue.setTextSize(20);
                    Tue.getResources().getColor(R.color.light_color);
                    Wed.setTextSize(20);
                    Wed.getResources().getColor(R.color.light_color);
                    Thu.setTextSize(20);
                    Thu.getResources().getColor(R.color.light_color);
                    Fri.setTextSize(20);
                    Fri.getResources().getColor(R.color.light_color);
                }
                if(position==1)
                {
                    Mon.setTextSize(20);
                    Mon.getResources().getColor(R.color.light_color);
                    Tue.setTextSize(28);
                    Tue.getResources().getColor(R.color.bright);
                    Wed.setTextSize(20);
                    Wed.getResources().getColor(R.color.light_color);
                    Thu.setTextSize(20);
                    Thu.getResources().getColor(R.color.light_color);
                    Fri.setTextSize(20);
                    Fri.getResources().getColor(R.color.light_color);
                }
                if(position==2)
                {
                    Mon.setTextSize(20);
                    Mon.getResources().getColor(R.color.light_color);
                    Tue.setTextSize(20);
                    Tue.getResources().getColor(R.color.light_color);
                    Wed.setTextSize(28);
                    Wed.getResources().getColor(R.color.bright);
                    Thu.setTextSize(20);
                    Thu.getResources().getColor(R.color.light_color);
                    Fri.setTextSize(20);
                    Fri.getResources().getColor(R.color.light_color);
                }
                if(position==3)
                {
                    Mon.setTextSize(20);
                    Mon.getResources().getColor(R.color.light_color);
                    Tue.setTextSize(20);
                    Tue.getResources().getColor(R.color.light_color);
                    Wed.setTextSize(20);
                    Wed.getResources().getColor(R.color.light_color);
                    Thu.setTextSize(28);
                    Thu.getResources().getColor(R.color.bright);
                    Fri.setTextSize(20);
                    Fri.getResources().getColor(R.color.light_color);
                }
                if(position==4)
                {
                    Mon.setTextSize(20);
                    Mon.getResources().getColor(R.color.light_color);
                    Tue.setTextSize(20);
                    Tue.getResources().getColor(R.color.light_color);
                    Wed.setTextSize(20);
                    Wed.getResources().getColor(R.color.light_color);
                    Thu.setTextSize(20);
                    Thu.getResources().getColor(R.color.light_color);
                    Fri.setTextSize(28);
                    Fri.getResources().getColor(R.color.bright);
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }
}
