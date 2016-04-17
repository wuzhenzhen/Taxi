package taxi.tm.com.taxi;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

/**
 * Created by kgd on 2016/04/15.
 * wuzhenzhen@tiamaes.com
 */
public class TaxiStatusActivity extends BaseActivity implements View.OnClickListener{

    public TextView tv_title;

    @Override
    protected void initContentView(Bundle savedInstanceState) {
        setContentView(R.layout.activity_taxi_status);
    }

    @Override
    protected void initView() {
        tv_title = (TextView) findViewById(R.id.tv_title);
        tv_title.setText("评价");
        findViewById(R.id.tv_back).setOnClickListener(this);
        findViewById(R.id.ll_satisfaction).setOnClickListener(this);
        findViewById(R.id.ll_dissatisfaction).setOnClickListener(this);
        findViewById(R.id.ll_great_satisfaction).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_back :
                this.finish();
                break;
        }
    }
}
