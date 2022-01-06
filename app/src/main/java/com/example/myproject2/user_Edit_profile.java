package com.example.myproject2;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.karumi.dexter.Dexter;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionDeniedResponse;
import com.karumi.dexter.listener.PermissionGrantedResponse;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.single.PermissionListener;

import java.io.InputStream;

public class user_Edit_profile extends AppCompatActivity {
    Bitmap bitmap;
    Uri filepath;
    ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_edit_profile);

       // img=findViewById(R.id.profile_image_edit);

    }

    public void update(View view) {
        Toast.makeText(this, "sorry ! .. rest of code is being under progress ", Toast.LENGTH_LONG).show();
    }

    public void cancel_editing_profile(View view) {
        Intent intent = new Intent(user_Edit_profile.this,user_profile.class);
        startActivity(intent);
        finish();
    }

    public void save_edit_profile_data(View view) {
        Toast.makeText(this, "update..." +
                "the rest of code is being under progress ", Toast.LENGTH_LONG).show();

    }

    public void upload_user_image(View view) {

        Dexter.withContext(user_Edit_profile.this).withPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
                .withListener(new PermissionListener() {
                    @Override
                    public void onPermissionGranted(PermissionGrantedResponse permissionGrantedResponse) {
                        Intent intent = new Intent(Intent.ACTION_PICK);
                        intent.setType("image/*");
                        startActivityForResult(Intent.createChooser(intent,"select a image "),10);
                    }

                    @Override
                    public void onPermissionDenied(PermissionDeniedResponse permissionDeniedResponse) {

                    }

                    @Override
                    public void onPermissionRationaleShouldBeShown(PermissionRequest permissionRequest, PermissionToken permissionToken) {

                    }
                }).check();


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (requestCode == 10 && resultCode==RESULT_OK){
            filepath =  data.getData();
            try {
                InputStream inputStream = getContentResolver().openInputStream(filepath);
                Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
                img.setImageBitmap(bitmap);


            }catch(Exception e){


            }


        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}