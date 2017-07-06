package com.example.mateu.reflexchecker;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class RegisterActivity extends AppCompatActivity {

    private EditText editTextMail;
    private EditText editTextPassword;
   // private Button buttonSignUp;
   // private TextView textViewSignIn;

    private ProgressDialog progressDialog;
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        firebaseAuth= FirebaseAuth.getInstance();
        FirebaseUser user = firebaseAuth.getCurrentUser();
      //  buttonSignUp=(Button)findViewById(R.id.buttonSignIn);

        if(user!=null)
        {
            finish();
            startActivity(new Intent(getApplicationContext(),ProfileActivity.class));
        }
        editTextMail=(EditText)findViewById(R.id.userEMail);
        editTextPassword=(EditText)findViewById(R.id.userPassword);
      //  textViewSignIn=(TextView)findViewById(R.id.textViewSignIn);

        progressDialog=new ProgressDialog(this);
    }
    private void registerUser()
    {
        final String email=editTextMail.getText().toString().trim();
        final String password=editTextPassword.getText().toString().trim();
        if(TextUtils.isEmpty(email))
        {
            Toast.makeText(this,"Please, enter email",Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(password))
        {
            Toast.makeText(this,"Please, enter password",Toast.LENGTH_SHORT).show();
            return;
        }
        progressDialog.setMessage("Registering user...");
        progressDialog.show();
        firebaseAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful())
                {

                    //user logged
                    finish();
                    startActivity(new Intent(getApplicationContext(),ProfileActivity.class));
                }
                else
                {
                    Toast.makeText(RegisterActivity.this,"Not Registered",Toast.LENGTH_SHORT).show();

                }
                progressDialog.dismiss();
            }
        });

    }

    public void tryToRegisterUser(View v)
    {
        registerUser();

    }
    public void goToSignIn(View v)
    {
        startActivity(new Intent(this,LoginActivity.class));

    }
    public void goToMainView(View v)
    {
        startActivity(new Intent(this,MainActivity.class));

    }
}
