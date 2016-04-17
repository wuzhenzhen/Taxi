package taxi.tm.com.bean;

import java.io.Serializable;

/**
 * Created by kgd on 2016/04/13.
 * wuzhenzhen@tiamaes.com
 */
public class MessageBean implements Serializable {
    public String phone;
    public String msg;
    public String time;

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
