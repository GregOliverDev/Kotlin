package com.example.dedmobile.models.character

import com.example.dedmobile.models.Topic
import java.io.Serializable

import android.os.Parcel
import android.os.Parcelable

data class Attribute(
    var nameAttribute: String,
    var valueAttribute: Int
) : Parcelable {

    var valueAt: Int
        get() = this.valueAttribute
        set(value) {
            this.valueAttribute = value
        }

    fun copy(): Attribute {
        return Attribute(nameAttribute, valueAt)
    }

    private constructor(parcel: Parcel) : this(
        parcel.readString() ?: "",
        parcel.readInt()
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(nameAttribute)
        parcel.writeInt(valueAttribute)
    }
    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Attribute> {
        override fun createFromParcel(parcel: Parcel): Attribute {
            return Attribute(parcel)
        }

        override fun newArray(size: Int): Array<Attribute?> {
            return arrayOfNulls(size)
        }
    }
}
