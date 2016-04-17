package taxi.tm.com.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

import taxi.tm.com.bean.BidMsgBean;
import taxi.tm.com.bean.MessageBean;
import taxi.tm.com.taxi.R;

/**
 * Created by kgd on 2016/04/11.
 * wuzhenzhen@tiamaes.com
 */
public class MessageAdapter extends BaseAdapter {

    private LayoutInflater mInflater;
    public Context mContext;
    public List<MessageBean> list ;
    public int clickPosition;
    public MessageAdapter(Context context, List<MessageBean> list) {
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
            convertView = mInflater.inflate(R.layout.item_list_message, null);
            holder.ll_list_msg = (LinearLayout)convertView.findViewById(R.id.ll_list_msg);
            holder.tv_phone = (TextView)convertView.findViewById(R.id.tv_phone);
            holder.tv_time = (TextView)convertView.findViewById(R.id.tv_time);
            holder.tv_msg = (TextView)convertView.findViewById(R.id.tv_msg);
            convertView.setTag(holder);
        } else {
            holder =  (ViewHolder) convertView.getTag();
        }
        MessageBean bean = list.get(position);
        holder.tv_phone.setText(bean.getPhone());
        holder.tv_time.setText(bean.getTime());
        holder.tv_msg.setText(bean.getMsg());
        if (clickPosition == position) {
            holder.ll_list_msg.setBackgroundResource(R.drawable.msg_list_press);
        } else {
            holder.ll_list_msg.setBackgroundResource(R.drawable.msg_list_normal);
        }
        return convertView;
    }

    private class ViewHolder {
        private LinearLayout ll_list_msg;
        private TextView tv_phone;	//号码
        private TextView tv_time;	//时间
        private TextView tv_msg;	//短信内容
    }
}
