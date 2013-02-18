/**
 *
 * @package		: kr.androidterm
 * @FileName	: MainListFragment.java
 * @Date  		: 2013. 2. 16.
 * @version  	: 1.0.0
 * @Comment  	:
 *
 */

package kr.androidterm;

import android.app.Activity;
import android.app.ListFragment;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * 목차
 * @author	mskim
 * @since	2013. 2. 16. 오전 10:57:31
 * @version	1.0.0
 */

public class MainListFragment extends ListFragment {
	private OnListItemSelectedListener listener;
	
	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		try{
			listener = (OnListItemSelectedListener) activity;
		}catch(ClassCastException e){
			String str = activity.toString() + "must implement OnListItemSeletedListener interface";
			throw new ClassCastException(str);
		}
	}
	
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		setListAdapter(ArrayAdapter.createFromResource(getActivity(), R.array.titlelists, android.R.layout.simple_list_item_activated_1));
	}
	
	@Override
	public void onListItemClick(ListView l, View v, int position, long id) {
		listener.onListItemSelected(position);
	}

}
