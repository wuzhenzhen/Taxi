package taxi.tm.com.taxi;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

public abstract  class BaseActivity extends Activity {

	public void showToast(String str) {
		Toast.makeText(this, str, Toast.LENGTH_SHORT).show();
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setBase();
		initContentView(savedInstanceState);
		WindowManager.LayoutParams params = getWindow().getAttributes();
        params.systemUiVisibility = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION;  //View.SYSTEM_UI_FLAG_LOW_PROFILE;
        getWindow().setAttributes(params);
		initView();
	}

	// 可能全屏或者没有ActionBar等
	public void setBase() {
		requestWindowFeature(Window.FEATURE_NO_TITLE);// 例
	}

	// 初始化UI layout，setContentView等
	protected abstract void initContentView(Bundle savedInstanceState);

	// 初始化UI 组件
	protected abstract void initView ();

	@Override
	protected void onDestroy() {
		setContentView(R.layout.view_null);
		System.out.println("回收内存");
		System.gc();
		System.out.println("回收完成");
		super.onDestroy();
	}

}
