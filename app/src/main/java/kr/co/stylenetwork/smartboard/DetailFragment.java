package kr.co.stylenetwork.smartboard;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class DetailFragment extends Fragment implements View.OnClickListener{
    MainActivity mainActivity;
    Button bt_editForm,bt_delete, bt_list;
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_detail, container, false);
        mainActivity = (MainActivity)getActivity();

        bt_editForm=(Button)view.findViewById(R.id.bt_editForm);
        bt_delete=(Button)view.findViewById(R.id.bt_delete);
        bt_list=(Button)view.findViewById(R.id.bt_list);

        bt_editForm.setOnClickListener(this);
        bt_delete.setOnClickListener(this);
        bt_list.setOnClickListener(this);

        return view;
    }

    public void goEditForm(){
        mainActivity.showPage(2);
    }
    public void delete(){

    }
    public void getList(){

    }
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bt_editForm:goEditForm();break;
            case R.id.bt_delete:delete();break;
            case R.id.bt_list:getList();break;
        }
    }


}











