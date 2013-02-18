/**
 *
 * @package		: kr.androidterm
 * @FileName	: MainDetailFragment.java
 * @Date  		: 2013. 2. 16.
 * @version  	: 1.0.0
 * @Comment  	:
 *
 */

package kr.androidterm;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * 
 * @author mskim
 * @since 2013. 2. 16. 오후 12:09:44
 * @version 1.0.0
 */

public class MainDetailFragment extends Fragment {

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,	Bundle savedInstanceState) {
		View v = inflater.inflate(getArguments().getInt("resId"), container,	false);
		return v;
	}

}
