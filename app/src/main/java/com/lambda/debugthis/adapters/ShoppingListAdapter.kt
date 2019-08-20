package com.lambda.debugthis.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.lambda.debugthis.R
import com.lambda.debugthis.models.ShoppingItem
import com.lambda.debugthis.data.ShoppingRepository.Companion.shoppingList
import kotlinx.android.synthetic.main.shopping_item_content.view.*

class ShoppingListAdapter : RecyclerView.Adapter<ShoppingListAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.shopping_item_content,
                parent,
                false
            ) as View
        )
    }

    override fun getItemCount(): Int {
        return shoppingList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = shoppingList[position]
        holder.bindModel(item)

        holder.shoppingItemParent.setOnClickListener {
            item.isAdded = !item.isAdded

            notifyItemChanged(position)
        }
    }

    class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
        private val itemImageView: ImageView = view.iv_shopping_item
        private val itemNameView: TextView = view.tv_shopping_item_name
        val shoppingItemParent: CardView = view.cv_shopping_list_item

        fun bindModel(item: ShoppingItem) {
            itemImageView.setImageResource(item.imageID)
            itemNameView.text = item.itemName
            if (item.isAdded)
                shoppingItemParent.setCardBackgroundColor(ContextCompat.getColor(itemView.context,
                    R.color.colorAdded
                ))
            else
                shoppingItemParent.setCardBackgroundColor(ContextCompat.getColor(itemView.context,
                    R.color.colorListed
                ))
        }
    }
}