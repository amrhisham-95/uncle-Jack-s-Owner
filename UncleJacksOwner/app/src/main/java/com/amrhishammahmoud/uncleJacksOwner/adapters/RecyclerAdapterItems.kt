package com.amrhishammahmoud.uncleJacksOwner.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.amrhishammahmoud.uncleJacksOwner.databinding.CustomCartLayoutItemsBinding
import com.amrhishammahmoud.uncleJacksOwner.fragments.DetailsFragmentFromUsers
import com.amrhishammahmoud.uncleJacksOwner.models.CartProductsFinal
import com.bumptech.glide.Glide


class RecyclerAdapterItems(
    private val Data: List<CartProductsFinal>,
    detailsFragmentFromUsers: DetailsFragmentFromUsers
) :
    RecyclerView.Adapter<RecyclerAdapterItems.MyViewHolder>() {


    class MyViewHolder(var binding: CustomCartLayoutItemsBinding) :
        RecyclerView.ViewHolder(binding.root) {

    }


    //By Using ViewBinding
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = CustomCartLayoutItemsBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = Data[position]
        holder.binding.titleName.text = currentItem.itemNameFinal
        holder.binding.priceItem.text = currentItem.itemPriceFinal
        holder.binding.txtEmail.text = currentItem.emailPerson
        holder.binding.txtDate.text = currentItem.timeDate
        holder.binding.txtName.text = currentItem.namePerson
        holder.binding.txtPhone.text = currentItem.telephonePerson
        holder.binding.quantityText.text = currentItem.itemQuantityFinal

        // holder.binding.itemPicCardView.setImageResource(currentItem.itemPic)
        Glide.with(holder.binding.itemPicCardViewCart.context)
            .load(currentItem.itemPicFinal)
            .into(holder.binding.itemPicCardViewCart)
    }


    override fun getItemCount(): Int {
        return Data.size
    }
}