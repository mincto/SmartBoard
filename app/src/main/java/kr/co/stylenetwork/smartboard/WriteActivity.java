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
import android.util.Log;
import android.view.View;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class WriteActivity extends Activity {
    String TAG;
    URL url;
    HttpURLConnection con;
    String path="http://192.168.0.142:8080/android/board/write";

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_write);
        TAG=this.getClass().getName();
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

    /* 서버에 데이터 전송*/
    public int sendData(){
        int result=0;
        OutputStream os=null;
        BufferedWriter buffw=null;/*전송할 데이터가 한글이 껴있는 문자열*/

        InputStream is=null;
        BufferedReader buffr=null;

        try {
            os=con.getOutputStream();
            buffw = new BufferedWriter(new OutputStreamWriter(os,"UTF-8"));
            buffw.write("writer=민진호&title=제목연습&content=내용연습\n");
            buffw.flush();

            int responseCode=con.getResponseCode(); /*서버코드 반환받음*/

            if(responseCode == HttpURLConnection.HTTP_OK){
                Log.d(TAG, "서버가 요청을 처리하였습니다.");


                /* 데이터베이스 입력이 성공되었는지 체크*/
                is = con.getInputStream();
                buffr=new BufferedReader(new InputStreamReader(is));

                StringBuilder sb = new StringBuilder();

                String data=null;
                while(  (data=buffr.readLine()) !=null ){
                    sb.append(data);
                }

                /*서버로부터 가져온 데이터가 자바스크립트 객체표기법으로 되어
                * 있다면, JSON 으로 해석하여 알맞게 사용*/
                JSONObject jsonObject = null;
                try {
                    jsonObject=new JSONObject(sb.toString());
                    result=jsonObject.getInt("result");
                    if(result !=0){
                        Log.d(TAG,"데이터베이스 입력 성공"+result);
                    }else{
                        Log.d(TAG,"데이터베이스 입력 실패"+result);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }else{
                Log.d(TAG, "요청에 문제가 있습니다.");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            if(buffw!=null){
                try {
                    buffw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if(os!=null){
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(buffr !=null){
                try {
                    buffr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(is !=null){
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

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











