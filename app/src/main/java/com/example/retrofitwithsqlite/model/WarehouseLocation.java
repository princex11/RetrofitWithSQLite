package com.example.retrofitwithsqlite.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class WarehouseLocation implements Parcelable {

    @SerializedName("latitude")
    @Expose
    private Double latitude;
    @SerializedName("longitude")
    @Expose
    private Double longitude;
    @SerializedName("address")
    @Expose
    private String address;

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(this.latitude);
        dest.writeValue(this.longitude);
        dest.writeString(this.address);
    }

    public WarehouseLocation() {
    }

    protected WarehouseLocation(Parcel in) {
        this.latitude = (Double) in.readValue(Double.class.getClassLoader());
        this.longitude = (Double) in.readValue(Double.class.getClassLoader());
        this.address = in.readString();
    }

    public static final Parcelable.Creator<WarehouseLocation> CREATOR = new Parcelable.Creator<WarehouseLocation>() {
        @Override
        public WarehouseLocation createFromParcel(Parcel source) {
            return new WarehouseLocation(source);
        }

        @Override
        public WarehouseLocation[] newArray(int size) {
            return new WarehouseLocation[size];
        }
    };
}