/*
* 글작성용 액티비티
*
* 웹서버에 데이터를 요청하기 위해서는 HttpClient, HttpURLConnection
* 두가지 객체가 지원되는데, HttpClient 객체는  Apache 에서 지원하는 객체이고
* HttpURLConnection 은 표준자바에서 지원하는 객체이다.
* 앞으로는 구글에서 HttpURLConnection 을 사용하라고 했다..
* */
package kr.co.stylenetwork.smartboard;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class WriteActivity extends Activity {
    URL url;
    HttpURLConnection con;
    String path="http://192.168.0.142:8080/android/board/write";

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_write);

        init();
    }

    public void init(){
        try {
            url = new URL(path);
            con= (HttpURLConnection)url.openConnection();
            con.setRequestMethod("POST");
            con.setReadTimeout(15000);
            con.setConnectTimeout(5000);
            con.setDoInput(true);
            con.setDoOutput(true);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }catch(IOException e){
        }
    }

    /*서버와의 접속 메서드 정의*/
    public boolean connectServer(){
        boolean result=false;
        try {
            con.connect();
            result=true;
        } catch (IOException e) {
            e.printStackTrace();
            result=false;
        }
        return result;
    }

    public void regist(){
        MyAsyncTask myAsyncTask = new MyAsyncTask(this);
        myAsyncTask.execute();
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











