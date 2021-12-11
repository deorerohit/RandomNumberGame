package com.example.randonnumbergame;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class OnBoarding extends AppCompatActivity {

    TextView tv;
    SliderAdapter sliderAdapter;
    ViewPager2 viewPager2;
    TabLayout tabLayout;
    Button nextbtn;
    int currentPosition;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.on_boarding);

        viewPager2 = findViewById(R.id.viewPager);
        tabLayout = findViewById(R.id.tablayout);
        nextbtn = findViewById(R.id.on_boarding_btn);


        sliderAdapter = new SliderAdapter(this);
        viewPager2.setAdapter(sliderAdapter);

        viewPager2.registerOnPageChangeCallback(pageChangeCallback);


        TabLayoutMediator tab = new TabLayoutMediator(tabLayout, viewPager2, true, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {


            }
        });
        tab.attach();
    }

    public void nextBtn(View view){

        if(currentPosition == 3){
            startActivity(new Intent(OnBoarding.this, ChooseLevel.class));
            finish();
        }
        else{
            viewPager2.setCurrentItem(currentPosition + 1);
        }
    }

    ViewPager2.OnPageChangeCallback pageChangeCallback = new ViewPager2.OnPageChangeCallback() {

        @Override
        public void onPageSelected(int position) {

            currentPosition = position;


            if (position == 0) {
                nextbtn.setText(R.string.n);
            } else if (position == 1) {
                nextbtn.setText("Next");
            } else if (position == 2) {
                nextbtn.setText("Next");
            } else {
                nextbtn.setText("Let's Begin");
            }

        }


    };

}