package com.amrhishammahmoud.uncleJacksOwner.models

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize
import kotlinx.serialization.Serializable

@Serializable
@Parcelize
@Entity(tableName = "bill_final_table")
data class BillFinal(
    var id: Int,
    var namePerson : String,
    var phoneNumber : String,
    var emailPerson : String,
    var totalPrice: String,
    var deliveryFee:String,
    var serviceFee : String,
    var vat : String,
    var totalFinalPrice:String,
    var longitude : String,
    var latitude : String,
    @PrimaryKey var timeDate : String
) : Parcelable