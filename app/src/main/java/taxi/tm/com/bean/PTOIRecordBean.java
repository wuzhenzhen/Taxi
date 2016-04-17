package taxi.tm.com.bean;

import java.io.Serializable;

/**
 * Created by kgd on 2016/04/13.
 * wuzhenzhen@tiamaes.com
 */
public class PTOIRecordBean implements Serializable {
    public String payWay;
    public String startTime;
    public String endTime;
    public String km;
    public String money;

    public String getPayWay() {
        return payWay;
    }

    public void setPayWay(String payWay) {
        this.payWay = payWay;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getKm() {
        return km;
    }

    public void setKm(String km) {
        this.km = km;
    }

    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money;
    }
}
