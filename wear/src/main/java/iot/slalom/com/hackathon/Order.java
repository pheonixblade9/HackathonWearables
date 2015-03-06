package iot.slalom.com.hackathon;

import android.os.Parcel;
import android.os.Parcelable;

public class Order implements Parcelable {

    public String section;
    public String row;
    public String seat;
    public String category;
    public String item;
    public Integer quantity;

    public Order() {
    }

    protected Order(Parcel in) {
        section = in.readString();
        row = in.readString();
        seat = in.readString();
        category = in.readString();
        item = in.readString();
        quantity = in.readByte() == 0x00 ? null : in.readInt();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(section);
        dest.writeString(row);
        dest.writeString(seat);
        dest.writeString(category);
        dest.writeString(item);
        if (quantity == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeInt(quantity);
        }
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<Order> CREATOR = new Parcelable.Creator<Order>() {
        @Override
        public Order createFromParcel(Parcel in) {
            return new Order(in);
        }

        @Override
        public Order[] newArray(int size) {
            return new Order[size];
        }
    };

    @Override
    public String toString() {
        return "Section: " + this.section + "\n"
                + "Row: " + this.row + "\n"
                + "Seat: " + this.seat + "\n"
                + "Category: " + this.category + "\n"
                + "Item: " + this.item + "\n"
                + "Quantity:" + this.quantity;
    }
}