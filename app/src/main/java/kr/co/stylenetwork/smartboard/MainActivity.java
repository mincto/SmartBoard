package kr.co.stylenetwork.smartboard;

import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;


public class MainActivity extends FragmentActivity{


    ViewPager viewPager;
    MyFragmentAdapter adapter;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager = (ViewPager)findViewById(R.id.viewPager);
        adapter =  new MyFragmentAdapter(getSupportFragmentManager());
        viewPager.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);

        return super.onCreateOptionsMenu(menu);
    }


    public void regist(){
       Toast.makeText(this,"글쓸꺼야?", Toast.LENGTH_SHORT).show();
        /*또 다른 액티비티 호출하기 */
        Intent intent = new Intent(this, WriteActivity.class);
        startActivity(intent);/*다른 액티비티호출*/
    }

    /*어떤 페이지를 보여줄지를 결정하는 메서드*/
    public void showPage(int position){
        viewPager.setCurrentItem(position);
    }

    public void btnClick(View view){
        switch (view.getId()){
            case R.id.bt_write:regist();break;
        }
    }
}










