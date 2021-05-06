package com.info.animasyonlufab;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {

    private FloatingActionButton fabMain, fabBirinci, fabIKinci;
    private Animation ileridon, geridon, fabacik, fabkapali;
    private Boolean fabDurum = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fabMain = findViewById(R.id.fabMain);
        fabBirinci = findViewById(R.id.fabBirinci);
        fabIKinci = findViewById(R.id.fabIkinci);

        ileridon = AnimationUtils.loadAnimation(this, R.anim.ileridon);
        geridon = AnimationUtils.loadAnimation(this, R.anim.geridon);
        fabacik = AnimationUtils.loadAnimation(this, R.anim.fabacik);
        fabkapali = AnimationUtils.loadAnimation(this, R.anim.fabkapali);

        fabMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (fabDurum){
                    fabMain.startAnimation(geridon);
                    fabBirinci.startAnimation(fabkapali);
                    fabIKinci.startAnimation(fabkapali);
                    fabBirinci.setClickable(false);
                    fabIKinci.setClickable(false);
                    fabDurum = false;
                }else {
                    fabMain.startAnimation(ileridon);
                    fabBirinci.startAnimation(fabacik);
                    fabIKinci.startAnimation(fabacik);
                    fabBirinci.setClickable(true);
                    fabIKinci.setClickable(true );
                    fabDurum = true;
                }
            }
        });
    }
}