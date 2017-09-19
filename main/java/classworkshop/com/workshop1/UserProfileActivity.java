package classworkshop.com.workshop1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import classworkshop.com.workshop1.model.UserProfile;

public class UserProfileActivity extends AppCompatActivity {
    DatabaseReference databaseReference;
    private TextView fname,lname,age,username;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);

        fname=(TextView) findViewById(R.id.profile_fname);
        lname=(TextView)findViewById(R.id.profile_lname);
        age=(TextView)findViewById(R.id.profile_age);
        username=(TextView)findViewById(R.id.profile_username);

        databaseReference= FirebaseDatabase.getInstance().getReference("Users").
                child(FirebaseAuth.getInstance().getCurrentUser().getUid()).child("UserProfile");

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                UserProfile userProfile = dataSnapshot.getValue(UserProfile.class);

                fname.setText(userProfile.getFname());
                lname.setText(userProfile.getLname());
                age.setText(userProfile.getAge());
                username.setText(userProfile.getUsername());
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
}
