package taxi.tm.com.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

import taxi.tm.com.bean.MessageBean;
import taxi.tm.com.bean.PTOIRecordBean;
import taxi.tm.com.taxi.R;

/**
 * Created by kgd on 2016/04/11.
 * wuzhenzhen@tiamaes.com
 */
public class PTOIAdapter extends BaseAdapter {

    private LayoutInflater mInflater;
    public Context mContext;
    public List<PTOIRecordBean> list ;
    public int clickPosition;
    public PTOIAdapter(Context context, List<PTOIRecordBean> list) {
        this.mContext = context;
        this.list = list;
        mInflater = LayoutInflater.from(context);
    }

    public void setSelection(int position) {
        clickPosition = position;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            holder = new ViewHolder();
            convertView = mInflater.inflate(R.layout.item_list_ptoi_record, null);
            holder.ll_list_ptoi = (LinearLayout)convertView.findViewById(R.id.ll_list_ptoi);
            holder.tv_payway = (TextView)convertView.findViewById(R.id.tv_payway);
            holder.tv_startTime = (TextView)convertView.findViewById(R.id.tv_startTime);
            holder.tv_endTime = (TextView)convertView.findViewById(R.id.tv_endTime);
            holder.tv_km = (TextView)convertView.findViewById(R.id.tv_km);
            holder.tv_money = (TextView)convertView.findViewById(R.id.tv_money);
            convertView.setTag(holder);
        } else {
            holder =  (ViewHolder) convertView.getTag();
        }
        PTOIRecordBean bean = list.get(position);
        if(bean.getPayWay().equals("2")) {
            holder.tv_payway.setBackgroundResource(R.drawable.ptoi_nfc);
        }else if (bean.getPayWay().equals("3")) {
            holder.tv_payway.setBackgroundResource(R.drawable.ptoi_wexi);
        }else if (bean.getPayWay().equals("4")) {
            holder.tv_payway.setBackgroundResource(R.drawable.ptoi_alipay);
        }else {
            holder.tv_payway.setBackgroundResource(R.drawable.ptoi_cash);
        }
//        holder.tv_payway.setText(bean.getPayWay());
        holder.tv_startTime.setText(bean.getStartTime());
        holder.tv_endTime.setText(bean.getEndTime());
        holder.tv_km.setText(bean.getKm());
        holder.tv_money.setText(bean.getMoney());
//        if (clickPosition == position) {
//            holder.ll_list_ptoi.setBackgroundResource(R.drawable.msg_list_press);
//        } else {
//            holder.ll_list_ptoi.setBackgroundResource(R.drawable.msg_list_normal);
//        }
        return convertView;
    }

    private class ViewHolder {
        private LinearLayout ll_list_ptoi; //
        private TextView tv_payway;	//支付方式
        private TextView tv_startTime;	//开始时间
        private TextView tv_endTime;	//结束时间
        private TextView tv_km; //运行公里
        private TextView tv_money; //金额
    }
}
