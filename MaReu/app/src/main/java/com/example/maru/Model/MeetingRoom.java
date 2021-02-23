package com.example.maru.Model;

import android.os.Parcel;
import android.os.Parcelable;

public class MeetingRoom implements Parcelable {

    private final long mId;
    private final String mNameRoom;
    private final long mSeat;
    private final String mImageCity;
    private final String mHour;
    private final String mDay;

    public MeetingRoom(long id, String nameRoom, long seatPlace, String imageCity,String Hour,String Day) {
        mId = id;
        mNameRoom = nameRoom;
        mSeat = seatPlace;
        mImageCity = imageCity;
        mHour = Hour;
        mDay = Day;
    };

    protected MeetingRoom(Parcel in) {
        mId = in.readLong();
        mNameRoom = in.readString();
        mSeat = in.readLong();
        mImageCity = in.readString();
        mDay = in.readString();
        mHour = in.readString();
    }

    public static final Creator<MeetingRoom> CREATOR = new Creator<MeetingRoom>() {
        @Override
        public MeetingRoom createFromParcel(Parcel in) {
            return new MeetingRoom(in);
        }

        @Override
        public MeetingRoom[] newArray(int size) {
            return new MeetingRoom[size];
        }
    };


    public long getId() {
        return mId;
    }

    public String getNameRoom() {
        return mNameRoom;
    }

    public long getSeat() {
        return mSeat;
    }

    public String getImageCity() {
        return mImageCity;
    }

    public String getHour() {
        return mHour;
    }

    public  String getDay() {
        return mDay;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(mId);
        dest.writeString(mNameRoom);
        dest.writeLong(mSeat);
        dest.writeString(mImageCity);
        dest.writeString(mHour);
        dest.writeString(mDay);
    }
}
