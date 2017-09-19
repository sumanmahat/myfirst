package classworkshop.com.workshop1;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import classworkshop.com.workshop1.model.UserProfile;

public class RegisterActivity extends AppCompatActivity {
    private EditText fname, lname, age,username, email, password;

    private Spinner spinner;
    private FirebaseAuth firebaseAuth;
    private DatabaseReference databaseReference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        fname=(EditText)findViewById(R.id.txt_first);
        lname=(EditText)findViewById(R.id.txt_last);
        age=(EditText)findViewById(R.id.txt_age);
        username=findViewById(R.id.txtusername);
        email=(EditText)findViewById(R.id.txt_email);
        password=(EditText)findViewById(R.id.txtpassword);

      //  spinner= (Spinner) findViewById(R.id.idSpinner);
       // String [] gender={"Male","Female","Others"};
        //ArrayAdapter adapter= new ArrayAdapter(this,android.R.layout.simple_spinner_dropdown_item);
        //spinner.setAdapter(adapter);

        firebaseAuth=FirebaseAuth.getInstance();
        databaseReference= FirebaseDatabase.getInstance().getReference();

    }
    public   void onRegister(final View view) {
        String myemail = email.getText().toString();
        String mypassword = password.getText().toString();

        final String myfname = fname.getText().toString().trim();
        final String mylname = lname.getText().toString().trim();
        final String myage = age.getText().toString().trim();
        final String myusername = username.getText().toString().trim();

        if (TextUtils.isEmpty(myfname) || TextUtils.isEmpty(mylname) ||
                TextUtils.isEmpty(myage) || TextUtils.isEmpty(myusername) ||
                TextUtils.isEmpty(myemail) || TextUtils.isEmpty(mypassword)) {
            Toast.makeText(RegisterActivity.this, "Please fill the filed", Toast.LENGTH_SHORT).show();
        } else {

            firebaseAuth.createUserWithEmailAndPassword(myemail, mypassword).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (!task.isSuccessful()) {
                        Toast.makeText(RegisterActivity.this, "Signup failed" + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                    } else {
                        saveUserData(myfname, mylname, myage, myusername);
                        //startActivity(new Intent(getApplicationContext(), LoginActivity.class));
                    }
                }
            });
        }
    }

    private void saveUserData(String fname,String lname,String age,String username){
        UserProfile userprofile=new UserProfile(fname, lname, username, age);
        
        databaseReference.child("Users").child(FirebaseAuth.getInstance().getCurrentUser().getUid()).
        child("UserProfile").setValue(userprofile);

        Toast.makeText(getApplicationContext(), "User Created", Toast.LENGTH_SHORT).show();

        Intent i= new Intent(getApplication(),LoginActivity.class);
        startActivity(i);
        finish();
        
    }

    public void onLogin(View view){
        Intent i= new Intent(getApplicationContext(),LoginActivity.class);
        startActivity(i);
    }


}
