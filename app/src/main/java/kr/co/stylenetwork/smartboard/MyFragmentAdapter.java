
/*
*  ViewPager는 껍데기일 뿐이므로, 총 몇페이지로 각 페이지에
*  어떤 프레그먼트가 나와야할지를 결정해주는 자인 FragmentStatePagerAdapter
*  를 재정의 해보자!!
*
* */
package kr.co.stylenetwork.smartboard;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

public class MyFragmentAdapter extends FragmentStatePagerAdapter{
    Fragment[] pages = new Fragment[3];
    /*
    * ViewPager를 이용하지 않고, 개발자가 직접 프레그먼트를 이용하여
    * 화면에 나오고 , 않보이게 처리하려면 페이지 관련한 트랜잭션을 처리해야 하는
    * 불편함이 있다. 그리고 페이지 관련 트랜잭션은 FragmentManager를 통해
    * 얻어와야한다. 그런데,!
    * ViewPager를 이용하면 개발자가 더이상, 페이지 관련 트랜잭션을 제어할 필요
    * 가 없다..그대신 , FragmentManager는 어댑터에게 넘겨줘야 한다!!
    * */
    public MyFragmentAdapter(FragmentManager fm) {
        super(fm);
        pages[0]=new ListFragment();
        pages[1]=new DetailFragment();
        pages[2]=new EditFragment();
    }

    /*총 몇페이지로 구성되었는지를 결정하는 메서드*/
    public int getCount() {
        return pages.length;
    }

    /*position 번째 페이지를 어떤 프레그먼트로 보여줄지를 결정*/
    public Fragment getItem(int position) {
        return pages[position];
    }


}












