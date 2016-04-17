package taxi.tm.com.taxi;

import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import taxi.tm.com.adapter.MessageAdapter;
import taxi.tm.com.bean.MessageBean;

/**
 * Created by kgd on 2016/04/13.
 * wuzhenzhen@tiamaes.com
 */
public class MessageActivity extends BaseActivity implements View.OnClickListener {

    public ListView lv_list_msg;
    MessageAdapter msgAdapter;
    List<MessageBean> msgList = new ArrayList<MessageBean>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void initContentView(Bundle savedInstanceState) {
        setContentView(R.layout.activity_msg_info);
    }

    public void initView() {
        lv_list_msg = (ListView) findViewById(R.id.lv_list_msg);

        findViewById(R.id.tv_msg_up).setOnClickListener(this);
        findViewById(R.id.tv_msg_down).setOnClickListener(this);
        findViewById(R.id.tv_msg_show).setOnClickListener(this);
        findViewById(R.id.tv_msg_back).setOnClickListener(this);

        MessageBean bean1 = new MessageBean();
        bean1.setPhone("15837123452");
        bean1.setMsg("位置：国际会展中心CBD目的地：莲华街红松路龙鼎工业中心");
        bean1.setTime("4月8日");
        msgList.add(bean1);

        MessageBean bean2 = new MessageBean();
        bean2.setPhone("18037507761");
        bean2.setMsg("位置：花园路农科路CBD目的地：莲华街红松路龙鼎工业中心");
        bean2.setTime("4月8日");
        msgList.add(bean2);

        MessageBean bean3 = new MessageBean();
        bean3.setPhone("15837123452");
        bean3.setMsg("位置：郑州市动物园目的地：莲华街红松路圣世嘉业10号楼");
        bean3.setTime("4月8日");
        msgList.add(bean3);

        MessageBean bean4 = new MessageBean();
        bean4.setPhone("15837123452");
        bean4.setMsg("位置：莲华街红松路圣世嘉业10号楼目的地：电厂北路");
        bean4.setTime("4月8日");
        msgList.add(bean4);

        MessageBean bean5 = new MessageBean();
        bean5.setPhone("15837123452");
        bean5.setMsg("位置：国际会展中心CBD目的地：莲华街红松路龙鼎工业中心");
        bean5.setTime("4月8日");
        msgList.add(bean5);

        if(msgAdapter == null) {
            msgAdapter = new MessageAdapter(this, msgList);
            lv_list_msg.setAdapter(msgAdapter);
        }
        msgAdapter.notifyDataSetChanged();
        lv_list_msg.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                msgAdapter.setSelection(position);
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_msg_back :
                this.finish();
                break;
        }
    }
}
