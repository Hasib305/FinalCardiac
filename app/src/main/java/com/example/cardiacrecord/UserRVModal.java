package com.example.cardiacrecord;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

/**
 * The UserRVModal class represents a user's record displayed in the RecyclerView.
 * It implements the Parcelable interface to enable passing data between activities.
 */
public class UserRVModal implements Parcelable {
    private String userName;
    private String userDesc;
    private String usersys;
    private String userdio;
    private String userheart;
    private String userId;
    private String userdate;
    private String usertime;

    /**
     * Default constructor for the UserRVModal class.
     */
    public UserRVModal() {
    }

    protected UserRVModal(Parcel in) {
        userName = in.readString();
        userDesc = in.readString();
        usersys = in.readString();
        userdio = in.readString();
        userheart = in.readString();
        userId = in.readString();
        userdate = in.readString();
        usertime = in.readString();
    }

    public static final Creator<UserRVModal> CREATOR = new Creator<UserRVModal>() {
        @Override
        public UserRVModal createFromParcel(Parcel in) {
            return new UserRVModal(in);
        }

        @Override
        public UserRVModal[] newArray(int size) {
            return new UserRVModal[size];
        }
    };

    /**
     * Retrieves the user's name.
     *
     * @return The user's name.
     */
    public String getUserName() {
        return userName;
    }

    /**
     * Sets the user's name.
     *
     * @param userName The user's name to set.
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * Retrieves the user's description.
     *
     * @return The user's description.
     */
    public String getUserDesc() {
        return userDesc;
    }

    /**
     * Sets the user's description.
     *
     * @param userDesc The user's description to set.
     */
    public void setUserDesc(String userDesc) {
        this.userDesc = userDesc;
    }

    /**
     * Retrieves the user's systolic pressure.
     *
     * @return The user's systolic pressure.
     */
    public String getUsersys() {
        return usersys;
    }

    /**
     * Sets the user's systolic pressure.
     *
     * @param usersys The user's systolic pressure to set.
     */
    public void setUsersys(String usersys) {
        this.usersys = usersys;
    }

    /**
     * Retrieves the user's diastolic pressure.
     *
     * @return The user's diastolic pressure.
     */
    public String getUserdio() {
        return userdio;
    }

    /**
     * Sets the user's diastolic pressure.
     *
     * @param userdio The user's diastolic pressure to set.
     */
    public void setUserdio(String userdio) {
        this.userdio = userdio;
    }

    /**
     * Retrieves the user's heart rate.
     *
     * @return The user's heart rate.
     */
    public String getUserheart() {
        return userheart;
    }

    /**
     * Sets the user's heart rate.
     *
     * @param userheart The user's heart rate to set.
     */
    public void setUserheart(String userheart) {
        this.userheart = userheart;
    }

    /**
     * Retrieves the user's ID.
     *
     * @return The user's ID.
     */
    public String getUserId() {
        return userId;
    }

    /**
     * Sets the user's ID.
     *
     * @param userId The user's ID to set.
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }

    /**
     * Retrieves the user's date.
     *
     * @return The user's date.
     */
    public String getUserdate() {
        return userdate;
    }

    /**
     * Sets the user's date.
     *
     * @param userdate The user's date to set.
     */
    public void setUserdate(String userdate) {
        this.userdate = userdate;
    }

    /**
     * Retrieves the user's time.
     *
     * @return The user's time.
     */
    public String getUsertime() {
        return usertime;
    }

    /**
     * Sets the user's time.
     *
     * @param usertime The user's time to set.
     */
    public void setUsertime(String usertime) {
        this.usertime = usertime;
    }

    /**
     * Constructor for the UserRVModal class.
     *
     * @param userName  The user's name.
     * @param userDesc  The user's description.
     * @param usersys   The user's systolic pressure.
     * @param userdio   The user's diastolic pressure.
     * @param userheart The user's heart rate.
     * @param userId    The user's ID.
     * @param userdate  The user's date.
     * @param usertime  The user's time.
     */
    public UserRVModal(String userName, String userDesc, String usersys, String userdio, String userheart, String userId, String userdate, String usertime) {
        this.userName = userName;
        this.userDesc = userDesc;
        this.usersys = usersys;
        this.userdio = userdio;
        this.userheart = userheart;
        this.userId = userId;
        this.userdate = userdate;
        this.usertime = usertime;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel dest, int flags) {
        dest.writeString(userName);
        dest.writeString(userDesc);
        dest.writeString(usersys);
        dest.writeString(userdio);
        dest.writeString(userheart);
        dest.writeString(userId);
        dest.writeString(userdate);
        dest.writeString(usertime);
    }

    /**
     * Compares the current UserRVModal object with another UserRVModal object based on usertime.
     *
     * @param measurement The UserRVModal object to compare.
     * @return The comparison result.
     */
    public int compareTo(UserRVModal measurement) {
        return this.usertime.compareTo(measurement.getUsertime());
    }
}
