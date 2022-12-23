package layouts;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.fitandfine.R;
import com.google.firebase.auth.FirebaseAuth;

public class home extends AppCompatActivity {

    FirebaseAuth mauth;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }

    public void signoutbtn(View v)
    {
        signout();
    }

    private void signout()
    {
        FirebaseAuth.getInstance().signOut();

        Intent i = new Intent(home.this,login.class);
        startActivity(i);
    }
}