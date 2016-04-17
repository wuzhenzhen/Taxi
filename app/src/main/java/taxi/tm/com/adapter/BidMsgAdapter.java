package taxi.tm.com.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

import taxi.tm.com.bean.BidMsgBean;
import taxi.tm.com.taxi.R;

/**
 * Created by kgd on 2016/04/11.
 * wuzhenzhen@tiamaes.com
 */
public class BidMsgAdapter extends BaseAdapter {

    private LayoutInflater mInflater;
    public Context mContext;
    public List<BidMsgBean> list ;
    public int clickPosition;
    public BidMsgAdapter(Context context, List<BidMsgBean> list) {
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
            convertView = mInflater.inflate(R.layout.item_list_bid_msg, null);
            holder.ll_list_bid_msg = (LinearLayout)convertView.findViewById(R.id.ll_list_bid_msg);
            holder.tv_currentPosition = (TextView)convertView.findViewById(R.id.tv_currentPosition);
            holder.tv_destination = (TextView)convertView.findViewById(R.id.tv_destination);
            holder.tv_peopleCount = (TextView)convertView.findViewById(R.id.tv_peopleCount);
            convertView.setTag(holder);
        } else {
            holder =  (ViewHolder) convertView.getTag();
        }
        BidMsgBean bean = list.get(position);
        holder.tv_currentPosition.setText(bean.getCurrentPosition());
        holder.tv_destination.setText(bean.getDestination());
        holder.tv_peopleCount.setText(String.valueOf(bean.getPeopleCount()));
        if (clickPosition == position) {
            holder.ll_list_bid_msg.setBackgroundResource(R.drawable.bid_list_press);
        } else {
            holder.ll_list_bid_msg.setBackgroundResource(R.drawable.bid_list_normal);
        }
        return convertView;
    }

    private class ViewHolder {
        private LinearLayout ll_list_bid_msg;
        private TextView tv_currentPosition;	//当前位置
        private TextView tv_destination;	//目的地
        private TextView tv_peopleCount;	//人数
    }
}
