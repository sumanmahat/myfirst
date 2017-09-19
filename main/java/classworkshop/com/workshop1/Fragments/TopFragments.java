package classworkshop.com.workshop1.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import classworkshop.com.workshop1.PostActivity;
import classworkshop.com.workshop1.R;

/**
 * Created by Admin on 9/6/2017.
 */

public class TopFragments extends Fragment{
    private TextView bike,mobile,car,laptop,camera;
    private ImageView bikes,mobiles,cars,laptops,cameras,houses;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_home_page,null);
        bike= (TextView) view.findViewById(R.id.bike);
        bikes= (ImageView) view.findViewById(R.id.bikes);
        mobile= (TextView) view.findViewById(R.id.mobile);
        car= (TextView) view.findViewById(R.id.car);
        laptop= (TextView) view.findViewById(R.id.laptop);
        camera= (TextView) view.findViewById(R.id.camera);
        mobiles= (ImageView) view.findViewById(R.id.mobiles);
        cars= (ImageView) view.findViewById(R.id.cars);
        laptops= (ImageView) view.findViewById(R.id.laptops);
        cameras= (ImageView) view.findViewById(R.id.cameras);
        houses= (ImageView) view.findViewById(R.id.houses);

        bikes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(getActivity(),PostActivity.class);
                startActivity(intent);
            }
        });

        mobile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(getActivity(),PostActivity.class);
                startActivity(intent);
            }
        });

        mobiles.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(getActivity(),PostActivity.class);
                startActivity(intent);
            }
        });

        cars.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(getActivity(),PostActivity.class);
                startActivity(intent);
            }
        });

        laptops.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(getActivity(),PostActivity.class);
                startActivity(intent);
            }
        });

        cameras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(getActivity(),PostActivity.class);
                startActivity(intent);
            }
        });

        houses.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(getActivity(),PostActivity .class);
                startActivity(intent);
            }
        });
        return view;
    }


}
