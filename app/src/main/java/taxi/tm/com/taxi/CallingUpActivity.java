package taxi.tm.com.taxi;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import taxi.tm.com.adapter.BidMsgAdapter;
import taxi.tm.com.bean.BidMsgBean;

/**
 * Created by kgd on 2016/04/11.
 * kgd.zhen@gmail.com
 */
public class CallingUpActivity extends BaseActivity implements View.OnClickListener{

    public ListView lv_bid_msg;
    public BidMsgAdapter bidMsgAdapter;
    public List<BidMsgBean> bidMsgList = new ArrayList<>();

    public TextView tv_bid_back, tv_bid_up, tv_bid_down;

    public LinearLayout ll_bid_ignore, ll_bid_bid, ll_bid_order;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void initContentView(Bundle savedInstanceState) {
        setContentView(R.layout.activity_calling_up);
    }

    public void initView() {
        lv_bid_msg = (ListView) findViewById(R.id.lv_bid_msg);

        tv_bid_back = (TextView) findViewById(R.id.tv_bid_back);
        tv_bid_up = (TextView) findViewById(R.id.tv_bid_up);
        tv_bid_down = (TextView) findViewById(R.id.tv_bid_down);
        tv_bid_back.setOnClickListener(this);
        tv_bid_up.setOnClickListener(this);
        tv_bid_down.setOnClickListener(this);

        ll_bid_ignore = (LinearLayout)findViewById(R.id.ll_bid_ignore);
        ll_bid_bid = (LinearLayout)findViewById(R.id.ll_bid_bid);
        ll_bid_order = (LinearLayout)findViewById(R.id.ll_bid_order);
        ll_bid_ignore.setOnClickListener(this);
        ll_bid_bid.setOnClickListener(this);
        ll_bid_order.setOnClickListener(this);

        BidMsgBean bean = new BidMsgBean();
        bean.setCurrentPosition("大学科技园东区");
        bean.setDestination("总部企业基地2期");
        bean.setPeopleCount(2);
        bidMsgList.add(bean);

        BidMsgBean bean2 = new BidMsgBean();
        bean2.setCurrentPosition("电厂路五龙口北路");
        bean2.setDestination("总部企业基地2期");
        bean2.setPeopleCount(3);
        bidMsgList.add(bean2);

        BidMsgBean bean3 = new BidMsgBean();
        bean3.setCurrentPosition("东风路花园路");
        bean3.setDestination("莲花街红松路");
        bean3.setPeopleCount(1);
        bidMsgList.add(bean3);

        BidMsgBean bean4 = new BidMsgBean();
        bean4.setCurrentPosition("电厂北路");
        bean4.setDestination("河南工业大学");
        bean4.setPeopleCount(1);
        bidMsgList.add(bean4);

        BidMsgBean bean5 = new BidMsgBean();
        bean5.setCurrentPosition("通和盛世");
        bean5.setDestination("龙鼎企业中心");
        bean5.setPeopleCount(2);
        bidMsgList.add(bean5);

        BidMsgBean bean6 = new BidMsgBean();
        bean6.setCurrentPosition("郑州市动物园");
        bean6.setDestination("龙鼎企业中心，天迈科技");
        bean6.setPeopleCount(3);
        bidMsgList.add(bean6);



        if (bidMsgAdapter == null) {
            bidMsgAdapter = new BidMsgAdapter(this, bidMsgList);
            lv_bid_msg.setAdapter(bidMsgAdapter);
        }
        bidMsgAdapter.notifyDataSetChanged();

        lv_bid_msg.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                bidMsgAdapter.setSelection(position);
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_bid_back :
                this.finish();
                break;
            case R.id.tv_bid_up :
                showToast("上一页");
                break;
            case R.id.tv_bid_down :
                showToast("下一页");
                break;
            case R.id.ll_bid_ignore :
                showToast("忽略");
                break;
            case R.id.ll_bid_bid :
                showToast("抢标");
                break;
            case R.id.ll_bid_order :
                showToast("订单");
                Intent intent = new Intent(this, OrderInfoActivity.class);
                startActivity(intent);
                break;
        }
    }
}
