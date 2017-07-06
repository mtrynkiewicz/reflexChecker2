package com.example.mateu.reflexchecker;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ProfileActivity extends AppCompatActivity implements View.OnClickListener {

    private FirebaseAuth firebaseAuth;
    private TextView textViewUserEmail;
    private Button buttonLogout;

    private DatabaseReference databaseReference;

    private EditText editTextSurname,editTextFirstname;
    private Button buttonSave;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        firebaseAuth=FirebaseAuth.getInstance();
        FirebaseUser user=firebaseAuth.getCurrentUser();
        if (user==null)
        {
            finish();
            startActivity(new Intent(this,MainActivity.class));
        }
        databaseReference= FirebaseDatabase.getInstance().getReference();
        editTextFirstname=(EditText)findViewById(R.id.editTextFirstName);
        editTextSurname=(EditText)findViewById(R.id.editTextSurname);
        buttonSave=(Button)findViewById(R.id.buttonSave);

        textViewUserEmail=(TextView)findViewById(R.id.textViewUserEmail);
        buttonLogout=(Button)findViewById(R.id.buttonLogout);
        textViewUserEmail.setText("Welcome: "+user.getEmail());

        buttonLogout.setOnClickListener(this);
        buttonSave.setOnClickListener(this);

    }
    private void saveUserInformation()
    {
        String firstName=editTextFirstname.getText().toString().trim();
        String surname = editTextSurname.getText().toString().trim();

        UserInformationModel userInformationModel=new UserInformationModel(firstName,surname,"0");
        FirebaseUser user = firebaseAuth.getCurrentUser();
        databaseReference.child(user.getUid()).setValue(userInformationModel);

        Toast.makeText(this,"Your informations were saved",Toast.LENGTH_LONG).show();




    }

    @Override
    public void onClick(View v) {

        if(v==buttonLogout)
        {
            firebaseAuth.signOut();
            finish();
            startActivity(new Intent(this,LoginActivity.class));
        }
        if(v==buttonSave)
        {
            saveUserInformation();
        }
    }
    public void goToMainView(View v)
    {
        startActivity(new Intent(this,MainActivity.class));

    }
}
