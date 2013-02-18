/**
 *
 * @package		: kr.androidterm.graphic
 * @FileName	: DrawCanvas.java
 * @Date  		: 2013. 2. 16.
 * @version  	: 1.0.0
 * @Comment  	:
 *
 */

package kr.androidterm.graphic;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;

/**
 * 
 * @author	mskim
 * @since	2013. 2. 16. 오후 6:54:37
 * @version	1.0.0
 */

public class DrawCanvas extends Activity {

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(new MyView(this));
	}
	
	private class MyView extends View{
		public MyView(Context context) {
			super(context);
		}

		@Override
		protected void onDraw(Canvas canvas) {
			super.onDraw(canvas);
			
			Paint p = new Paint(Paint.ANTI_ALIAS_FLAG);
			p.setColor(Color.BLACK);
			
			//사각형 채우기
			p.setStyle(Paint.Style.FILL);
			canvas.drawRect(10, 10, 10+100, 10+100, p);
			
			//사각형 테두리
			p.setStyle(Paint.Style.STROKE);
			canvas.drawRect(120, 10, 120+100, 10+100, p);
		}
	}
}
