package taxi.tm.com.taxi;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.format.DateFormat;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends BaseActivity implements View.OnClickListener{

    public LinearLayout ll_click_bid, ll_click_msg, ll_click_gps, ll_click_call, ll_click_revenue, ll_click_setting;

    public TextView tv_time, tv_taxi_status;

    public static final int TITLE_TIME_REFRESH = 1;

    View main;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        new TimeThread().start();
    }

    @Override
    protected void initContentView(Bundle savedInstanceState) {
        setContentView(R.layout.activity_main);
    }

    public void initView() {
        ll_click_bid = (LinearLayout) findViewById(R.id.ll_click_bid);
        ll_click_msg = (LinearLayout) findViewById(R.id.ll_click_msg);
        ll_click_gps = (LinearLayout) findViewById(R.id.ll_click_gps);
        ll_click_call = (LinearLayout) findViewById(R.id.ll_click_call);
        ll_click_revenue = (LinearLayout) findViewById(R.id.ll_click_revenue);
        ll_click_setting = (LinearLayout) findViewById(R.id.ll_click_setting);
        ll_click_bid.setOnClickListener(this);
        ll_click_msg.setOnClickListener(this);
        ll_click_gps.setOnClickListener(this);
        ll_click_call.setOnClickListener(this);
        ll_click_revenue.setOnClickListener(this);
        ll_click_setting.setOnClickListener(this);
        tv_time = (TextView) findViewById(R.id.tv_time);
        findViewById(R.id.tv_icon).setOnClickListener(this);
        tv_taxi_status = (TextView) findViewById(R.id.tv_taxi_status);
        tv_taxi_status.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ll_click_bid :
                showToast("ll_click_bid");
                Intent CallingUPIntent = new Intent(this, CallingUpActivity.class);
                startActivity(CallingUPIntent);
                break;
            case R.id.ll_click_msg :
                showToast("ll_click_msg");
                Intent msgIntent = new Intent(this, MessageActivity.class);
                startActivity(msgIntent);
                break;
            case R.id.ll_click_gps :
                showToast("ll_click_gps");
                Intent gpsIntent = new Intent(this, NavigationActivity.class);
                startActivity(gpsIntent);
                break;
            case R.id.ll_click_call :
                Intent telIntent = new Intent(this, TelephoneActivity.class);
                startActivity(telIntent);
                showToast("ll_click_call");
                break;
            case R.id.ll_click_revenue :
                Intent ptoiIntent = new Intent(this, PTOIActivity.class);
                startActivity(ptoiIntent);
                showToast("ll_click_revenue");
                break;
            case R.id.ll_click_setting :
                showToast("ll_click_setting");
                break;
            case R.id.tv_icon :
                Intent driverIntent = new Intent(this,DriverInfoActivity.class);
                startActivity(driverIntent);
                showToast("tv_icon");
                break;
            case R.id.tv_taxi_status :
                if (tv_taxi_status.getText().toString().equals("空客")) {
                    tv_taxi_status.setBackgroundResource(R.drawable.car2);
                    tv_taxi_status.setText("载客");
                } else {
                    tv_taxi_status.setBackgroundResource(R.drawable.car1);
                    tv_taxi_status.setText("空客");
                    Intent taxiStatusIntent = new Intent(this, TaxiStatusActivity.class);
                    startActivity(taxiStatusIntent);
                }
                showToast("空格，载客");
                break;
        }
    }

    public void showToast(String content) {
        Toast.makeText(this,content,Toast.LENGTH_LONG).show();
    }

    public class TimeThread extends Thread {
        @Override
        public void run () {
            do {
                try {
                    Thread.sleep(1000);
                    Message msg = new Message();
                    msg.what = TITLE_TIME_REFRESH;
                    mHandler.sendMessage(msg);
                }
                catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } while(true);
        }
    }

    private Handler mHandler = new Handler() {
        @Override
        public void handleMessage (Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case TITLE_TIME_REFRESH:
                    long sysTime = System.currentTimeMillis();
//                    CharSequence sysTimeStr = DateFormat.format("yyyy-MM-dd hh:mm", sysTime);
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd  HH:mm:ss");
                    String sysTimeStr = sdf.format(new Date());
                    tv_time.setText(sysTimeStr);
                    break;
                default:
                    break;
            }
        }
    };
}
