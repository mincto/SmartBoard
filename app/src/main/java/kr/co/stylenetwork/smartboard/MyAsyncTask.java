/*
* 안드로이드에서는 개발자가 정의한 쓰레드가 UI를 제어할 수 없도록 막아놓았다
* 따라서 웹서버와의 연동후  UI 를 갱신하려면 개발자가 정의한 쓰레드만으로는
* 처리가 불가능하다. 이 업무를 수행하기 위해서는 Handler를 사용해야 하지만,
* Handler의 사용이 불편하다면 AsyncTask 를 이용하면 된다!!
* */
package kr.co.stylenetwork.smartboard;

import android.os.AsyncTask;
import android.util.Log;

public class MyAsyncTask extends AsyncTask<Void , Void , Integer>{
    String TAG;
    WriteActivity writeActivity;

    public MyAsyncTask(WriteActivity writeActivity) {
        this.writeActivity = writeActivity;
        TAG=this.getClass().getName();
    }

    /*
        * 쓰레드로 작업을 시도하기전에 초기화할 작업이 있다면 이 메서드에서
        * 로직을 구현...이 메서드는 메인쓰레드에 의해 호출(UI,디자인 제어가능)
        * */
    protected void onPreExecute() {
        super.onPreExecute();
    }

    /*
        * 개발자가 정의한 쓰레드에 의해 호출되는 메서드
        * 웹서버와의 통신!!
        * */
    protected Integer doInBackground(Void... params) {
        boolean result=writeActivity.connectServer();
        if(result){
            Log.d(TAG, "접속 성공");
        }else{
            Log.d(TAG, "접속 실패");
        }
        return null;
    }

    /*doInBackground 메서드 수행중에 호출되는 메서드 */

    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }
    /*
        * doInbackground 메서드의 수행이 끝나면, 호출되는 메서드로
        * 서버와의 통신 작업이 끝난후 그 결과물을 UI에 반영하자..당연히 메인쓰레드에
        * 의해 호출됨
        * */
    protected void onPostExecute(Integer integer) {
        super.onPostExecute(integer);
    }
}














