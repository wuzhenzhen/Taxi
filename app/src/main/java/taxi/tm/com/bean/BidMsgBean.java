package taxi.tm.com.bean;

import java.io.Serializable;

/**
 * Created by kgd on 2016/04/11.
 * wuzhenzhen@tiamaes.com
 */
public class BidMsgBean implements Serializable{
    public String currentPosition;
    public String destination;
    public int peopleCount = 1;

    public String getCurrentPosition() {
        return currentPosition;
    }

    public void setCurrentPosition(String currentPosition) {
        this.currentPosition = currentPosition;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public int getPeopleCount() {
        return peopleCount;
    }

    public void setPeopleCount(int peopleCount) {
        this.peopleCount = peopleCount;
    }
}
