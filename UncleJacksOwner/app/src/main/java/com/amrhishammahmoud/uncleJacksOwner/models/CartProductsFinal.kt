package com.amrhishammahmoud.uncleJacksOwner.models

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize
import kotlinx.serialization.Serializable

@Serializable
@Parcelize
@Entity(tableName = "final_table")
data class CartProductsFinal(
    @Serializable
    var itemPicFinal: String,
    @Serializable
    var itemNameFinal: String,
    @Serializable
    @PrimaryKey var itemPriceFinal:String,
    @Serializable
    var itemTypeFinal :String,
    @Serializable
    var itemQuantityFinal :String,
    @Serializable
    var timeDate: String,
    @Serializable
    var namePerson: String,
    @Serializable
    var telephonePerson:String,
    @Serializable
    var emailPerson:String
) : Parcelable