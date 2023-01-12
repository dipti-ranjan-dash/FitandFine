package com.example.fitandfine;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.material.navigation.NavigationView;
import com.squareup.picasso.Picasso;

public class home extends AppCompatActivity {

    NavigationView nav;
    ActionBarDrawerToggle toggle;
    DrawerLayout drawerLayout;
   androidx.appcompat.widget.Toolbar toolbar;
    public GoogleSignInClient googleSignInClient;

   View header;


   @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        toolbar=(Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        nav=(NavigationView)findViewById(R.id.nav_view);
        drawerLayout=(DrawerLayout)findViewById(R.id.drawer_layout);

        toggle = new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.open,R.string.close);

        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();


        nav.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener()
        {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item)
            {
                int id = item.getItemId();

                if(id == R.id.home)
                {
                    Intent intent = new Intent(home.this, home.class);
                    startActivity(intent);
                    finish();

                    Toast.makeText(home.this, "Welcome Back ", Toast.LENGTH_SHORT).show();

                }
                else if(id==R.id.profile)
                {
                    Intent cartIntent = new Intent(home.this, profile.class);
                    startActivity(cartIntent);

                    Toast.makeText(home.this, "This is your Profile", Toast.LENGTH_SHORT).show();
                }
                else if(id==R.id.logout)
                {
                    Intent aboutIntent = new Intent(home.this, logout.class);
                    startActivity(aboutIntent);
                    Toast.makeText(home.this, "Please don't go !", Toast.LENGTH_SHORT).show();
                }

                return true;
            }
        });


        ///////////////////////////////////// this for name and pic  in header///////////////////

        header= nav.getHeaderView(0);
        TextView nameofuser= (TextView) header.findViewById(R.id.nameofuser);
        ImageView userimage=(ImageView) header.findViewById(R.id.userimage);


        GoogleSignInOptions options = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string.default_web_client_id))
                .requestEmail()
                .build();
        googleSignInClient = GoogleSignIn.getClient(this, options);


        GoogleSignInAccount account= GoogleSignIn.getLastSignedInAccount(this);
        if(account!=null)
        {

            String personname = account.getDisplayName();

            Picasso.get().load(account.getPhotoUrl()).placeholder(getDrawable(R.drawable.logofit1)).into(userimage);
            nameofuser.setText(personname);

        }


    }







    }


