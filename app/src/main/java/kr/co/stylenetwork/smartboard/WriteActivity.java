/*
* 글작성용 액티비티
* */
package kr.co.stylenetwork.smartboard;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

public class WriteActivity extends Activity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_write);
    }

    public void regist(){
    }
    public void close(){
        this.finish();/*현재 액티비티 종료*/
    }
    public void btnClick(View view){
        switch(view.getId()){
            case R.id.bt_regist:regist();break;
            case R.id.bt_close:close();break;
        }

    }
}











