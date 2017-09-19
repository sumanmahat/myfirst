package classworkshop.com.workshop1;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.io.ByteArrayOutputStream;

import classworkshop.com.workshop1.model.Data;

/**
 * Created by Admin on 9/5/2017.
 */

public class AddData extends AppCompatActivity {

    FirebaseStorage storage = FirebaseStorage.getInstance();
    StorageReference storageRef = storage.getReference();

    Bitmap bitmap;
    private EditText title, data, amount, description;
    private ImageView image;
    private Button save, cancel;
    private DatabaseReference databaseReference;
    private StorageReference storageReference;
    private FirebaseAuth firebaseAuth;
    private Uri imageUri;
    private Context context;

    public static byte[] getBlob(Bitmap bitmap) {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, bos);
        byte[] bArray = bos.toByteArray();
        return bArray;
    }

    public static Bitmap getBitmap(byte[] byteAray) {
        return BitmapFactory.decodeByteArray(byteAray, 0, byteAray.length);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_layout);
        context = this;

        title = findViewById(R.id.txttitle);
        data = findViewById(R.id.txtdate);
        amount = findViewById(R.id.txtamount);
        description = findViewById(R.id.txtdesc);
        image = findViewById(R.id.txtimage);

        image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent();
                i.setType("image/*");
                i.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(Intent.createChooser(i, "Select Picture"), 001);
            }
        });

        databaseReference = FirebaseDatabase.getInstance().getReference();
        storageReference = FirebaseStorage.getInstance().getReference();
        firebaseAuth = FirebaseAuth.getInstance();
    }

    //method
    public void AddData(View view) {

        // StorageReference =new StorageReference().
        final String mytitle = title.getText().toString().trim();
        final String mydata = data.getText().toString().trim();
        final String myamount = amount.getText().toString().trim();
        final String mydesc = description.getText().toString().trim();


        if (TextUtils.isEmpty(mytitle) || TextUtils.isEmpty(mydata) ||
                TextUtils.isEmpty(myamount) || TextUtils.isEmpty(mydesc)) {
            Toast.makeText(getApplicationContext(), "Please fill the fields", Toast.LENGTH_SHORT).show();
        } else {
            String fileName = System.currentTimeMillis() + ".jpg";

            storageReference.child(fileName).putFile(imageUri).addOnCompleteListener(new OnCompleteListener<UploadTask.TaskSnapshot>() {
                @Override
                public void onComplete(@NonNull Task<UploadTask.TaskSnapshot> task) {
                    Data data = new Data(mytitle, mydata, myamount, mydesc, task.getResult().getDownloadUrl().toString());
                    databaseReference.child("User").
                            child("Feed").child("UserDescription").push().setValue(data);
                    Toast.makeText(AddData.this, "Post Successful!!!", Toast.LENGTH_SHORT).show();
                    context.startActivity(new Intent(context, ListDataActivity.class));
                    finish();

                }
            }).addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
                @Override
                public void onProgress(UploadTask.TaskSnapshot taskSnapshot) {
                }
            }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {
                    Toast.makeText(AddData.this, "Failed to upload image", Toast.LENGTH_SHORT).show();
                }
            });
//            Uri file = Uri.fromFile(new File(String.valueOf(imageUri)));
//            StorageReference riversRef = storageRef.child("images/" + file.getLastPathSegment());
//            UploadTask uploadTask = riversRef.putFile(file);

//
//            uploadTask.addOnFailureListener(new OnFailureListener() {
//            @Override
//
//                public void onFailure(@NonNull Exception exception) {
//
//}
//            }).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
//                    @Override
//
//
//                public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
//
//                        Toast.makeText(AddData.this,"Upload Success",Toast.LENGTH_SHORT).show();
//
//                    }
//            });


//            Toast.makeText(AddData.this, "Data Inserted", Toast.LENGTH_SHORT).show();
//            Intent i = new Intent(getApplication(), ListDataActivity.class);
//            startActivity(i);
//            finish();

        }
    }

    public void onCancel(View view) {
        Intent i = new Intent(AddData.this, MainActivity.class);
        startActivity(i);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 001 && resultCode == RESULT_OK) {
            imageUri = data.getData();

        }
    }
}
