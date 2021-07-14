package com.example.periodictable1;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.SearchView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    MediaPlayer my_song;



    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        hideNavigationBar();

        my_song = MediaPlayer.create(MainActivity.this, R.raw.audio);
        my_song.setLooping(true);
        my_song.start();

        AudioManager audioManager = (AudioManager) getApplicationContext().getSystemService(this.AUDIO_SERVICE);

        Button buttonHydrogen = findViewById(R.id.button_hydrogen);
        buttonHydrogen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toHydrogen();
            }
        });

        Button buttonHelium = findViewById(R.id.button_helium);
        buttonHelium.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toHelium();
            }
        });

        Button buttonLithium = findViewById(R.id.button_Lithium);
        buttonLithium.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toLithium();
            }
        });

        ImageButton buttonMute = findViewById(R.id.imageButton_mute);
        buttonMute.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                audioManager.adjustVolume(AudioManager.ADJUST_TOGGLE_MUTE, AudioManager.FLAG_PLAY_SOUND);


                int icon;

                if (muted) {
                    muted = false;
                    icon = R.drawable.ic_mute;
                }
                else{
                    muted = true;
                    icon = R.drawable.ic_unmute;
                }
                buttonMute.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), icon));
            }
        });

        

    }

    private void toHydrogen(){
        Intent intent = new Intent(MainActivity.this , Hydrogen.class );
        startActivity(intent);
    }

    private void toHelium(){
        Intent intent = new Intent(MainActivity.this , Helium.class );
        startActivity(intent);
    }

    private void toLithium(){
        Intent intent = new Intent(MainActivity.this , Lithium.class );
        startActivity(intent);
    }

    private boolean muted = false;

    private void hideNavigationBar() {
        this.getWindow().getDecorView().setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_FULLSCREEN |
                View.SYSTEM_UI_FLAG_HIDE_NAVIGATION|
                View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY|
                View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN|
                View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION|
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE);

    }

    protected void onStop(){
        super.onStop();
        //your code for stopping the sound
    }


}

