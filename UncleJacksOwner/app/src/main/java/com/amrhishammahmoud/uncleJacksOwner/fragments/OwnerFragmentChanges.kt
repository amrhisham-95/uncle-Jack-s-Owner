package com.amrhishammahmoud.uncleJacksOwner.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.amrhishammahmoud.uncleJacksOwner.R
import com.amrhishammahmoud.uncleJacksOwner.databinding.FragmentOwnerChangesBinding
import com.amrhishammahmoud.uncleJacksOwner.models.Fruits
import com.amrhishammahmoud.uncleJacksOwner.models.JacksMixes
import com.amrhishammahmoud.uncleJacksOwner.models.Juices
import com.amrhishammahmoud.uncleJacksOwner.models.Services
import com.amrhishammahmoud.uncleJacksOwner.viewModels.RoomViewModel
import com.google.firebase.Firebase
import com.google.firebase.firestore.firestore
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint

class OwnerFragmentChanges : Fragment() {
    private lateinit var binding: FragmentOwnerChangesBinding
    private val roomViewModel: RoomViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_owner_changes, container, false)

        setHasOptionsMenu(true)


        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.lifecycleOwner = this
        binding.roomViewModel = roomViewModel


        binding.radioButton.setOnCheckedChangeListener { buttonView, isChecked ->

            if(buttonView.isChecked){
                Toast.makeText(activity, "Juices", Toast.LENGTH_SHORT).show()


                binding.addBtn.setOnClickListener {
                    if (binding.editTextIDProduct.text.toString().isNotEmpty() && binding.editTextNameProduct.text.toString()
                            .isNotEmpty() && binding.editTextPriceProduct.text.toString()
                            .isNotEmpty() && binding.editTextImageProduct.text.toString().isNotEmpty() && binding.editTextTypeProduct.text.toString().isNotEmpty()
                    ) {

                        val id = binding.editTextIDProduct.text.toString().toInt()
                        val nameProduct = binding.editTextNameProduct.text.toString()
                        val priceProduct = binding.editTextPriceProduct.text.toString()
                        val typeProduct = binding.editTextTypeProduct.text.toString()
                        val imageProduct = binding.editTextImageProduct.text.toString()

                        roomViewModel.postFruitsToServer(Fruits(id,nameProduct,typeProduct,priceProduct,imageProduct))
                        clearAllData()
                    } else {
                        Toast.makeText(
                            activity,
                            "Enter Values To The Empty Squares",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                    /*****************************************************************************/

                    binding.EditBtn.setOnClickListener {
                        if (binding.editTextIDProduct.text.toString().isNotEmpty() && binding.editTextNameProduct.text.toString()
                                .isNotEmpty() && binding.editTextPriceProduct.text.toString()
                                .isNotEmpty() && binding.editTextImageProduct.text.toString()
                                .isNotEmpty() && binding.editTextDeliveryFee.text.toString()
                                .isNotEmpty()
                            && binding.editTextTypeProduct.text.toString().isNotEmpty()
                        ) {
                            val id = binding.editTextIDProduct.text.toString().toInt()
                            val nameProduct = binding.editTextNameProduct.text.toString()
                            val priceProduct = binding.editTextPriceProduct.text.toString()
                            val typeProduct = binding.editTextTypeProduct.text.toString()
                            val imageProduct = binding.editTextImageProduct.text.toString()

                            roomViewModel.updateJuicesInServer(id, Juices(id,nameProduct,typeProduct,priceProduct,imageProduct))

                            clearAllData()
                        } else {
                            Toast.makeText(
                                activity,
                                "Enter Values To The Empty Squares",
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    }

                    /*****************************************************************************/


                    binding.removeBtn.setOnClickListener {
                        if (binding.editTextIDProduct.text.toString().isNotEmpty() && binding.editTextNameProduct.text.toString()
                                .isNotEmpty() && binding.editTextPriceProduct.text.toString()
                                .isNotEmpty() && binding.editTextImageProduct.text.toString()
                                .isNotEmpty() && binding.editTextTypeProduct.text.toString().isNotEmpty()
                        ) {
                            val id = binding.editTextIDProduct.text.toString().toInt()
                            roomViewModel.deleteItemsFruitsDataByIdFromKtorServer(id)
                            clearAllData()
                        } else {
                            Toast.makeText(
                                activity,
                                "Enter Values To The Empty Squares",
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    }

                    /*****************************************************************************/


                    binding.updateBtn.setOnClickListener {
                        if (binding.editTextIDProduct.text.toString().isNotEmpty() && binding.editTextDeliveryFee.text.toString().isNotEmpty() &&
                            binding.editTextServiceFee.text.toString().isNotEmpty() &&
                            binding.editTextVAT.text.toString().isNotEmpty()
                        ) {
                            val delivery = binding.editTextDeliveryFee.text.toString()
                            val service = binding.editTextServiceFee.text.toString()
                            val vat = binding.editTextVAT.text.toString()
                            val id = binding.editTextIDProduct.text.toString().toInt()

                            roomViewModel.updateServicesInServer(id, Services(id,service,delivery,vat))
                            clearAllData()
                        } else {
                            Toast.makeText(
                                activity,
                                "Enter Values To The Empty Squares and enter the id",
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    }
                }
            }

        }

        binding.radioButton2.setOnCheckedChangeListener { buttonView, isChecked ->

            if (buttonView.isChecked) {
                Toast.makeText(activity, "Fruits", Toast.LENGTH_SHORT).show()


                binding.addBtn.setOnClickListener {
                    if (binding.editTextIDProduct.text.toString().isNotEmpty() &&binding.editTextNameProduct.text.toString()
                            .isNotEmpty() && binding.editTextPriceProduct.text.toString()
                            .isNotEmpty() && binding.editTextImageProduct.text.toString()
                            .isNotEmpty() && binding.editTextTypeProduct.text.toString()
                            .isNotEmpty()
                    ) {

                        val id = binding.editTextIDProduct.text.toString().toInt()
                        val nameProduct = binding.editTextNameProduct.text.toString()
                        val priceProduct = binding.editTextPriceProduct.text.toString()
                        val typeProduct = binding.editTextTypeProduct.text.toString()
                        val imageProduct = binding.editTextImageProduct.text.toString()

                        roomViewModel.postJuicesToServer(Juices(id,nameProduct,typeProduct,priceProduct,imageProduct))
                        clearAllData()
                    } else {
                        Toast.makeText(
                            activity,
                            "Enter Values To The Empty Squares",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }

                binding.EditBtn.setOnClickListener {
                    if (binding.editTextIDProduct.text.toString().isNotEmpty() &&binding.editTextNameProduct.text.toString()
                            .isNotEmpty() && binding.editTextPriceProduct.text.toString()
                            .isNotEmpty() && binding.editTextImageProduct.text.toString()
                            .isNotEmpty() && binding.editTextTypeProduct.text.toString()
                            .isNotEmpty()
                    ) {
                        val id = binding.editTextIDProduct.text.toString().toInt()
                        val nameProduct = binding.editTextNameProduct.text.toString()
                        val priceProduct = binding.editTextPriceProduct.text.toString()
                        val typeProduct = binding.editTextTypeProduct.text.toString()
                        val imageProduct = binding.editTextImageProduct.text.toString()

                        roomViewModel.updateFruitsInServer(id, Fruits(id,nameProduct,typeProduct,priceProduct,imageProduct))
                        clearAllData()
                    } else {
                        Toast.makeText(
                            activity,
                            "Enter Values To The Empty Squares",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }

                binding.removeBtn.setOnClickListener {
                    if (binding.editTextIDProduct.text.toString().isNotEmpty() && binding.editTextNameProduct.text.toString()
                            .isNotEmpty() && binding.editTextPriceProduct.text.toString()
                            .isNotEmpty() && binding.editTextImageProduct.text.toString()
                            .isNotEmpty() && binding.editTextTypeProduct.text.toString()
                            .isNotEmpty()
                    ) {
                        val id = binding.editTextIDProduct.text.toString().toInt()
                        roomViewModel.deleteItemsJuicesDataByIdFromKtorServer(id)
                        clearAllData()
                    } else {
                        Toast.makeText(
                            activity,
                            "Enter Values To The Empty Squares",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }


                binding.updateBtn.setOnClickListener {
                    if (binding.editTextIDProduct.text.toString().isNotEmpty() && binding.editTextDeliveryFee.text.toString().isNotEmpty() &&
                        binding.editTextServiceFee.text.toString().isNotEmpty() &&
                        binding.editTextVAT.text.toString().isNotEmpty()
                    ) {
                        val delivery = binding.editTextDeliveryFee.text.toString()
                        val service = binding.editTextServiceFee.text.toString()
                        val vat = binding.editTextVAT.text.toString()
                        val id = binding.editTextIDProduct.text.toString().toInt()

                        roomViewModel.updateServicesInServer(id, Services(id,service,delivery,vat))
                        clearAllData()
                    } else {
                        Toast.makeText(
                            activity,
                            "Enter Values To The Empty Squares",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }
            }

        }

        binding.radioButton3.setOnCheckedChangeListener { buttonView, isChecked ->

            if (buttonView.isChecked) {
                Toast.makeText(activity, "Jack's Mixes", Toast.LENGTH_SHORT).show()

                binding.addBtn.setOnClickListener {
                    if (binding.editTextIDProduct.text.toString().isNotEmpty() && binding.editTextNameProduct.text.toString()
                            .isNotEmpty() && binding.editTextPriceProduct.text.toString()
                            .isNotEmpty() && binding.editTextImageProduct.text.toString().isNotEmpty() && binding.editTextTypeProduct.text.toString().isNotEmpty()
                    ) {
                        val id = binding.editTextIDProduct.text.toString().toInt()
                        val nameProduct = binding.editTextNameProduct.text.toString()
                        val priceProduct = binding.editTextPriceProduct.text.toString()
                        val typeProduct = binding.editTextTypeProduct.text.toString()
                        val imageProduct = binding.editTextImageProduct.text.toString()

                        roomViewModel.postJacksMixesToServer(JacksMixes(id,nameProduct,typeProduct,priceProduct,imageProduct))
                        clearAllData()
                    } else {
                        Toast.makeText(
                            activity,
                            "Enter Values To The Empty Squares",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                    /*****************************************************************************/

                    binding.EditBtn.setOnClickListener {
                        if (binding.editTextIDProduct.text.toString().isNotEmpty() && binding.editTextNameProduct.text.toString()
                                .isNotEmpty() && binding.editTextPriceProduct.text.toString()
                                .isNotEmpty() && binding.editTextImageProduct.text.toString()
                                .isNotEmpty() && binding.editTextDeliveryFee.text.toString()
                                .isNotEmpty()
                            && binding.editTextTypeProduct.text.toString().isNotEmpty()
                        ) {
                            val id = binding.editTextIDProduct.text.toString().toInt()
                            val nameProduct = binding.editTextNameProduct.text.toString()
                            val priceProduct = binding.editTextPriceProduct.text.toString()
                            val typeProduct = binding.editTextTypeProduct.text.toString()
                            val imageProduct = binding.editTextImageProduct.text.toString()

                            roomViewModel.updateJacksMixesInServer(id, JacksMixes(id,nameProduct,typeProduct,priceProduct,imageProduct))
                            clearAllData()
                        } else {
                            Toast.makeText(
                                activity,
                                "Enter Values To The Empty Squares",
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    }

                    /*****************************************************************************/


                    binding.removeBtn.setOnClickListener {
                        if ( binding.editTextIDProduct.text.toString().isNotEmpty() && binding.editTextNameProduct.text.toString()
                                .isNotEmpty() && binding.editTextPriceProduct.text.toString()
                                .isNotEmpty() && binding.editTextImageProduct.text.toString()
                                .isNotEmpty() && binding.editTextTypeProduct.text.toString().isNotEmpty()
                        ) {
                            val id = binding.editTextIDProduct.text.toString().toInt()
                            roomViewModel.deleteItemsJacksMixesDataByIdFromKtorServer(id)
                            clearAllData()
                        } else {
                            Toast.makeText(
                                activity,
                                "Enter Values To The Empty Squares",
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    }

                    /*****************************************************************************/


                    binding.updateBtn.setOnClickListener {
                        if (binding.editTextIDProduct.text.toString().isNotEmpty() && binding.editTextDeliveryFee.text.toString().isNotEmpty() &&
                            binding.editTextServiceFee.text.toString().isNotEmpty() &&
                            binding.editTextVAT.text.toString().isNotEmpty()
                        ) {
                            val delivery = binding.editTextDeliveryFee.text.toString()
                            val service = binding.editTextServiceFee.text.toString()
                            val vat = binding.editTextVAT.text.toString()
                            val id = binding.editTextIDProduct.text.toString().toInt()

                            roomViewModel.updateServicesInServer(id, Services(id,service,delivery,vat))
                            clearAllData()
                        } else {
                            Toast.makeText(
                                activity,
                                "Enter Values To The Empty Squares",
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    }
                }
            }
        }
    }


    private fun clearAllData() {
        binding.editTextNameProduct.setText("")
        binding.editTextPriceProduct.setText("")
        binding.editTextImageProduct.setText("")
        binding.editTextTypeProduct.setText("")
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        // Do something that differs the Activity's menu here
        inflater.inflate(R.menu.main_menu, menu);

        super.onCreateOptionsMenu(menu!!, inflater!!)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {

            R.id.ordersMenu ->
            {
                findNavController().navigate(R.id.action_ownerFragmentChanges_to_detailsFragmentFromUsers)
                return true
            }
            R.id.main1 ->
            {
                findNavController().navigate(R.id.action_ownerFragmentChanges_to_mainFragment)
                return true
            }


            else -> {}
        }
        return false
    }

}