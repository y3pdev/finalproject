package com.example.finalproject;

import androidx.fragment.app.FragmentActivity;

import android.location.Location;
import android.location.LocationProvider;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */



    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng a = new LatLng(18.588180, 98.487052);
        mMap.addMarker(new MarkerOptions().position(a).title("ดอยอินทนนท์"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(a));

        LatLng b = new LatLng(18.588731, 98.487813);
        mMap.addMarker(new MarkerOptions().position(b).title("จุดสูงสุดแดนสยาม"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(b));

        LatLng c = new LatLng(18.776367, 98.999979);
        mMap.addMarker(new MarkerOptions().position(c).title("พิพิธภัณฑ์ภาพวาด 3 มิติ เชียงใหม"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(c));

        LatLng d = new LatLng(19.386583, 98.858313);
        mMap.addMarker(new MarkerOptions().position(d).title("อุทยานแห่งชาติดอยหลวง"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(d));

        LatLng e = new LatLng(18.759517, 98.918672);
        mMap.addMarker(new MarkerOptions().position(e).title("วัดพระธาตุดอยคำ"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(e));

        LatLng f = new LatLng(18.784903, 98.954956);
        mMap.addMarker(new MarkerOptions().position(f).title("หอศิลป์วัฒนะ"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(f));

        LatLng g = new LatLng(18.786988, 98.986578);
        mMap.addMarker(new MarkerOptions().position(g).title("วัดเจดีย์หลวงวรวิหาร"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(g));

        LatLng h = new LatLng(18.796182, 98.970671);
        mMap.addMarker(new MarkerOptions().position(h).title("พิพิธภัณฑ์แมลงโลกและสิ่งมหัศจรรย์ธรรมชาติ"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(h));

        LatLng i = new LatLng(18.790274, 98.987353);
        mMap.addMarker(new MarkerOptions().position(h).title("พระบรมราชานุสาวรีย์สามกษัตริย์"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(h));

        LatLng j = new LatLng(18.785292, 99.000273);
        mMap.addMarker(new MarkerOptions().position(j).title("ไนท์บาซาร์เชียงใหม่"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(j));

        mMap.getUiSettings().setZoomControlsEnabled(true);
    }
}