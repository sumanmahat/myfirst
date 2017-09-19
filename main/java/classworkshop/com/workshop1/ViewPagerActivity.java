package classworkshop.com.workshop1;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import classworkshop.com.workshop1.Fragments.ButtomFragments;
import classworkshop.com.workshop1.Fragments.TopFragments;

public class ViewPagerActivity extends AppCompatActivity {
     ViewPager pager;
    private TextView tab1,tab2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager);
        pager= (ViewPager) findViewById(R.id.pager);
        tab1 = (TextView) findViewById(R.id.tab1);
        tab2 = (TextView) findViewById(R.id.tab2);
        tab1.setOnClickListener(tabclicklistner);
        tab2.setOnClickListener(tabclicklistner);

        pager.setAdapter(new PagerAdapter(getSupportFragmentManager()));


    }
    public View.OnClickListener tabclicklistner = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (v.getId() == R.id.tab1) {
                pager.setCurrentItem(0);
            } else {
                pager.setCurrentItem(1);
            }
        }
    };

    public class PagerAdapter extends FragmentPagerAdapter {

        public PagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            if (position==0){
                return new TopFragments();
            }else {
                return new ButtomFragments();
            }

        }

        @Override
        public int getCount() {
            return 2;
        }
    }
}
