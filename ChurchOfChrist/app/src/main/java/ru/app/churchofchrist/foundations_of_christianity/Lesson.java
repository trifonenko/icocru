package ru.app.churchofchrist.foundations_of_christianity;

import android.os.Parcel;
import android.os.Parcelable;

import lombok.Getter;

@Getter
class Lesson implements Parcelable {
    private String title;
    private String lessonText;

    Lesson(String title, String lessonText) {
        this.title = title;
        this.lessonText = lessonText;
    }

    protected Lesson(Parcel in) {
        title = in.readString();
        lessonText = in.readString();
    }

    public static final Creator<Lesson> CREATOR = new Creator<Lesson>() {
        @Override
        public Lesson createFromParcel(Parcel in) {
            return new Lesson(in);
        }

        @Override
        public Lesson[] newArray(int size) {
            return new Lesson[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(title);
        dest.writeString(lessonText);
    }
}