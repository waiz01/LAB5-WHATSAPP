package com.example.lab5acallwa;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.net.URLEncoder;

public class MainActivity extends AppCompatActivity {

    Button waButton;
    Button dialButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        waButton = (Button) findViewById(R.id.button2);
        dialButton = (Button) findViewById(R.id.button);
    }

    public void waNumber(View view) {
        PackageManager packageManager = getPackageManager();
        Intent i = new Intent(Intent.ACTION_VIEW);
        String message = "Hello";
        String phone = "+60132121704";
        try {
            String url = "https://api.whatsapp.com/send?phone=" + phone + "&text=" + URLEncoder.encode(message, "UTF-8");
            i.setPackage("com.whatsapp");
            i.setData(Uri.parse(url));
            if (i.resolveActivity(packageManager) != null) {
                startActivity(i);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void callPhoneNumber (View view)
    {try
    {if(Build.VERSION.SDK_INT > 22)
    { if (ActivityCompat.checkSelfPermission(this,
            Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {

        ActivityCompat.requestPermissions(this, new String[]{
                Manifest.permission.CALL_PHONE}, 101);
        return;
    }
        Intent callIntent = new Intent(Intent.ACTION_CALL);
        callIntent.setData(Uri.parse("tel:" + "0355442000"));
        startActivity(callIntent);
    }
    else {
        Intent callIntent = new Intent(Intent.ACTION_CALL);
        callIntent.setData(Uri.parse("tel:" + "0355442000"));
        startActivity(callIntent);
    } }
    catch (Exception ex)
    {ex.printStackTrace(); } }


}