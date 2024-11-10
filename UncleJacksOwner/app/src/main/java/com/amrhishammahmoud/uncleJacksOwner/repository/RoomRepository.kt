package com.amrhishammahmoud.uncleJacksOwner.repository

import androidx.lifecycle.LiveData
import com.amrhishammahmoud.uncleJacksOwner.models.BillFinal
import com.amrhishammahmoud.uncleJacksOwner.models.CartProductsFinal
import com.amrhishammahmoud.uncleJacksOwner.models.Fruits
import com.amrhishammahmoud.uncleJacksOwner.models.JacksMixes
import com.amrhishammahmoud.uncleJacksOwner.models.Juices
import com.amrhishammahmoud.uncleJacksOwner.models.KtorClient
import com.amrhishammahmoud.uncleJacksOwner.models.Services
import com.amrhishammahmoud.uncleJacksOwner.roomDatabase.DaoBillFinal
import com.amrhishammahmoud.uncleJacksOwner.roomDatabase.DaoFinalBuy
import com.amrhishammahmoud.uncleJacksOwner.roomDatabase.DaoFruit
import com.amrhishammahmoud.uncleJacksOwner.roomDatabase.DaoJacksMixes
import com.amrhishammahmoud.uncleJacksOwner.roomDatabase.DaoJuice
import com.amrhishammahmoud.uncleJacksOwner.roomDatabase.DaoServices
import io.ktor.client.call.body
import io.ktor.client.request.delete
import io.ktor.client.request.get
import io.ktor.client.request.post
import io.ktor.client.request.put
import io.ktor.client.request.setBody
import io.ktor.client.request.url
import io.ktor.client.statement.HttpResponse
import io.ktor.http.ContentType
import io.ktor.http.contentType
import io.ktor.util.InternalAPI
import javax.inject.Inject


