package com.example.myproject2;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;

public class dashboard extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    DrawerLayout drawerLayout;
    Toolbar toolbar;
    NavigationView navigationView;
    ActionBarDrawerToggle toggle;
    BottomNavigationView bottomNavigationView;
    FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashbord);

        drawerLayout = findViewById(R.id.drawer);
        toolbar = findViewById(R.id.nav_toolobar);
        navigationView = findViewById(R.id.navigation);
        bottomNavigationView = findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setOnItemSelectedListener(this::onNavigationItemSelected);
        bottomNavigationView.setSelectedItemId(R.id.navigation_home);
        mAuth = FirebaseAuth.getInstance();
        setSupportActionBar(toolbar);

        toggle = new ActionBarDrawerToggle(dashboard.this, drawerLayout, toolbar, R.string.open, R.string.close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {

                switch (item.getItemId()) {

                    case R.id.user_profile:
                        drawerLayout.closeDrawer(GravityCompat.START);
                        Intent intent = new Intent(dashboard.this, user_profile.class);
                        startActivity(intent);
                        break;

                    case R.id.search:
                        Toast.makeText(dashboard.this, "you clicked on search", Toast.LENGTH_SHORT).show();
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;

                    case R.id.log_out:
                        drawerLayout.closeDrawer(GravityCompat.START);
                        AlertDialog.Builder log_out = new AlertDialog.Builder(dashboard.this);
                        log_out.setTitle("Log Out");
                        log_out.setMessage("you will need to log in again ");
                        log_out.setIcon(getResources().getDrawable(R.drawable.ic_baseline_exit_to_app_24));
                        log_out.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                mAuth.signOut();
                                startActivity(new Intent(dashboard.this, log_in.class));
                                finish();
                            }
                        }).setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        });
                        log_out.show();
                        break;

                }
                return true;
            }
        });

    }

    profile Iprofile = new profile();
    BAZAAR BAZAAR = new BAZAAR();
    search search = new search();
    home home = new home();

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.navigation_profile:
                getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout, Iprofile).commit();
                return true;

            case R.id.navigation_editPhoto:
                getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout, BAZAAR).commit();
                return true;

            case R.id.navigation_search:
                getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout, search).commit();
                return true;

            case R.id.navigation_home:
                getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout, home).commit();
                return true;

        }

        return true;
    }
}