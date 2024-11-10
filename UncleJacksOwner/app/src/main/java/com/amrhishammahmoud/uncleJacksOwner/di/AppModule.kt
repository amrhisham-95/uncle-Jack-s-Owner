package com.amrhishammahmoud.uncleJacksOwner.di

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.room.Room
import com.amrhishammahmoud.uncleJacksOwner.roomDatabase.*
import com.amrhishammahmoud.uncleJacksOwner.models.BillFinal
import com.amrhishammahmoud.uncleJacksOwner.models.CartProductsFinal
import com.amrhishammahmoud.uncleJacksOwner.models.Fruits
import com.amrhishammahmoud.uncleJacksOwner.models.JacksMixes
import com.amrhishammahmoud.uncleJacksOwner.models.Juices
import com.amrhishammahmoud.uncleJacksOwner.models.Services
import com.amrhishammahmoud.uncleJacksOwner.roomDatabase.DaoBillFinal
import com.amrhishammahmoud.uncleJacksOwner.roomDatabase.DaoFinalBuy
import com.amrhishammahmoud.uncleJacksOwner.roomDatabase.RoomDatabaseFinal
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton




@Module
@InstallIn(SingletonComponent::class)
object AppModule {


    @Provides
    @Singleton
    fun provideMutableLiveDataFruits() = MutableLiveData<List<Fruits>>()

    @Provides
    @Singleton
    fun provideLiveDataVariableFruits(appDB: RoomDatabaseClassFruits): LiveData<List<Fruits>> =
        appDB.dataDao().readAllDataFruits()

    @Provides
    @Singleton
    fun provideGetDaoFruits(appDB: RoomDatabaseClassFruits): DaoFruit {
        return appDB.dataDao()
    }

    @Provides
    @Singleton
    fun provideRoomDatabaseFruits(
        @ApplicationContext context: Context
    ) = Room.databaseBuilder(
        context, RoomDatabaseClassFruits::class.java, "fruit_table"
    ).build()


    /****************************************************************************/

    @Provides
    @Singleton
    fun provideMutableLiveDataJuices() = MutableLiveData<List<Juices>>()

    @Provides
    @Singleton
    fun provideLiveDataVariableJuices(appDB: RoomDatabaseClassJuices): LiveData<List<Juices>> =
        appDB.dataDao().readAllDataJuices()

    @Provides
    @Singleton
    fun provideGetDaoJuices(appDB: RoomDatabaseClassJuices): DaoJuice {
        return appDB.dataDao()
    }

    @Provides
    @Singleton
    fun provideRoomDatabaseJuices(
        @ApplicationContext context: Context
    ) = Room.databaseBuilder(
        context, RoomDatabaseClassJuices::class.java, "juice_table"
    ).build()

    /****************************************************************************/

    @Provides
    @Singleton
    fun provideMutableLiveDataJacksMixes() = MutableLiveData<List<JacksMixes>>()

    @Provides
    @Singleton
    fun provideLiveDataVariableJacksMixes(appDB: RoomDatabaseClassJacksMixes): LiveData<List<JacksMixes>> =
        appDB.dataDao().readAllDataJacksMixes()

    @Provides
    @Singleton
    fun provideGetDaoJacksMixes(appDB: RoomDatabaseClassJacksMixes): DaoJacksMixes {
        return appDB.dataDao()
    }

    @Provides
    @Singleton
    fun provideRoomDatabaseJacksMixes(
        @ApplicationContext context: Context
    ) = Room.databaseBuilder(
        context, RoomDatabaseClassJacksMixes::class.java, "jacksMixes_table"
    ).build()

    /****************************************************************************/

    @Provides
    @Singleton
    fun provideMutableLiveDataServices() = MutableLiveData<List<Services>>()

    @Provides
    @Singleton
    fun provideLiveDataVariableServices(appDB: RoomDatabaseClassServices): LiveData<List<Services>> =
        appDB.dataDao().readAllDataServices()

    @Provides
    @Singleton
    fun provideGetDaoServices(appDB: RoomDatabaseClassServices): DaoServices {
        return appDB.dataDao()
    }

    @Provides
    @Singleton
    fun provideRoomDatabaseServices(
        @ApplicationContext context: Context
    ) = Room.databaseBuilder(
        context, RoomDatabaseClassServices::class.java, "services_table"
    ).build()

    /****************************************************************************/



    @Provides
    @Singleton
    fun provideLiveDataVariableFinal(appDB: RoomDatabaseFinal): LiveData<List<CartProductsFinal>> =
        appDB.dataDao().readAllDataFinal()

    @Provides
    @Singleton
    fun provideGetDaoFinal(appDB: RoomDatabaseFinal): DaoFinalBuy {
        return appDB.dataDao()
    }

    @Provides
    @Singleton
    fun provideRoomDatabaseFinal(
        @ApplicationContext context: Context
    ) = Room.databaseBuilder(
        context, RoomDatabaseFinal::class.java, "final_table"
    ).build()

    /****************************************************************************/

    @Provides
    @Singleton
    fun provideMutableLiveDataFinalCart() = MutableLiveData<List<CartProductsFinal>>()


    /******************************************************************************/

    @Provides
    @Singleton
    fun provideLiveDataVariableBillFinal(appDB: billFinalDatabase): LiveData<List<BillFinal>> =
        appDB.dataDao().readAllDataBillFinal()

    @Provides
    @Singleton
    fun provideGetDaoBillFinal(appDB: billFinalDatabase): DaoBillFinal {
        return appDB.dataDao()
    }

    @Provides
    @Singleton
    fun provideRoomDatabaseBillFinal(
        @ApplicationContext context: Context
    ) = Room.databaseBuilder(
        context, billFinalDatabase::class.java, "billFinal_table"
    ).build()

    @Provides
    @Singleton
    fun provideMutableLiveDataBillFinal() = MutableLiveData<List<BillFinal>>()


}




