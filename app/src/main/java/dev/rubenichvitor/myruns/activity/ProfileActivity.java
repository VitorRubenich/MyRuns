package dev.rubenichvitor.myruns.activity;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import dev.rubenichvitor.myruns.databinding.ActivityProfileBinding;


public class ProfileActivity extends AppCompatActivity {

    private int REQUEST_IMAGE_CAPTURE = 100;
    private ActivityProfileBinding binding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityProfileBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        insertListeners();
    }

    private void insertListeners(){
        binding.btnChangeProfileImage.setOnClickListener(v -> requestPermission());
    }

    private void requestPermission(){
        if(ActivityCompat.checkSelfPermission(getBaseContext(),Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED){
            //usar API camera
            startActivityForResult(new Intent(MediaStore.ACTION_IMAGE_CAPTURE), REQUEST_IMAGE_CAPTURE);

        }else if(shouldShowRequestPermissionRationale(Manifest.permission.CAMERA)){
            showInContextUi();
        }else{
            requestPermissions(new String[] { Manifest.permission.CAMERA }, 123);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case 123:
                if (grantResults.length > 0 &&
                        grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    //continue doing
                } else {
                    //explain to user
                }
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == REQUEST_IMAGE_CAPTURE &&  resultCode == RESULT_OK){

            Bitmap bitmap = (Bitmap) data.getExtras().get("data");
            binding.profileImage.setImageBitmap(bitmap);
        }
    }

    private void showInContextUi(){

    }
}
