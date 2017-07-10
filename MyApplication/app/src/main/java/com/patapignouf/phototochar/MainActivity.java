package com.patapignouf.phototochar;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.Toast;



public class MainActivity extends AppCompatActivity {


    Context context;
    private static final int CAMERA_PIC_REQUEST = 001;
    Button TDButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        context = this.getApplicationContext();

        Button button1 = (Button) findViewById(R.id.TDButton);

        button1.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {

                if (testPresenceCamera()) {

                    Intent cameraIntent = new Intent(
                            android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
                    startActivityForResult(cameraIntent, CAMERA_PIC_REQUEST);

                } else {
                    Toast.makeText(context, "Le terminal n'a pas de caméra.",
                            Toast.LENGTH_SHORT).show();
                }

            }

        });

        /*
        TDButton = (Button) findViewById(R.id.TDButton);

        TDButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MainActivity.this, AFCameraSimple.class);
                startActivity(intent);
            }
        });


            */



    }

    //((TextView)this.view.findViewById(R.id.latitude)).setText(String.valueOf("Latitude : "+MainPrise.point.getLat()));

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == CAMERA_PIC_REQUEST) {
            Bitmap thumbnail = (Bitmap) data.getExtras().get("data");
            ImageView image = (ImageView) findViewById(R.id.imageView1);
            image.setImageBitmap(thumbnail);
        }
    }

    private boolean testPresenceCamera() {
        PackageManager packageManager = getPackageManager();
        return packageManager.hasSystemFeature(PackageManager.FEATURE_CAMERA);
    }

}
