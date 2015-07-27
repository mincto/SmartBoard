/*
* ListView 는 껍데기일 뿐이므로, ListView가 정보를 가져올 어댑터를
* 재정의 본다!!
*
* */
package kr.co.stylenetwork.smartboard;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

public class ListFragment extends Fragment implements AdapterView.OnItemClickListener{
    MainActivity mainActivity;
    ListView listView;
    MyListAdapter adapter;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.mainActivity=(MainActivity)getActivity();

        View view=inflater.inflate(R.layout.fragment_list, container, false);
        listView=(ListView)view.findViewById(R.id.listView);
        adapter =new MyListAdapter(getActivity());
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(this);/*리스너와의 연결*/
        return view;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(getActivity(), position+"번째 눌렀어?", Toast.LENGTH_SHORT).show();

        /* 상세보기 페이지( index 1) 로 이동!!*/
        mainActivity.showPage(1);
    }
}












