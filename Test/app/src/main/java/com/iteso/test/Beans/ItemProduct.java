package com.iteso.test.Beans;

import android.os.Parcel;
import android.os.Parcelable;

public class ItemProduct implements Parcelable {
    private int image;

    private int code;
    private String title, store, location, phone, description;

    public ItemProduct(){
        image = 0;
        title = store = location = phone = description = "";
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getStore() {
        return store;
    }

    public void setStore(String store) {
        this.store = store;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ItemProduct{title='" + this.title);
        sb.append("', store='" + this.store + "',\n");
        sb.append("location='" + this.location);
        sb.append("', phone='" + this.phone + "',\n");
        sb.append("description='" + this.description + "' ");
        sb.append("image='" + this.image + "}");

        return sb.toString();
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.image);
        dest.writeInt(this.code);
        dest.writeString(this.title);
        dest.writeString(this.store);
        dest.writeString(this.location);
        dest.writeString(this.phone);
        dest.writeString(this.description);
    }

    protected ItemProduct(Parcel in) {
        this.image = in.readInt();
        this.code = in.readInt();
        this.title = in.readString();
        this.store = in.readString();
        this.location = in.readString();
        this.phone = in.readString();
        this.description = in.readString();
    }

    public static final Parcelable.Creator<ItemProduct> CREATOR = new Parcelable.Creator<ItemProduct>() {
        @Override
        public ItemProduct createFromParcel(Parcel source) {
            return new ItemProduct(source);
        }

        @Override
        public ItemProduct[] newArray(int size) {
            return new ItemProduct[size];
        }
    };
}
