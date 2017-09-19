package classworkshop.com.workshop1.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import classworkshop.com.workshop1.R;

/**
 * Created by Admin on 9/6/2017.
 */

public class ButtomFragments extends Fragment{

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.add_layout,null);
        return view;
    }
}
