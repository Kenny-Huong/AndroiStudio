package com.example.demomediaplayer;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    ImageButton btnImageView, btnAudioView, btnStopAudio, btnPlayAudio;
    MediaPlayer mediaPlayer = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        btnImageView = findViewById(R.id.btnImageView);
        btnAudioView = findViewById(R.id.btnAudioView);
        btnStopAudio = findViewById(R.id.btnStopAudio);
        btnPlayAudio = findViewById(R.id.btnPlayAudio);



        btnImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ViewImageStore();
            }
        });

        btnAudioView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ViewAudioStore();
            }
        });
        
        btnPlayAudio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PlayAudio();
            }
        });
        
        btnStopAudio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                StopAudio();
            }
        });

    }

    private void StopAudio() {
        if(mediaPlayer != null){
            mediaPlayer.stop();
        }
    }

    private void PlayAudio() {
        try {
            mediaPlayer = MediaPlayer.create(this, R.raw.neuvianhnhu);
            mediaPlayer.start();
        }catch (Exception e){
            Toast.makeText(this, "Lỗi tải âm thanh", Toast.LENGTH_SHORT).show();
        }
    }

    private void ViewAudioStore() {
        Uri uri = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
        Intent I = new Intent(Intent.ACTION_PICK, uri);
        startActivity(I);
    }

    private void ViewImageStore() {
        Uri uri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
        Intent I = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(I);
    }
}