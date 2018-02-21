package com.example.eduardo.pantallasproyecto;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentManager;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    //Button Meetusbtn;
    //Button Reservationbtn;
    //Button Roomsbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        FragmentManager fragmentManager = getSupportFragmentManager();//<-----------
        fragmentManager.beginTransaction().replace(R.id.container, new MainFragment()).commit();

        //################################ Buttons ##############################
        //Reservationbtn = (Button) findViewById(R.id.btn_reservation);
        //Reservationbtn.setOnClickListener(new View.OnClickListener() {
        //    @Override
        //  public void onClick(View view) {
        //      Intent roomsbtn = new Intent(MainActivity.this, ReservationOptionsActivity.class);
        //     startActivity(roomsbtn);
        //  }
        //});
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    //########################### Opciones del menu #####################
    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        FragmentManager fragmentManager = getSupportFragmentManager();

        if (id == R.id.nav_main){
            fragmentManager.beginTransaction().replace(R.id.container,new MainFragment()).commit();
        } else if (id == R.id.nav_yourHotel) {
            fragmentManager.beginTransaction().replace(R.id.container,new YourHotelFragment()).commit();
        } else if (id == R.id.nav_services) {
            fragmentManager.beginTransaction().replace(R.id.container,new ServicesFragment()).commit();
        } else if (id == R.id.nav_visits) {
            fragmentManager.beginTransaction().replace(R.id.container,new VisitsFragment()).commit();
        } else if (id == R.id.nav_events) {
            fragmentManager.beginTransaction().replace(R.id.container,new EventsFragment()).commit();
        } else if (id == R.id.nav_arrive) {
            fragmentManager.beginTransaction().replace(R.id.container,new UbicationFragment()).commit();
        } else if (id == R.id.nav_contact) {
            fragmentManager.beginTransaction().replace(R.id.container,new ContactFragment()).commit();
        } else if (id == R.id.nav_experience){
            fragmentManager.beginTransaction().replace(R.id.container,new ExperienceFragment()).commit();
        } else if (id == R.id.nav_rules){
            fragmentManager.beginTransaction().replace(R.id.container,new RulesFragment()).commit();
        } else if (id == R.id.nav_logout){

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
