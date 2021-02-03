package com.example.activity;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.media.browse.MediaBrowser;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    private EditText eUsernamer;
    private Button btnLogin;
    private Button btnImage;
    private final int CAPTURE_IMAGE = 101;
    private ImageView imageViewimage;
    private Button btnWeb;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        eUsernamer = findViewById(R.id.ed_username);
        btnLogin = findViewById(R.id.btn_login);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String strUsername = eUsernamer.getText().toString();

                Intent intent = new Intent(MainActivity.this,welcome.class);
                intent.putExtra("Username",strUsername);
                startActivity(intent);

            }


        });
        btnImage = findViewById(R.id.btn_image);
        imageViewimage = findViewById(R.id.image);
        btnImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent();
                intent.setAction(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent , CAPTURE_IMAGE);
            }
        });
        btnWeb = (Button) findViewById(R.id.btn_web);
        btnWeb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com"));
                startActivity(intent);
            }
        });


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (requestCode == CAPTURE_IMAGE) {
            if(data != null && data.getExtras() != null){
            Bitmap bitmap = (Bitmap)data.getExtras().get("data");
            imageViewimage.setImageBitmap(bitmap);
        }
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}