class RoomRepository @Inject constructor(
    private val dataDaoFruits: DaoFruit,
    private val dataDaoJuices: DaoJuice,
    private val dataDaoJacksMixes: DaoJacksMixes,
    private val dataDaoServices: DaoServices,
    private val dataDaoFinal: DaoFinalBuy,
    private val dataDaoBillFinal: DaoBillFinal
) {


    val readAllDataFruits: LiveData<List<Fruits>> = dataDaoFruits.readAllDataFruits()

    //suspend fun To add data and use it in view model scope in (Main view model):
    suspend fun addDataFruits(data: List<Fruits>) {
        dataDaoFruits.addDataFruits(data)
    }

    //suspend fun To update data and use it in view model scope in (Main view model):
    suspend fun updateDataFruits(data: List<Fruits>) {
        dataDaoFruits.updateADataFruits(data)
    }

    //suspend fun To delete data and use it in view model scope in (Main view model):
    suspend fun deleteDataFruits(data: List<Fruits>) {
        dataDaoFruits.deleteDataFruits(data)
    }

    //suspend fun To delete all data and use it in view model scope in (Main view model):
    suspend fun deleteAllDataFruits() {
        dataDaoFruits.deleteAllDataFruits()
    }


    //update data in ktor server
    @OptIn(InternalAPI::class)
    suspend fun updateFruitsDataById(id : Int, fruits : Fruits ) : HttpResponse = KtorClient.httpClient.put {
        url ("http://192.168.1.192:8100/fruits/$id")
        contentType(ContentType.Application.Json)
        body = fruits
    }


    suspend fun addDataFruitsToServer(fruits : Fruits) {
        KtorClient.httpClient.post("http://192.168.1.192:8100/fruits") {
            contentType(ContentType.Application.Json)
            setBody(fruits)
        }
    }


    suspend fun deleteDataFruitsByID(id: Int): HttpResponse =
        KtorClient.httpClient.delete{
            url("http://192.168.1.192:8100/fruits/$id")
            contentType(ContentType.Application.Json)
        }

    /*********************************************************************************************/


    val readAllDataJuices: LiveData<List<Juices>> = dataDaoJuices.readAllDataJuices()

    //suspend fun To add data and use it in view model scope in (Main view model):
    suspend fun addDataJuices(data: List<Juices>) {
        dataDaoJuices.addDataJuices(data)
    }

    //suspend fun To update data and use it in view model scope in (Main view model):
    suspend fun updateDataJuices(data: List<Juices>) {
        dataDaoJuices.updateDataJuices(data)
    }

    //suspend fun To delete data and use it in view model scope in (Main view model):
    suspend fun deleteDataJuices(data: List<Juices>) {
        dataDaoJuices.deleteDataJuices(data)
    }

    //suspend fun To delete all data and use it in view model scope in (Main view model):
    suspend fun deleteAllDataJuices() {
        dataDaoJuices.deleteAllDataJuices()
    }

    //update data in ktor server
    @OptIn(InternalAPI::class)
    suspend fun updateJuicesDataById(id : Int, juices : Juices ) : HttpResponse = KtorClient.httpClient.put {
        url ("http://192.168.1.192:8100/juices/$id")
        contentType(ContentType.Application.Json)
        body = juices
    }


    suspend fun addDataJuicesToServer(juices : Juices) {
        KtorClient.httpClient.post("http://192.168.1.192:8100/juices") {
            contentType(ContentType.Application.Json)
            setBody(juices)
        }
    }

    suspend fun deleteDataJuicesByID(id: Int): HttpResponse =
        KtorClient.httpClient.delete{
            url("http://192.168.1.192:8100/juices/$id")
            contentType(ContentType.Application.Json)
        }

    /*****************************************************************************/

    val readAllDataJacksMixes: LiveData<List<JacksMixes>> =
        dataDaoJacksMixes.readAllDataJacksMixes()

    //suspend fun To add data and use it in view model scope in (Main view model):
    suspend fun addDataJacksMixes(data: List<JacksMixes>) {
        dataDaoJacksMixes.addDataJacksMixes(data)
    }

    //suspend fun To update data and use it in view model scope in (Main view model):
    suspend fun updateDataJacksMixes(data: List<JacksMixes>) {
        dataDaoJacksMixes.updateDataJacksMixes(data)
    }

    //suspend fun To delete data and use it in view model scope in (Main view model):
    suspend fun deleteDataJacksMixes(data: List<JacksMixes>) {
        dataDaoJacksMixes.deleteDataJacksMixes(data)
    }

    //suspend fun To delete all data and use it in view model scope in (Main view model):
    suspend fun deleteAllDataJacksMixes() {
        dataDaoJacksMixes.deleteAllDataJacksMixes()
    }

    //update data in ktor server
    @OptIn(InternalAPI::class)
    suspend fun updateJacksMixesDataById(id : Int, jacksMixes : JacksMixes ) : HttpResponse = KtorClient.httpClient.put {
        url ("http://192.168.1.192:8100/jacksMixes/$id")
        contentType(ContentType.Application.Json)
        body = jacksMixes
    }


    suspend fun addDataJacksMixesToServer(jacksMixes : JacksMixes) {
        KtorClient.httpClient.post("http://192.168.1.192:8100/jacksMixes") {
            contentType(ContentType.Application.Json)
            setBody(jacksMixes)
        }
    }

    suspend fun deleteDataJacksMixesByID(id: Int): HttpResponse =
        KtorClient.httpClient.delete{
            url("http://192.168.1.192:8100/jacksMixes/$id")
            contentType(ContentType.Application.Json)
        }

    /*****************************************************************************/

    val readAllDataServices: LiveData<List<Services>> = dataDaoServices.readAllDataServices()

    //suspend fun To add data and use it in view model scope in (Main view model):
    suspend fun addDataServices(data: List<Services>) {
        dataDaoServices.addDataServices(data)
    }

    //suspend fun To update data and use it in view model scope in (Main view model):
    suspend fun updateDataServices(data: List<Services>) {
        dataDaoServices.updateDataServices(data)
    }

    //suspend fun To delete data and use it in view model scope in (Main view model):
    suspend fun deleteDataServices(data: List<Services>) {
        dataDaoServices.deleteDataServices(data)
    }

    //suspend fun To delete all data and use it in view model scope in (Main view model):
    suspend fun deleteAllDataServices() {
        dataDaoServices.deleteAllDataServices()
    }

    //update data in ktor server
    @OptIn(InternalAPI::class)
    suspend fun updateServicesDataById(id : Int, services : Services ) : HttpResponse = KtorClient.httpClient.put {
        url ("http://192.168.1.192:8100/services/$id")
        contentType(ContentType.Application.Json)
        body = services
    }

    /*****************************************************************************/


    val readAllDataFinal: LiveData<List<CartProductsFinal>> = dataDaoFinal.readAllDataFinal()

    //suspend fun To add data and use it in view model scope in (Main view model):
    suspend fun addDataFinal(data: List<CartProductsFinal>) {
        dataDaoFinal.addDataFinal(data)
    }

    //suspend fun To update data and use it in view model scope in (Main view model):
    suspend fun updateDataFinal(data: List<CartProductsFinal>) {
        dataDaoFinal.updateDataFinal(data)
    }

    //suspend fun To delete data and use it in view model scope in (Main view model):
    suspend fun deleteDataFinal(data: List<CartProductsFinal>) {
        dataDaoFinal.deleteDataFinal(data)
    }

    //suspend fun To delete all data and use it in view model scope in (Main view model):
    suspend fun deleteAllDataFinal() {
        dataDaoFinal.deleteAllDataFinal()
    }

    //for get the data directly from the service without put it into room database
    suspend fun getCartProductsFinalFromApiRepository(): List<CartProductsFinal> =
        KtorClient.httpClient.get("http://192.168.1.192:8100/cartFinal").body()


    //to parse and insert fruit data to database by dao (with room data base)
    suspend fun getCartProductsFinalAndPutItIntoRoomDBByDao(data: List<CartProductsFinal>) {
        dataDaoFinal.addDataFinal(data)
    }

    suspend fun deleteByPhoneItems(phone: String): HttpResponse =
        KtorClient.httpClient.delete{
            url("http://192.168.1.192:8100/cartFinal/$phone")
            contentType(ContentType.Application.Json)
        }


    /*******************************************************************************/


    val readAllDataBillFinal: LiveData<List<BillFinal>> = dataDaoBillFinal.readAllDataBillFinal()

    //suspend fun To add data and use it in view model scope in (Main view model):
    suspend fun addDataBillFinal(data: List<BillFinal>) {
        dataDaoBillFinal.addDataBillFinal(data)
    }

    //suspend fun To update data and use it in view model scope in (Main view model):
    suspend fun updateDataBillFinal(data: List<BillFinal>) {
        dataDaoBillFinal.updateADataBillFinal(data)
    }

    //suspend fun To delete data and use it in view model scope in (Main view model):
    suspend fun deleteDataBillFinal(data: List<BillFinal>) {
        dataDaoBillFinal.deleteDataBillFinal(data)
    }

    //suspend fun To delete all data and use it in view model scope in (Main view model):
    suspend fun deleteAllDataBillFinal() {
        dataDaoBillFinal.deleteAllDataBillFinal()
    }

    //for get the data directly from the service without put it into room database
    suspend fun getBillFinalFromApiRepository(): List<BillFinal> =
        KtorClient.httpClient.get("http://192.168.1.192:8100/billFinal").body()


    //to parse and insert fruit data to database by dao (with room data base)
    suspend fun getBillFinalAndPutItIntoRoomDBByDao(data: List<BillFinal>) {
        dataDaoBillFinal.addDataBillFinal(data)
    }


    suspend fun deleteByPhoneBill(phone: String): HttpResponse =
        KtorClient.httpClient.delete{
            url("http://192.168.1.192:8100/billFinal/$phone")
            contentType(ContentType.Application.Json)
        }
    /*******************************************************************************/

}