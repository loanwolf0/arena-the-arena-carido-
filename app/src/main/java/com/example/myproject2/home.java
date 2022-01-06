package com.example.myproject2;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

import java.util.concurrent.Delayed;


public class home extends Fragment {




    public home() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false);




    }
}

class myHome extends AppCompatActivity{

    DrawerLayout drawerLayout;
    Toolbar toolbar;
    NavigationView navigationView;
    ActionBarDrawerToggle toggle;


    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_home);

        drawerLayout=findViewById(R.id.drawer);
        toolbar=findViewById(R.id.nav_toolobar);
        navigationView=findViewById(R.id.navigation);
        setSupportActionBar(toolbar);

        toggle=new ActionBarDrawerToggle(myHome.this,drawerLayout,toolbar,R.string.open,R.string.close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected( MenuItem item) {

                switch (item.getItemId()){

                    case R.id.user_profile:
                        Toast.makeText(myHome.this, "you clicked on profile", Toast.LENGTH_SHORT).show();
                        drawerLayout.closeDrawer(GravityCompat.START);
                        Intent intent = new Intent(myHome.this,user_profile.class);
                        startActivity(intent);

                        break;

                    case R.id.search:
                        Toast.makeText(myHome.this, "you clicked on search", Toast.LENGTH_SHORT).show();
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;

                    case R.id.log_out:
                        Toast.makeText(myHome.this, "you clicked on log_out", Toast.LENGTH_SHORT).show();
                        drawerLayout.closeDrawer(GravityCompat.START);
                        Intent intent_1 = new Intent(myHome.this,search.class);
                        startActivity(intent_1);

                        break;

                }


                return true;
            }
        });


    }

}