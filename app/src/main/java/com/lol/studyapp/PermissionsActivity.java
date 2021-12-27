package com.lol.studyapp;


import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.content.PermissionChecker;

public class PermissionsActivity extends AppCompatActivity {

    public static final int PERMISSION_REQUEST_CODE = 101;
    public static final int PERMISSIONS_REQUEST_CODE = 102;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_permissions);
        initViews();
    }

    private void initViews() {
        findViewById(R.id.btnPermission).setOnClickListener( v -> {
            if (checkPermission()) {
                Toast.makeText(this, "Разрешение получено!", Toast.LENGTH_SHORT).show();
            } else {
                ActivityCompat.requestPermissions(this, new String[] { Manifest.permission.CAMERA }, PERMISSION_REQUEST_CODE);
            }
        });
        findViewById(R.id.btnPermissions).setOnClickListener( v -> {
            if (checkPermissions()) {
                Toast.makeText(this, "Разрешение получено!", Toast.LENGTH_SHORT).show();
            } else {
                String[] perms = new String[] { Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.CAMERA, Manifest.permission.READ_CONTACTS };
                ActivityCompat.requestPermissions(this, perms, PERMISSIONS_REQUEST_CODE);
            }
        });
    }


    public boolean checkPermission() {
        int result = ActivityCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE);
        if (result == PackageManager.PERMISSION_GRANTED){
            return true;
        } else {
            return false;
        }
    }

    public boolean checkPermissions() {
        int result1 = ActivityCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE);
        int result2 = ActivityCompat.checkSelfPermission(this, Manifest.permission.CAMERA);
        int result3 = ActivityCompat.checkSelfPermission(this, Manifest.permission.READ_CONTACTS);
        if (result1 == PackageManager.PERMISSION_GRANTED && result2 == PackageManager.PERMISSION_GRANTED && result3 == PackageManager.PERMISSION_GRANTED){
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case PERMISSION_REQUEST_CODE:
                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    // Permission is granted. Continue the action or workflow
                    // in your app.
                    Toast.makeText(this, "Разрешение получено!", Toast.LENGTH_SHORT).show();
                } else {
                    // Explain to the user that the feature is unavailable because
                    // the features requires a permission that the user has denied.
                    // At the same time, respect the user's decision. Don't link to
                    // system settings in an effort to convince the user to change
                    // their decision.
                    Toast.makeText(this, "Разрешение не получено!", Toast.LENGTH_SHORT).show();
                }
                break;
            case PERMISSIONS_REQUEST_CODE:
                boolean permissionResult = true;
                for (int iGranting : grantResults) {
                    if (iGranting != PermissionChecker.PERMISSION_GRANTED) {
                        permissionResult = false;
                        break;
                    }
                }
                if (permissionResult)
                    Toast.makeText(this, "Разрешение получено!", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(this, "Разрешение не получено!", Toast.LENGTH_SHORT).show();
                break;
        }
        // Other 'case' lines to check for other
        // permissions this app might request.
    }
}

