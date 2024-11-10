package com.amrhishammahmoud.uncleJacksOwner.fragments

import android.annotation.SuppressLint
import android.content.Context
import android.net.ConnectivityManager
import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.amrhishammahmoud.uncleJacksOwner.R
import com.amrhishammahmoud.uncleJacksOwner.adapters.RecyclerAdapterBill
import com.amrhishammahmoud.uncleJacksOwner.adapters.RecyclerAdapterItems
import com.amrhishammahmoud.uncleJacksOwner.databinding.FragmentDetailsFromUsersBinding
import com.amrhishammahmoud.uncleJacksOwner.viewModels.RoomViewModel
import dagger.hilt.android.AndroidEntryPoint
import java.util.Timer
import kotlin.concurrent.schedule

@AndroidEntryPoint

class DetailsFragmentFromUsers : Fragment() {
    private lateinit var binding: FragmentDetailsFromUsersBinding
    private val roomViewModel: RoomViewModel by viewModels()
    private lateinit var adapterItems: RecyclerAdapterItems
    private lateinit var adapterBill: RecyclerAdapterBill
    val timer = Timer()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_details_from_users,
            container,
            false
        )
        setHasOptionsMenu(true)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.lifecycleOwner = this
        binding.roomViewModel = roomViewModel


        //To confirm that internet is available : (if not : app will show the data that saved in room database ) :
        val connectivityManager =
            requireContext().getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val capabilities =
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                connectivityManager.getNetworkCapabilities(connectivityManager.activeNetwork)
            } else {
                TODO("VERSION.SDK_INT < M")
            }
        if (capabilities != null) {

            putDataIntoRecyclerViewItems()
            putDataIntoRecyclerViewBill()

        }

        /*  timer.schedule(0L, 1000L) {
              roomViewModel.deleteAllBillFinalDetails()
              roomViewModel.deleteData()
          }*/



        binding.button2.setOnClickListener {
            if (binding.editTextPhoneNumber.text.isNotEmpty()) {
                roomViewModel.deleteAllBillFinalDetails()
                roomViewModel.deleteData()

                roomViewModel.deleteItemsDataByPhoneFromKtorServer(binding.editTextPhoneNumber.text.toString())
                roomViewModel.deleteBillDataByPhoneFromKtorServer(binding.editTextPhoneNumber.text.toString())
            }else{
                Toast.makeText(requireContext(),"أدخل رقم الموبايل لكل فاتورة لإنهاء تسجيل العملية",Toast.LENGTH_LONG).show()
            }
        }

    }


    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        // Do something that differs the Activity's menu here
        inflater.inflate(R.menu.orders_menu, menu);

        super.onCreateOptionsMenu(menu!!, inflater!!)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {

            R.id.addMenu -> {
                findNavController().navigate(R.id.action_detailsFragmentFromUsers_to_ownerFragmentChanges)
                return true
            }

            R.id.main2 -> {
                findNavController().navigate(R.id.action_detailsFragmentFromUsers_to_mainFragment)
                return true
            }

            else -> {}
        }
        return false
    }


    //put the data into recycler view Items
    @SuppressLint("NotifyDataSetChanged")
    private fun putDataIntoRecyclerViewItems() {


        roomViewModel.readAllDataFinal.observe(viewLifecycleOwner) {
            if (it.isEmpty()) {
                roomViewModel.getDataRetrofitViewModelItems()
            }
        }



        roomViewModel.mutibaleLiveDataFinalCart.observe(viewLifecycleOwner) {
            if (it.isNotEmpty()) {
                roomViewModel.getAndPutDataFinalIntoDateBase(it)
            }
        }

        roomViewModel.readAllDataFinal.observe(viewLifecycleOwner) {
            binding.cartRecyclerViewItems.layoutManager =
                LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)
            binding.cartRecyclerViewItems.adapter =
                RecyclerAdapterItems(it, this@DetailsFragmentFromUsers)
            binding.cartRecyclerViewItems.setHasFixedSize(true)
            adapterItems = RecyclerAdapterItems(it, this@DetailsFragmentFromUsers)
            adapterItems.notifyDataSetChanged()
        }
    }


    //put the data into recycler view Bill
    @SuppressLint("NotifyDataSetChanged")
    private fun putDataIntoRecyclerViewBill() {


        roomViewModel.readAllDataBillFinal.observe(viewLifecycleOwner) {
            if (it.isEmpty()) {
                roomViewModel.getDataRetrofitViewModelBill()
            }
        }



        roomViewModel.mutibaleLiveDataBillFinal.observe(viewLifecycleOwner) {
            if (it.isNotEmpty()) {

                roomViewModel.putBillFinalToRoomDatabase(it)

            }
        }

        roomViewModel.readAllDataBillFinal.observe(viewLifecycleOwner) {
            binding.cartRecyclerViewBill.layoutManager =
                LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)
            binding.cartRecyclerViewBill.adapter =
                RecyclerAdapterBill(it, this@DetailsFragmentFromUsers)
            binding.cartRecyclerViewBill.setHasFixedSize(true)
            adapterBill = RecyclerAdapterBill(it, this@DetailsFragmentFromUsers)
            adapterBill.notifyDataSetChanged()
        }
    }

}