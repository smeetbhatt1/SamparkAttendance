package com.smeetbhatt.samparkattendance;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by smeetbhatt on 18/09/17.
 */

public class Attendance implements Parcelable{
    @SerializedName("attend_id")
    @Expose
    private String attendId;

    @SerializedName("sabha_id")
    @Expose
    private String sabhaId;

    @SerializedName("sabha_name")
    @Expose
    private String sabhaName;

    @SerializedName("present")
    @Expose
    private int totalAttendedMembers;

    @SerializedName("total")
    @Expose
    private int totalSabhaMembers;

    @SerializedName("sabha_date")
    @Expose
    private String sabhaDate;

    @SerializedName("percentage")
    @Expose
    private double percentage;

    @SerializedName("mandal_name")
    @Expose
    private String mandalName;

    public Attendance() {
    }

    protected Attendance(Parcel in) {
        this.attendId = in.readString();
        this.sabhaId = in.readString();
        this.sabhaName = in.readString();
        this.totalAttendedMembers = in.readInt();
        this.totalSabhaMembers = in.readInt();
        this.sabhaDate = in.readString();
        this.mandalName = in.readString();
    }

    public String getAttendanceDesc() {

        try {
            return new StringBuilder("Present: ")
                    .append(totalAttendedMembers)
                    .append(" / ")
                    .append(totalSabhaMembers)
                    .append(" (")
                    .append(percentage)
                    .append(" %)")
                    .toString();

            //return builder.toString();
        } catch (ArithmeticException e) {
            return "Pending";
        }
    }


    public String getAttendId() {
        return attendId;
    }

    public void setAttendId(String attendId) {
        this.attendId = attendId;
    }

    public String getSabhaId() {
        return sabhaId;
    }

    public void setSabhaId(String sabhaId) {
        this.sabhaId = sabhaId;
    }

    public String getSabhaName() {
        return sabhaName;
    }

    public void setSabhaName(String sabhaName) {
        this.sabhaName = sabhaName;
    }

    public int getTotalAttendedMembers() {
        return totalAttendedMembers;
    }

    public void setTotalAttendedMembers(int totalAttendedMembers) {
        this.totalAttendedMembers = totalAttendedMembers;
    }

    public int getTotalSabhaMembers() {
        return totalSabhaMembers;
    }

    public void setTotalSabhaMembers(int totalSabhaMembers) {
        this.totalSabhaMembers = totalSabhaMembers;
    }

    public String getSabhaDate() {
        return sabhaDate;
    }

    public void setSabhaDate(String sabhaDate) {
        this.sabhaDate = sabhaDate;
    }

    public double getPercentage() {
        return percentage;
    }

    public void setPercentage(double percentage) {
        this.percentage = percentage;
    }

    public String getMandalName() {
        return mandalName;
    }

    public void setMandalName(String mandalName) {
        this.mandalName = mandalName;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int i) {
        dest.writeString(this.attendId);
        dest.writeString(this.sabhaId);
        dest.writeString(this.sabhaName);
        dest.writeInt(this.totalAttendedMembers);
        dest.writeInt(this.totalSabhaMembers);
        dest.writeString(this.sabhaDate);
        dest.writeString(this.mandalName);

    }
    public static final Parcelable.Creator<Attendance> CREATOR = new Parcelable.Creator<Attendance>() {
        @Override
        public Attendance createFromParcel(Parcel source) {

            return new Attendance(source);
        }

        @Override
        public Attendance[] newArray(int size) {
            return new Attendance[size];
        }
    };
}
