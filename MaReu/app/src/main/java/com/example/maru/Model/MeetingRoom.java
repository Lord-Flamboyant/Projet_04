package com.example.maru.Model;

import android.os.Parcel;
import android.os.Parcelable;

public class MeetingRoom implements Parcelable {

    private final long mId;
    private final String mNameRoom;
    private final long mSeat;
    private final int mImageCity;


    public MeetingRoom(long id, String nameRoom, long seatPlace, int imageCity) {
        mId = id;
        mNameRoom = nameRoom;
        mSeat = seatPlace;
        mImageCity = imageCity;
    };

    protected MeetingRoom(Parcel in) {
        mId = in.readLong();
        mNameRoom = in.readString();
        mSeat = in.readLong();
        mImageCity = in.readInt();
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

    public int getImageCity() {
        return mImageCity;
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
        dest.writeInt(mImageCity);
    }
}
