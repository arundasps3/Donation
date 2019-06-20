package com.example.donation;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;

@SuppressLint("ParcelCreator")
public class Donation implements Parcelable {

    private String method;
    private int amount;

    public Donation(String method, int amount) {


        this.method=method;
        this.amount=amount;
    }

    protected Donation(Parcel in) {

        method=in.readString();
        amount=in.readInt();
    }

    public static final Creator<Donation> CREATOR = new Creator<Donation>() {
        @Override
        public Donation createFromParcel(Parcel in) {
            return new Donation(in);
        }

        @Override
        public Donation[] newArray(int size) {
            return new Donation[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {

        parcel.writeString(method);
        parcel.writeInt(amount);

    }

    public String getMethod() { return method;
    }

    public int getAmount() {
        return amount;
    }
}
