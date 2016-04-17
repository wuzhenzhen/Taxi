package taxi.tm.com.taxi;

import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import taxi.tm.com.adapter.PTOIAdapter;
import taxi.tm.com.bean.PTOIRecordBean;

/**
 * Created by kgd on 2016/04/14.
 * wuzhenzhen@tiamaes.com
 * PTOI =  Pre-tax operating income 税前营业收入
 */
public class PTOIActivity extends BaseActivity implements View.OnClickListener {

    public TextView tv_title;
    public ListView lv_ptoi;
    public PTOIAdapter ptoiAdapter;
    public List<PTOIRecordBean> ptoiList = new ArrayList<PTOIRecordBean>();
    @Override
    protected void initContentView(Bundle savedInstanceState) {
        setContentView(R.layout.activity_ptoi);
    }

    @Override
    protected void initView() {
        tv_title = (TextView) findViewById(R.id.tv_title);
        tv_title.setText("营收");
        findViewById(R.id.tv_back).setOnClickListener(this);
        findViewById(R.id.tv_ptoi_up).setOnClickListener(this);
        findViewById(R.id.tv_ptoi_show).setOnClickListener(this);
        findViewById(R.id.tv_ptoi_down).setOnClickListener(this);
        findViewById(R.id.tv_ptoi_upload).setOnClickListener(this);
        lv_ptoi = (ListView) findViewById(R.id.lv_ptoi);

        PTOIRecordBean bean = new PTOIRecordBean();
        bean.setPayWay("1");
        bean.setStartTime("13:12");
        bean.setEndTime("13:35");
        bean.setKm("9.8km");
        bean.setMoney("¥21");
        ptoiList.add(bean);

        PTOIRecordBean bean1 = new PTOIRecordBean();
        bean1.setPayWay("1");
        bean1.setStartTime("13:50");
        bean1.setEndTime("14:35");
        bean1.setKm("11km");
        bean1.setMoney("¥26");
        ptoiList.add(bean1);

        PTOIRecordBean bean2 = new PTOIRecordBean();
        bean2.setPayWay("2");
        bean2.setStartTime("15:00");
        bean2.setEndTime("15:45");
        bean2.setKm("12km");
        bean2.setMoney("¥30");
        ptoiList.add(bean2);

        PTOIRecordBean bean3 = new PTOIRecordBean();
        bean3.setPayWay("3");
        bean3.setStartTime("15:55");
        bean3.setEndTime("16:25");
        bean3.setKm("13km");
        bean3.setMoney("¥35");
        ptoiList.add(bean3);

        PTOIRecordBean bean4 = new PTOIRecordBean();
        bean4.setPayWay("4");
        bean4.setStartTime("16:35");
        bean4.setEndTime("16:55");
        bean4.setKm("5km");
        bean4.setMoney("¥12");
        ptoiList.add(bean4);

        PTOIRecordBean bean5 = new PTOIRecordBean();
        bean5.setPayWay("5");
        bean5.setStartTime("17:25");
        bean5.setEndTime("17:55");
        bean5.setKm("15km");
        bean5.setMoney("¥42");
        ptoiList.add(bean5);

        if(ptoiAdapter == null) {
            ptoiAdapter = new PTOIAdapter(this,ptoiList);
            lv_ptoi.setAdapter(ptoiAdapter);
        }
        ptoiAdapter.notifyDataSetChanged();
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
