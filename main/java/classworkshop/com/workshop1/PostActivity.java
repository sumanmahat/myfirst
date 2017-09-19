package classworkshop.com.workshop1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import classworkshop.com.workshop1.model.Data2;

public class PostActivity extends AppCompatActivity {
private EditText model,price,location,description;
    private Button post;
    private DatabaseReference databaseReference;
    private FirebaseAuth firebaseAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post);

        model=findViewById(R.id.txt_model);
        price=findViewById(R.id.txt_price);
        location=findViewById(R.id.txt_location);
        description=findViewById(R.id.txt_des);

        databaseReference= FirebaseDatabase.getInstance().getReference();
        firebaseAuth=FirebaseAuth.getInstance();

    }
    public void setPost(View view){
        String mymodel=model.getText().toString();
        String myprice=price.getText().toString();
        String mylocation=location.getText().toString();
        String mydes=description.getText().toString();

        Data2 data2=new Data2(mymodel,myprice,mylocation,mydes);

        databaseReference.child("PostDescription").
                child(FirebaseAuth.getInstance().getCurrentUser().getUid()).push().setValue(data2);

    }
}
