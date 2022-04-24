package com.devcraft.clean_architecture.ui.main.leagues.adapter

import com.bumptech.glide.Glide
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.devcraft.clean_architecture.R
import com.devcraft.clean_architecture.model.League
import kotlinx.android.synthetic.main.item_league.view.*

class LeaguesAdapter : BaseQuickAdapter<League, BaseViewHolder>(R.layout.item_league) {

    var lastSelectedPosition: Int = -1
    var onItemClickListener: ((position: Int, id: String) -> Unit)? = null

    override fun convert(helper: BaseViewHolder, item: League?) {
        item?.let { league ->
            helper.itemView.tvNameLeague.text = league.name
            Glide.with(helper.itemView.context).load(league.logos.light).centerInside().into(helper.itemView.ivPhotoLeague)
            helper.itemView.tvSlugLeague.text = league.slug
            helper.itemView.tvAbbrLeague.text = league.abbr
            helper.itemView.setOnClickListener {
                onItemClickListener?.invoke(helper.adapterPosition, league.id)
                lastSelectedPosition = helper.adapterPosition
            }
        }
    }
}