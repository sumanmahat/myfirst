package classworkshop.com.workshop1;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import classworkshop.com.workshop1.model.Data;

/**
 * Created by Admin on 9/7/2017.
 */

public class ListDataActivity extends AppCompatActivity {
    FirebaseAuth firebaseAuth;
    RecyclerView recyclerView;
    FirebaseRecyclerAdapter adapter;
    DatabaseReference databaseReference;
    private EditText title, amount, date, desc, image;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.data_list_layout);
        recyclerView = (RecyclerView) findViewById(R.id.main_recycler);
        databaseReference = FirebaseDatabase.getInstance().getReference();
        FirebaseDatabase.getInstance().setPersistenceEnabled(true);

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        adapter = new FirebaseRecyclerAdapter<Data, MyDataHolder>
                (Data.class, R.layout.view_layout, MyDataHolder.class,
                        databaseReference.child("User").child("Feed").child("UserDescription")) {
            @Override
            protected void populateViewHolder(final MyDataHolder myDataHolder, final Data data, int position) {
                myDataHolder.titel.setText(data.getTitle());
                myDataHolder.data.setText(data.getData());
                myDataHolder.amount.setText(data.getAmount());
                myDataHolder.desc.setText(data.getDescription());

                if (data.getImage() != null) {
                    Uri uri = Uri.parse(data.getImage());
                    myDataHolder.imageView.setImageURI(uri);
                }


            }
        };
        recyclerView.setAdapter(adapter);

        // firebaseAuth = FirebaseAuth.getInstance();
    }

    public void addData(View view) {
        Intent i = new Intent(getApplication(), AddData.class);
        startActivity(i);
    }

    public static class MyDataHolder extends RecyclerView.ViewHolder {
        View mView;
        TextView titel;
        TextView amount;
        TextView data;
        TextView desc;
        SimpleDraweeView imageView;

        View view;

        public MyDataHolder(View itemView) {
            super(itemView);
            mView = itemView;

            titel = itemView.findViewById(R.id.mytitle);
            amount = itemView.findViewById(R.id.myamount);
            data = itemView.findViewById(R.id.mydata);
            desc = itemView.findViewById(R.id.mydesc);
            imageView = itemView.findViewById(R.id.myimage);

            view = itemView.findViewById(R.layout.view_layout);
        }
    }
}
