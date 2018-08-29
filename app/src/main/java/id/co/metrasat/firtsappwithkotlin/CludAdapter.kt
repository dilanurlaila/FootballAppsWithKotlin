package id.co.metrasat.firtsappwithkotlin

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide

class ClubAdapter (private val context: Context, private val item: List<items>,
                    private val listener: (items) -> Unit)
    : RecyclerView.Adapter<ClubAdapter.ViewHolder>() {


    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val name = view.findViewById<TextView>(R.id.txt_club)
        private val image = view.findViewById<ImageView>(R.id.img_club)

        fun bindItem(item: items, listener: (items) -> Unit) {
            name.text = item.name
            Glide.with(itemView.context).load(item.Image).into(image)
            itemView.setOnClickListener{
                listener(item)
            }
        }

    }


    override fun onBindViewHolder(holder: ClubAdapter.ViewHolder, position: Int) {
        holder.bindItem(item[position], listener)
    }


    override fun getItemCount(): Int = item.size



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder(LayoutInflater.from(context).inflate(R.layout.card_list, parent, false))

}