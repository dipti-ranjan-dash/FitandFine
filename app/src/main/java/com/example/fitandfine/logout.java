package com.example.fitandfine;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.firebase.auth.FirebaseAuth;

public class logout extends AppCompatActivity {


    public GoogleSignInClient googleSignInClient;
    TextView email,name;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logout);

        email=findViewById(R.id.email);
        name =findViewById(R.id.name);

        GoogleSignInOptions options = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string.default_web_client_id))
                .requestEmail()
                .build();
        googleSignInClient = GoogleSignIn.getClient(this, options);


        GoogleSignInAccount account= GoogleSignIn.getLastSignedInAccount(this);
        if(account!=null)
        {

            String personname = account.getDisplayName();
            String personeemail = account.getEmail();

            name.setText(personname);
            email.setText(personeemail);
        }
    }





        public void signoutbtn(View v)
    {
        signout();
    }

    private void signout()
    {
        FirebaseAuth.getInstance().signOut();

        Intent i = new Intent(logout.this, login.class);
        startActivity(i);
    }
}