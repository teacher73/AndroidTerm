/**
 *
 * @package		: kr.androidterm
 * @FileName	: MainDetailActivity.java
 * @Date  		: 2013. 2. 16.
 * @version  	: 1.0.0
 * @Comment  	:
 *
 */

package kr.androidterm;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;

/**
 * 
 * @author	mskim
 * @since	2013. 2. 16. 오후 12:46:50
 * @version	1.0.0
 */

public class MainDetailActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Fragment details=new MainDetailFragment();
		Bundle args = new Bundle();
		args.putInt("resId", getIntent().getIntExtra("resId",  R.layout.fragmentdetail_fragment));
		details.setArguments(args);
		getFragmentManager().beginTransaction().replace(android.R.id.content, details).commit();
	}
	
}
