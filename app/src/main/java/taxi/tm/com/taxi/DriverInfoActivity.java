package taxi.tm.com.taxi;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

/**
 * Created by kgd on 2016/04/14.
 * wuzhenzhen@tiamaes.com
 */
public class DriverInfoActivity extends BaseActivity implements View.OnClickListener{

    public TextView tv_title;
    @Override
    protected void initContentView(Bundle savedInstanceState) {
        setContentView(R.layout.activity_driver_info);
    }

    @Override
    protected void initView() {
        tv_title = (TextView) findViewById(R.id.tv_title);
        tv_title.setText("郑州市出租车公司");
        findViewById(R.id.tv_back).setOnClickListener(this);
        findViewById(R.id.tv_shift).setOnClickListener(this);
        findViewById(R.id.tv_sign).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.tv_back :
                this.finish();
                break;
        }
    }
}
