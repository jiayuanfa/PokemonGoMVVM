package com.example.jyfpokemongomvvm.ui.detail

import android.view.View
import com.example.jyfpokemongomvvm.R
import com.example.jyfpokemongomvvm.databinding.RecycleItemAlbumBinding
import com.example.jyfpokemongomvvm.model.PokemonInfoModel
import com.hi.dhl.jdatabinding.DataBindingListAdapter
import com.hi.dhl.jdatabinding.DataBindingViewHolder

/**
 * <pre>
 *     author: Jafar
 *     date  : 2020/10/9
 *     desc  :
 * </pre>
 */

class AlbumAdapter :
    DataBindingListAdapter<PokemonInfoModel.AlbumModel>(PokemonInfoModel.AlbumModel.diffCallback) {
    override fun layout(position: Int): Int = R.layout.recycle_item_album

    override fun viewHolder(
        layout: Int,
        view: View
    ): DataBindingViewHolder<PokemonInfoModel.AlbumModel> = AlbumViewHolder(view)
}

class AlbumViewHolder(view: View) : DataBindingViewHolder<PokemonInfoModel.AlbumModel>(view) {

    private val mBinding: RecycleItemAlbumBinding by viewHolderBinding(view)

    override fun bindData(data: PokemonInfoModel.AlbumModel, position: Int) {
        mBinding.apply {
            album = data
            executePendingBindings()
        }
    }

}