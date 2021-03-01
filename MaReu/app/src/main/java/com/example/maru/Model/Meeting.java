package com.example.maru.Model;

import android.os.Parcel;
import android.os.Parcelable;

public class Meeting implements Parcelable {

    private final Long mIdMeeting;
    private final String mNameMeeting;
    private final String mHourMeeting;
    private final String mDay;
    private final String mListMail;
    private final String mSujetMeeting;
    private final String mLocalisation;
    private final int mImageCity;

    public Meeting(Long IdMeeting, String NameMetting, String HourMeeting, String Day, String ListMail, String SujetMeeting, String Localisation, int ImageCity) {
        mNameMeeting = NameMetting;
        mIdMeeting = IdMeeting;
        mHourMeeting = HourMeeting;
        mDay = Day;
        mListMail = ListMail;
        mSujetMeeting = SujetMeeting;
        mLocalisation = Localisation;
        mImageCity = ImageCity;
    }

    protected Meeting(Parcel in) {
        mNameMeeting = in.readString();
        mIdMeeting = in.readLong();
        mHourMeeting = in.readString();
        mDay = in.readString();
        mListMail = in.readString();
        mSujetMeeting = in.readString();
        mLocalisation = in.readString();
        mImageCity = in.readInt();
    }

    public static final Creator<Meeting> CREATOR = new Creator<Meeting>() {
        @Override
        public Meeting createFromParcel(Parcel in) {
            return new Meeting(in);
        }

        @Override
        public Meeting[] newArray(int size) {
            return new Meeting[size];
        }
    };

    public String getNameMeeting() {
        return mNameMeeting;
    }

    public long getIdMeeting() {
        return mIdMeeting;
    }

    public String getHourMeeting() {
        return mHourMeeting;
    }

    public String getDay() {
        return mDay;
    }

    public String getListMail() {
        return mListMail;
    }

    public String getSujetMeeting() {
        return mSujetMeeting;
    }

    public String getLocalisation() {
        return mLocalisation;
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
        dest.writeString(mNameMeeting);
        dest.writeLong(mIdMeeting);
        dest.writeString(mHourMeeting);
        dest.writeString(mDay);
        dest.writeString(mListMail);
        dest.writeString(mSujetMeeting);
        dest.writeString(mLocalisation);
        dest.writeInt(mImageCity);
    }
}
