package com.devcraft.clean_architecture.ui.main.season.adapter

import com.bumptech.glide.Glide
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.devcraft.clean_architecture.R
import com.devcraft.clean_architecture.model.Standing
import kotlinx.android.synthetic.main.item_season.view.*

class SeasonAdapter : BaseQuickAdapter<Standing, BaseViewHolder>(R.layout.item_season) {

    override fun convert(helper: BaseViewHolder, item: Standing?) {
        item?.let { standing ->
            Glide.with(helper.itemView.context).load(standing.team!!.logos[0].href).centerInside().into(helper.itemView.ivSeason)
            helper.itemView.tvName.text = standing.team.name
            helper.itemView.tvWinsNumber.text = standing.stats?.get(0)?.value.toString()
            helper.itemView.tvLossesNumber.text = standing.stats!![1].value.toString()
            helper.itemView.tvTiesNumber.text = standing.stats!![2].value.toString()
            helper.itemView.tvGamesPlayed.text = standing.stats!![3].value.toString()
            helper.itemView.tvTotalPointNumber.text = standing.stats!![4].value.toString()
        }
    }
}
