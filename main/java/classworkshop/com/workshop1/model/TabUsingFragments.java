package classworkshop.com.workshop1.model;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import classworkshop.com.workshop1.Fragments.ButtomFragments;
import classworkshop.com.workshop1.Fragments.TopFragments;
import classworkshop.com.workshop1.R;

public class TabUsingFragments extends AppCompatActivity {
    TextView tab1,tab2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab_using_fragments);
        tab1=(TextView) findViewById(R.id.tab1);
        tab2=(TextView) findViewById(R.id.tab2);

        tab1.setOnClickListener(tabclicklistner);
        tab2.setOnClickListener(tabclicklistner);
        getSupportFragmentManager().beginTransaction().replace(R.id.container,new TopFragments()).commit();

    }
    public View.OnClickListener tabclicklistner= new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if (view.getId()==R.id.tab1){
                getSupportFragmentManager().beginTransaction().replace(R.id.container,new TopFragments()).commit();
            }else {
                getSupportFragmentManager().beginTransaction().replace(R.id.container,new ButtomFragments()).commit();
            }
        }
    };
}
