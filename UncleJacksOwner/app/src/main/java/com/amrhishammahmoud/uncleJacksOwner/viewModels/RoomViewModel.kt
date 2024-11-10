package com.amrhishammahmoud.uncleJacksOwner.viewModels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.amrhishammahmoud.uncleJacksOwner.models.BillFinal
import com.amrhishammahmoud.uncleJacksOwner.models.CartProductsFinal
import com.amrhishammahmoud.uncleJacksOwner.models.Fruits
import com.amrhishammahmoud.uncleJacksOwner.models.JacksMixes
import com.amrhishammahmoud.uncleJacksOwner.models.Juices
import com.amrhishammahmoud.uncleJacksOwner.models.Services
import com.amrhishammahmoud.uncleJacksOwner.repository.RoomRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class RoomViewModel @Inject constructor(
    private val repository: RoomRepository,
    val readAllDataFruits: LiveData<List<Fruits>>,
    val readAllDataJuices: LiveData<List<Juices>>,
    val readAllDataJacksMixes: LiveData<List<JacksMixes>>,
    val readAllDataServices: LiveData<List<Services>>,
    val mutibaleLiveDataFruits: MutableLiveData<List<Fruits>>,
    val mutibaleLiveDataJuices: MutableLiveData<List<Juices>>,
    val mutibaleLiveDataJacksMixes: MutableLiveData<List<JacksMixes>>,
    val mutibaleLiveDataServices: MutableLiveData<List<Services>>,
    val readAllDataFinal: LiveData<List<CartProductsFinal>>,
    val readAllDataBillFinal : LiveData<List<BillFinal>>,
    val mutibaleLiveDataFinalCart: MutableLiveData<List<CartProductsFinal>>,
    val mutibaleLiveDataBillFinal : MutableLiveData<List<BillFinal>>,
    application: Application
) : AndroidViewModel(application) {


    fun addFruitsDataViewModel(data: List<Fruits>) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.addDataFruits(data)
        }
    }


    //Fun to delete all fruits:
    fun deleteAllFruitsDetails() {
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteAllDataFruits()
        }
    }

    fun updateDataViewModelFruits(data: List<Fruits>) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.updateDataFruits(data)
        }
    }

    fun updateFruitsInServer(id : Int, fruits : Fruits ){
        viewModelScope.launch(Dispatchers.IO) {
            repository.updateFruitsDataById(id,fruits)
        }
    }

    fun postFruitsToServer(data: Fruits) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.addDataFruitsToServer(data)
        }
    }

    fun deleteItemsFruitsDataByIdFromKtorServer(id : Int){
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteDataFruitsByID(id)
        }
    }

    /**********************************************************************************************/


    fun addJuicesDataViewModel(data: List<Juices>) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.addDataJuices(data)
        }
    }


    //Fun to delete all fruits:
    fun deleteAllJuicesDetails() {
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteAllDataJuices()
        }
    }

    fun updateDataViewModelJuices(data: List<Juices>) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.updateDataJuices(data)
        }
    }


    fun updateJuicesInServer(id : Int, juices: Juices){
        viewModelScope.launch(Dispatchers.IO) {
            repository.updateJuicesDataById(id,juices)
        }
    }


    fun postJuicesToServer(data: Juices) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.addDataJuicesToServer(data)
        }
    }

    fun deleteItemsJuicesDataByIdFromKtorServer(id : Int){
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteDataJuicesByID(id)
        }
    }

    /**********************************************************************************************/

    fun addJacksMixesDataViewModel(data: List<JacksMixes>) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.addDataJacksMixes(data)
        }
    }


    //Fun to delete all fruits:
    fun deleteAllJacksMixesDetails() {
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteAllDataJacksMixes()
        }
    }

    fun updateDataViewModelJacksMixes(data: List<JacksMixes>) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.updateDataJacksMixes(data)
        }
    }


    fun updateJacksMixesInServer(id : Int, jacksMixes: JacksMixes){
        viewModelScope.launch(Dispatchers.IO) {
            repository.updateJacksMixesDataById(id,jacksMixes)
        }
    }


    fun postJacksMixesToServer(data: JacksMixes) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.addDataJacksMixesToServer(data)
        }
    }

    fun deleteItemsJacksMixesDataByIdFromKtorServer(id : Int){
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteDataJacksMixesByID(id)
        }
    }

    /**********************************************************************************************/

    fun addServicesDataViewModel(data: List<Services>) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.addDataServices(data)
        }
    }


    //Fun to delete all fruits:
    fun deleteAllServicesDetails() {
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteAllDataServices()
        }
    }

    fun updateDataViewModelServices(data: List<Services>) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.updateDataServices(data)
        }
    }

    fun updateServicesInServer(id : Int, services: Services){
        viewModelScope.launch(Dispatchers.IO) {
            repository.updateServicesDataById(id,services)
        }
    }

    /**********************************************************************************************/


    fun getDataRetrofitViewModelItems() {
        viewModelScope.launch(Dispatchers.IO) {
            withContext(Dispatchers.Main) {
                val x = repository.getCartProductsFinalFromApiRepository()
                mutibaleLiveDataFinalCart.postValue(x)
            }
        }
    }


    fun getAndPutDataFinalIntoDateBase(
        data: List<CartProductsFinal>
    ) {
        viewModelScope.launch(Dispatchers.IO) {
            withContext(Dispatchers.Main) {
                repository.getCartProductsFinalAndPutItIntoRoomDBByDao(
                    data
                )


            }
        }
    }

    fun deleteData() {
        viewModelScope.launch(Dispatchers.IO) {
            withContext(Dispatchers.Main) {
                repository.deleteAllDataFinal()
            }

        }
    }

    fun deleteItemsDataByPhoneFromKtorServer(phone : String){
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteByPhoneItems(phone)
        }
    }

    /**********************************************************************************************/

    fun addBillFinalDataViewModel(data: List<BillFinal>) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.addDataBillFinal(data)
        }
    }


    //Fun to delete all fruits:
    fun deleteAllBillFinalDetails() {
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteAllDataBillFinal()
        }
    }

    fun updateDataViewModelBillFinal(data: List<BillFinal>) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.updateDataBillFinal(data)
        }
    }


    fun getDataRetrofitViewModelBill() {
        viewModelScope.launch(Dispatchers.IO) {
            withContext(Dispatchers.Main) {
                val x = repository.getBillFinalFromApiRepository()
                mutibaleLiveDataBillFinal.postValue(x)
            }
        }
    }



    fun putBillFinalToRoomDatabase(data: List<BillFinal>) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.getBillFinalAndPutItIntoRoomDBByDao(data)
        }
    }

    fun deleteBillDataByPhoneFromKtorServer(phone : String){
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteByPhoneBill(phone)
        }
    }

}

