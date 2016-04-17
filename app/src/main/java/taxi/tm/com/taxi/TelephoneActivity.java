package taxi.tm.com.taxi;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

/**
 * Created by kgd on 2016/04/14.
 * wuzhenzhen@tiamaes.com
 */
public class TelephoneActivity extends BaseActivity implements View.OnClickListener{

    public TextView tv_title;

    @Override
    protected void initContentView(Bundle savedInstanceState) {
        setContentView(R.layout.activity_telephone);
    }

    @Override
    protected void initView() {
        tv_title = (TextView) findViewById(R.id.tv_title);
        tv_title.setText("电话");

        findViewById(R.id.ll_tel_left_up).setOnClickListener(this);
        findViewById(R.id.ll_tel_left_mid).setOnClickListener(this);
        findViewById(R.id.ll_tel_left_down).setOnClickListener(this);

        findViewById(R.id.ll_numeric_del).setOnClickListener(this); //删除键
        findViewById(R.id.tv_dial_on).setOnClickListener(this); //拨号键
        findViewById(R.id.tv_dial_hangup).setOnClickListener(this);//挂号键

        findViewById(R.id.tv_dial_1).setOnClickListener(this); //数字键1
        findViewById(R.id.tv_dial_2).setOnClickListener(this);
        findViewById(R.id.tv_dial_3).setOnClickListener(this);
        findViewById(R.id.tv_dial_4).setOnClickListener(this);
        findViewById(R.id.tv_dial_5).setOnClickListener(this);
        findViewById(R.id.tv_dial_6).setOnClickListener(this);
        findViewById(R.id.tv_dial_7).setOnClickListener(this);
        findViewById(R.id.tv_dial_8).setOnClickListener(this);
        findViewById(R.id.tv_dial_9).setOnClickListener(this);
        findViewById(R.id.tv_dial_0).setOnClickListener(this);
        findViewById(R.id.tv_dial_10).setOnClickListener(this);
        findViewById(R.id.tv_dial_11).setOnClickListener(this);

        findViewById(R.id.tv_back).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ll_tel_left_up :
                break;
            case R.id.ll_tel_left_mid :
                break;
            case R.id.ll_tel_left_down :
                break;
            case R.id.tv_back :
                this.finish();
                break;
        }
    }
}
