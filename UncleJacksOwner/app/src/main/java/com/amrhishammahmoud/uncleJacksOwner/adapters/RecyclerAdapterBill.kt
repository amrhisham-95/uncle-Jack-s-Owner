package com.amrhishammahmoud.uncleJacksOwner.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.amrhishammahmoud.uncleJacksOwner.databinding.CustomeCartLayoutBillBinding
import com.amrhishammahmoud.uncleJacksOwner.fragments.DetailsFragmentFromUsers
import com.amrhishammahmoud.uncleJacksOwner.models.BillFinal

class RecyclerAdapterBill(
    private val Data: List<BillFinal>,
    detailsFragmentFromUsers: DetailsFragmentFromUsers
) :
    RecyclerView.Adapter<RecyclerAdapterBill.MyViewHolder>() {


    class MyViewHolder(var binding: CustomeCartLayoutBillBinding) :
        RecyclerView.ViewHolder(binding.root) {

    }


    //By Using ViewBinding
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = CustomeCartLayoutBillBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = Data[position]
        holder.binding.txtName.text = currentItem.namePerson
        holder.binding.txtEmail.text = currentItem.emailPerson
        holder.binding.txtDate.text = currentItem.timeDate
        holder.binding.txtDelivery.text = currentItem.deliveryFee
        holder.binding.txtPhone.text = currentItem.phoneNumber
        holder.binding.txtPrice.text = currentItem.totalPrice
        holder.binding.txtService.text = currentItem.serviceFee
        holder.binding.txtTotalPrice.text = currentItem.totalFinalPrice
        holder.binding.txtVAT.text = currentItem.vat
    }


    override fun getItemCount(): Int {
        return Data.size
    }
}