package com.example.challenge.view.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.challenge.R
import com.example.challenge.databinding.ItemViewRowBinding
import com.example.challenge.model.Show
import com.example.challenge.utils.DateUtils

class MainAdapter(
    val context:Context,
    private val showList: ArrayList<Show>

) : RecyclerView.Adapter<MainAdapter.DataViewHolder>() {

    class DataViewHolder(private var textViewBinding: ItemViewRowBinding) :
        RecyclerView.ViewHolder(
            textViewBinding.root
        ) {

        fun bind(context: Context, card: Show) {
            textViewBinding.txtTitle.text = card.title
            textViewBinding.txtDesc.text = card.synopsis
            textViewBinding.txtStartDate.text = card.start_date?.let { context.getString(R.string.start_date,DateUtils.getDateSting(it)) }
            textViewBinding.txtEndDate.text = card.end_date?.let { context.getString(R.string.end_date_s, DateUtils.getDateSting(it)) }
            textViewBinding.txtMembers.text = context.getString(R.string.members_watching,card.members.toString())
            textViewBinding.txtScore.text = context.getString(R.string.rating,card.score.toString())
            textViewBinding.txtType.text = context.getString(R.string.type,card.type)
            Glide.with(textViewBinding.imageViewAvatar).load(card.image_url).into(textViewBinding.imageViewAvatar)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataViewHolder {
            return DataViewHolder(
                DataBindingUtil.inflate(
                    LayoutInflater.from(parent.context),
                    R.layout.item_view_row,
                    parent,
                    false
                )
            )
    }


    override fun getItemCount(): Int = showList.size

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) {
       holder.bind(context, showList[holder.absoluteAdapterPosition])
    }

    fun addData(list: List<Show>) {
        showList.clear();
        showList.addAll(list)
    }
}