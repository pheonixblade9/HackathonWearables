package iot.slalom.com.hackathon;

/**
 * Created by fernandog on 3/6/2015.
 */
public class OrderPOJO {
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getSeatid() {
        return seatid;
    }

    public void setSeatid(String seatid) {
        this.seatid = seatid;
    }

    private String type;
    private String item;
    private String quantity;
    private String seatid;
}
