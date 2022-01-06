 package com.example.myproject2;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.karumi.dexter.Dexter;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionDeniedResponse;
import com.karumi.dexter.listener.PermissionGrantedResponse;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.single.PermissionListener;

import java.io.InputStream;

public class user_profile extends AppCompatActivity {
    private static final String TAG = "hi";
    Button update;
    ImageView profile, close, choose_image;
    Uri filepath;
    Bitmap bitmap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);

        profile = findViewById(R.id.profile_image);
        choose_image = findViewById(R.id.choose_image);
        close = findViewById(R.id.do_not_add_profile_pic);


        update = findViewById(R.id.wants_to_edit_profile);
        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(user_profile.this, "update clicked", Toast.LENGTH_SHORT).show();
//                FirebaseAuth .getInstance().signOut();
//
//                Intent intent = new Intent(user_profile.this,log_in.class);
//                startActivity(intent);

                Intent i =new Intent(user_profile.this,user_Edit_profile.class);
                startActivity(i);


//                Dexter.withContext(user_profile.this).withPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
//                        .withListener(new PermissionListener() {
//                            @Override
//                            public void onPermissionGranted(PermissionGrantedResponse permissionGrantedResponse) {
//                                Log.i(TAG, "onActivityResult: hi");
//                                Intent intent = new Intent(Intent.ACTION_PICK);
//                                intent.setType("image/*");
//                                startActivityForResult(Intent.createChooser(intent,"please select a image"),20);
//                                Log.i(TAG, "onActivityResult: hi");
//
//                            }
//
//                            @Override
//                            public void onPermissionDenied(PermissionDeniedResponse permissionDeniedResponse) {
//
//                            }
//
//                            @Override
//                            public void onPermissionRationaleShouldBeShown(PermissionRequest permissionRequest, PermissionToken permissionToken) {
//
//                            }
//                        }).check();
//
//
//                update.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        Log.i(TAG, "onClick: update 1");
//
//                        uploadFirebase();
//
//                    }
//                });
//
//
//            }
//        });
//
//
//        profile.setOnLongClickListener(new View.OnLongClickListener() {
//            @Override
//            public boolean onLongClick(View v) {
//                profile.setVisibility(v.GONE);
//                choose_image.setVisibility(v.VISIBLE);
//                close.setVisibility(v.VISIBLE);
//                return true;
//            }
//        });
//
//    }
//
//
//
//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, @Nullable  Intent data) {
//        Log.i(TAG, "onActivityResult: hi 0");
//        if (requestCode == 20 && resultCode==RESULT_OK){
//            Log.i(TAG, "onActivityResult: hi 01");
//
//            filepath = data.getData();
//            try {
//                InputStream inputStream = getContentResolver().openInputStream(filepath);
//                bitmap = BitmapFactory.decodeStream(inputStream);
//                Log.i(TAG, "onActivityResult: hi 0");
//                profile.setImageBitmap(bitmap);
//
//            }catch (Exception e){
//
//
//            }
//
//        }
//
//        super.onActivityResult(requestCode, resultCode, data);
//    }
//
//
//    private void uploadFirebase() {
//        Log.i(TAG, "onActivityResult: hi 1");
//
//
//
//        ProgressDialog dialog = new ProgressDialog(this);
//        dialog.setTitle("file uploader");
//        dialog.show();
//        Log.i(TAG, "onActivityResult: hi 2");
//
//
//
//
//        FirebaseStorage storage = FirebaseStorage.getInstance("gs://my-project-2-fe245.appspot.com/");
//        StorageReference uploader = storage.getReference().child("Image_1");
//        Log.i(TAG, "onActivityResult: hi 3");
//
//        uploader.putFile(filepath)
//                .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
//                    @Override
//                    public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
//                        dialog.dismiss();
//                        Toast.makeText(user_profile.this, "file uploaded", Toast.LENGTH_SHORT).show();
//
//
//                    }
//                })
//                .addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
//                    @Override
//                    public void onProgress(@NonNull  UploadTask.TaskSnapshot snapshot) {
//                        float percent = (float)(100* snapshot.getBytesTransferred())/snapshot.getTotalByteCount();
//                        dialog.setMessage("uploaded "+(int)percent+" %");
//
//                    }
//                });
//
//
//    }
//
//
//    public void show_profile_pic(View v) {
//
//
//    }
//
//    public void do_not_add_profile_pic(View v) {
//        choose_image.setVisibility(v.GONE);
//        close.setVisibility(View.GONE);
//        profile.setVisibility(v.VISIBLE);
//
//    }


            }
        });
    }
}


