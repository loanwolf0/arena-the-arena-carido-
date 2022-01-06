package com.example.myproject2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;

public class user_main_interface extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    BottomNavigationView bottomNavigationView;

    FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_main_interface);


        bottomNavigationView =findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setOnItemSelectedListener(this::onNavigationItemSelected);
        bottomNavigationView.setSelectedItemId(R.id.navigation_home);

        mAuth=FirebaseAuth.getInstance();
    }

    profile Iprofile = new profile();
    edit_photo edit_photo = new edit_photo();
    search search = new search();
    home home =new home();


    @Override
    public boolean onNavigationItemSelected(@NonNull  MenuItem item) {

        switch (item.getItemId()){
            case R.id.navigation_profile:
                //getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout, Iprofile).commit();
                Intent intent =new Intent(user_main_interface.this,user_profile.class);
                startActivity(intent);
                return true;

            case R.id.navigation_editPhoto:
                getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout,edit_photo).commit();
                return true;

            case R.id.navigation_search:
                getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout,search).commit();
                return true;

            case R.id.navigation_home:
                getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout,home).commit();
                return true;

        }

        return true;
    }

    public void log_out(View view) {

        mAuth.signOut();
        Intent intent = new Intent(user_main_interface.this,log_in.class);
        startActivity(intent);
        finish();




    }
}