package taxi.tm.com.taxi;

import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import org.w3c.dom.Text;

/**
 * Created by kgd on 2016/04/13.
 * wuzhenzhen@tiamaes.com
 */
public class OrderInfoActivity extends BaseActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void initContentView(Bundle savedInstanceState) {
        setContentView(R.layout.activity_order_info);
    }

    public void initView() {
        findViewById(R.id.tv_order_back).setOnClickListener(this);
        //已中标，已完成，其他
        findViewById(R.id.ll_order_info_bid).setOnClickListener(this);
        findViewById(R.id.ll_order_info_complete).setOnClickListener(this);
        findViewById(R.id.ll_order_info_other).setOnClickListener(this);
        //语音播报，一键导航，呼叫客户，请求放空
        findViewById(R.id.tv_btn_1).setOnClickListener(this);
        findViewById(R.id.tv_btn_2).setOnClickListener(this);
        findViewById(R.id.tv_btn_3).setOnClickListener(this);
        findViewById(R.id.tv_btn_4).setOnClickListener(this);

        //上一页，数量，下一页
        findViewById(R.id.tv_order_up).setOnClickListener(this);
        findViewById(R.id.tv_order_down).setOnClickListener(this);
        findViewById(R.id.tv_order_show).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_order_back :
                this.finish();
                break;
            case R.id.tv_btn_1 :
                break;
            case R.id.tv_btn_2 :
                break;
            case R.id.tv_btn_3 :
                break;
            case R.id.tv_btn_4 :
                break;
        }
    }
}
