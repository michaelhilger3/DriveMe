package com.student.lab1;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Drivmehomepage extends Activity {

    private Button Phone;
    private Button Music;
    private Button Exit;
    private Button Maps;
    private TextView speed_view;
    public float speed;

    public void set_speed(float toset) {
        speed_view.setText("Speed: " + Float.toString(toset));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main_activity_lab1);
        speed_view = (TextView) findViewById(R.id.speed1);
        set_speed(0);


        // this will check veichle speed

        // aquire a reference to the system Location Maganger
        LocationManager locationManager = (LocationManager) this.getSystemService(Context.LOCATION_SERVICE);
        //define a listener that responds to location updates
        LocationListener locationListener = new LocationListener() {
            private Context showspeed;

            @Override
            public void onLocationChanged(Location location) {
//                location.getLatitude();
                speed = location.getSpeed();
                set_speed(speed);
                Toast.makeText(showspeed, "current speed:" + location.getSpeed(), Toast.LENGTH_SHORT).show();
            }


            @Override
            public void onStatusChanged(String provider, int status, Bundle extras) {
            }

            @Override
            public void onProviderEnabled(String provider) {
            }

            @Override
            public void onProviderDisabled(String provider) {
            }
        };

        int TIME_TO_WAIT_MILLIS = 20_000; // 20 seconds
        int DISTANCE_TO_WAIT_METERS = 50; // 50 meters

        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, TIME_TO_WAIT_MILLIS, DISTANCE_TO_WAIT_METERS, locationListener);


//This calls the phone intent for use

        Phone = (Button)

                findViewById(R.id.Phone);

        Phone.setOnClickListener(new View.OnClickListener()

                                 {
                                     @Override
                                     public void onClick(View v) {

                                         Intent phoneintent = new Intent(Intent.ACTION_DIAL);

                                         {
                                             startActivity(phoneintent);
                                         }
                                     }
                                 }

        );
// this call the music intent
        Music = (Button)

                findViewById(R.id.Music);

        Music.setOnClickListener(new View.OnClickListener()

                                 {
                                     @Override
                                     public void onClick(View v) {
                                         Intent musicintent = new Intent("android.intent.action.MUSIC_PLAYER");
                                         startActivity(musicintent);

                                     }
                                 }

        );
//This calls the map intent
        Maps = (Button)

                findViewById(R.id.Maps);

        Maps.setOnClickListener(new View.OnClickListener()

                                {
                                    @Override
                                    public void onClick(View v) {
                                        Uri gmmIntentUri = Uri.parse("google.streeview.cb11=46.414382,10.013988");
                                        Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                                        mapIntent.setClassName("com.google.android.apps.maps", "com.google.android.maps.MapsActivity");
                                        if (mapIntent.resolveActivity(getPackageManager()) != null)
                                            startActivity(mapIntent);


                                    }
                                }

        );

//this will Exit the application

        Exit = (Button)

                findViewById(R.id.Exit);

        Exit.setOnClickListener(new View.OnClickListener()

                                {
                                    @Override
                                    public void onClick(View v) {
                                        if (speed > 15) {
                                            // Tell user why they cannot exit
                                            return;
                                        }

                                        Intent intent = new Intent(Intent.ACTION_MAIN);
                                        intent.addCategory(Intent.CATEGORY_HOME);
                                        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                                        startActivity(intent);

                                    }
                                }

        );

    }

}
