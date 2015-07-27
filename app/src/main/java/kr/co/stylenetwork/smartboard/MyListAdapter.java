/*
* ListView의 아이템이 단순한 TextView 하나짜리 일경우엔
* 이미 안드로이드에서 제공하는 simple_list_item_1 등을 사용할 수 있고,
* 또한 ArrayAdapter를 이용할 수 있으나, 현실적으로 리스트뷰를 이용한 앱은
* 단순한 텍스트뷰 하나짜리만으로는 구현하는 경우가 거의 없다!!
* 해결책)  Adapter를 우리 상황에 맞게 재정의해 쓴다!!
* */
package kr.co.stylenetwork.smartboard;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class MyListAdapter extends BaseAdapter {
    Context context;
    ArrayList<Board> list = new ArrayList<Board>();
    LayoutInflater inflater;

    public MyListAdapter(Context context){
        this.context=context;

        inflater = (LayoutInflater)context.getSystemService(context.LAYOUT_INFLATER_SERVICE);

        /*데이터 베이스 연동 전에, 리스트뷰의 모습을 미리 보자!*/
        for(int i=0;i<20;i++) {
            Board dto = new Board();
            dto.setTitle(i+"번째 제목입니다.");
            dto.setWriter(i + "번째 작성자입니다.");
            dto.setRegdate("2015-01-" + i);

            list.add(dto);
        }
    }

    /* 총 몇개의 아이템으로 이루어졌는지 결정하는 메서드*/
    public int getCount() {
        return list.size();
    }

    /*position 번째의 객체를 반환 */
    public Object getItem(int position) {
        return null;
    }

    /* 선택한 아이템에 부여한 id...*/
    public long getItemId(int position) {
        return 0;
    }

    /* position 번째에 존재할 뷰를 반환하는 메서드!!*/
    public View getView(int position, View convertView, ViewGroup parent) {

        /* ListView가 아이템의 갯수만큼 호출할때, 인플레이션을 시킨결과물을
        * View로 반환해준다 , 그리고 이 View 는 대부분 레이아웃뷰이다!!*/
        View view=null;

        if(convertView == null){
            view=inflater.inflate(R.layout.list_item, parent, false);

        }else{
            view=convertView;
        }

        TextView txt_title=(TextView)view.findViewById(R.id.txt_title);
        TextView txt_writer=(TextView)view.findViewById(R.id.txt_writer);
        TextView txt_regdate=(TextView)view.findViewById(R.id.txt_regdate);

        Board dto=list.get(position);

        txt_title.setText(dto.getTitle());
        txt_writer.setText(dto.getWriter());
        txt_regdate.setText(dto.getRegdate());

        return view;
    }
}













