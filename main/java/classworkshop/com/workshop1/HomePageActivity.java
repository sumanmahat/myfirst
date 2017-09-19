package classworkshop.com.workshop1;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class HomePageActivity extends AppCompatActivity {

    TextView bike,mobile,car,laptop,camera;
    ImageView bikes,mobiles,cars,laptops,cameras,houses;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
        bike= (TextView) findViewById(R.id.bike);
        bikes= (ImageView) findViewById(R.id.bikes);
        mobile= (TextView) findViewById(R.id.mobile);
        car= (TextView) findViewById(R.id.car);
        laptop= (TextView) findViewById(R.id.laptop);
        camera= (TextView) findViewById(R.id.camera);
        mobiles= (ImageView) findViewById(R.id.mobiles);
        cars= (ImageView) findViewById(R.id.cars);
        laptops= (ImageView) findViewById(R.id.laptops);
        cameras= (ImageView) findViewById(R.id.cameras);
        houses= (ImageView) findViewById(R.id.houses);

        bikes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(HomePageActivity.this,PostActivity.class);
                startActivity(intent);
            }
        });

        mobile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(HomePageActivity.this,PostActivity.class);
                startActivity(intent);
            }
        });

        mobiles.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(HomePageActivity.this,PostActivity.class);
                startActivity(intent);
            }
        });

        cars.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(HomePageActivity.this,PostActivity.class);
                startActivity(intent);
            }
        });

        laptops.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(HomePageActivity.this,PostActivity.class);
                startActivity(intent);
            }
        });

        cameras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(HomePageActivity.this,PostActivity.class);
                startActivity(intent);
            }
        });

        houses.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(HomePageActivity.this,PostActivity .class);
                startActivity(intent);
            }
        });
    }

}
