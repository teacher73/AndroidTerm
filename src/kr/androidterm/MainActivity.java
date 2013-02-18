package kr.androidterm;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.Menu;

public class MainActivity extends Activity implements OnListItemSelectedListener{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
 
	}

	private boolean isDual(){
		return getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE?true:false;
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	public void onListItemSelected(int position) {
		if (isDual()) 
			showFragment(position);
		else 
			showActivity(position);	
	}
	
	private void showActivity(int position) {
		Intent intent = new Intent(MainActivity.this, MainDetailActivity.class);
		Bundle b = new Bundle();
		b.putInt("position", position);
		switch(position){
		case 0:
			b.putInt("resId", R.layout.fragmentdetail_graphic);
			break;
		case 1:
			b.putInt("resId", R.layout.fragmentdetail_fragment);
			break;
		case 2:
			b.putInt("resId", R.layout.fragmentdetail_fragment);
			break;
		default:
			b.putInt("resId", R.layout.fragmentdetail_fragment);
		}
		
		intent.putExtras(b);
		startActivity(intent);
	}

	private void showFragment(int position) {
		Fragment details = getFragmentManager().findFragmentById(R.id.mainfragmentdetail);
		FragmentTransaction ft = getFragmentManager().beginTransaction();
		
		
		if (details == null || !details.isInLayout()){
			details = new MainDetailFragment();
			Bundle args = new Bundle();
			
			switch(position){
			case 0:
				args.putInt("resId", R.layout.fragmentdetail_graphic);
				break;
			case 1:
				args.putInt("resId", R.layout.fragmentdetail_fragment);
				break;
			case 2:
				args.putInt("resId", R.layout.fragmentdetail_fragment);
				break;
			default:
				args.putInt("resId", R.layout.fragmentdetail_fragment);
			}
			details.setArguments(args);
			ft.replace(R.id.mainfragmentdetail, details);
			ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
			ft.commit();
		}
	}

}
