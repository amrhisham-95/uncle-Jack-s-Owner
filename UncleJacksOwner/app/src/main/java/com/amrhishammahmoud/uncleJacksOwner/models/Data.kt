package com.amrhishammahmoud.uncleJacksOwner.models

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.squareup.moshi.JsonClass
import kotlinx.android.parcel.Parcelize
import kotlinx.serialization.Serializable

//response
@JsonClass(generateAdapter = true)
@Serializable
@Parcelize
@Entity(tableName = "fruit_table")
data class Fruits(
    @PrimaryKey (autoGenerate = true) var id: Int,
    var Name: String,
    var Type:String,
    var Price : String,
    var Image : String
) : Parcelable

@JsonClass(generateAdapter = true)
@Serializable
@Parcelize
@Entity(tableName = "juice_table")
data class Juices(
    @PrimaryKey (autoGenerate = true) var id: Int,
    var Name: String,
    var Type:String,
    var Price : String,
    var Image : String
) : Parcelable

@JsonClass(generateAdapter = true)
@Serializable
@Parcelize
@Entity(tableName = "jacksMixes_table")
data class JacksMixes(
    @PrimaryKey (autoGenerate = true) var id: Int,
    var Name: String,
    var Type:String,
    var Price : String,
    var Image : String
) : Parcelable

@JsonClass(generateAdapter = true)
@Serializable
@Parcelize
@Entity(tableName = "services_table")
data class Services(
    @PrimaryKey (autoGenerate = true) var id: Int,
    var Service: String,
    var Delivery:String,
    var VAT : String
) : Parcelable

