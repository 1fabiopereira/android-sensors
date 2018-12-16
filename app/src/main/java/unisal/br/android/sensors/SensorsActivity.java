package unisal.br.android.sensors;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class SensorsActivity extends AppCompatActivity {

    private static final int PERMISSIONS_REQUEST_LOCATION = 99;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sensors);
        setTitle(getString(R.string.list_of_sensors));
    }

    public void lightSensor (View view) {
        Intent intent = new Intent(this, LightSensorActivity.class);
        startActivity(intent);
    }

    public void proximitySensor (View view) {
        Intent intent = new Intent(this, ProximitySensorActivity.class);
        startActivity(intent);
    }

    public void gravitySensor (View view) {
        Intent intent = new Intent(this, GravitySensorActivity.class);
        startActivity(intent);
    }

    public void locationSensor (View view) {
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{ Manifest.permission.ACCESS_FINE_LOCATION }, PERMISSIONS_REQUEST_LOCATION);
        } else {
            Intent intent = new Intent(this, LocationSensorActivity.class);
            startActivity(intent);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        switch (requestCode) {
            case PERMISSIONS_REQUEST_LOCATION: {
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    Intent intent = new Intent(this, LocationSensorActivity.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(this, R.string.permission_message, Toast.LENGTH_SHORT).show();
                }
            }
        }
    }
}
