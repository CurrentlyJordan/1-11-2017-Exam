package nyc.c4q.jordansmith.dustykeyboardkeysforsale;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

public class PictureDisplay extends AppCompatActivity {

    ImageView keyImageView;
    String imageUrl;
    boolean backButtonPressed = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_picture_display);

        keyImageView = (ImageView) findViewById(R.id.key_display_image_view);

        Intent intent = getIntent();
        imageUrl = intent.getStringExtra("Image Url");
        imageUrl = "http://jsjrobotics.nyc" + imageUrl;
        Glide.with(this).load(imageUrl).into(keyImageView);

    }

    @Override
    public void onBackPressed() {
        if(!backButtonPressed){
            Toast.makeText(getApplicationContext(), "Press once more to see list", Toast.LENGTH_SHORT).show();
            backButtonPressed = true;
        }
        else{
            super.onBackPressed();
        }

    }
}
