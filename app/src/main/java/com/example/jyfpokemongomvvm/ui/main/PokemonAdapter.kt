package com.example.jyfpokemongomvvm.ui.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.paging.PagingDataAdapter
import com.example.jyfpokemongomvvm.R
import com.example.jyfpokemongomvvm.databinding.RecycleItemPokemonBinding
import com.example.jyfpokemongomvvm.model.PokemonItemModel
import com.hi.dhl.jdatabinding.DataBindingViewHolder
import com.hi.dhl.jdatabinding.dowithTry

/**
 * <pre>
 *     author: Jafar
 *     date  : 2020/10/9
 *     desc  :
 * </pre>
 */
class PokemonAdapter :
        PagingDataAdapter<PokemonItemModel, PokemonViewModel>(PokemonItemModel.diffCallback) {

    /**
     * 绑定数据
     */
    override fun onBindViewHolder(holder: PokemonViewModel, position: Int) {
        dowithTry {
            val data = getItem(position)
            data?.let {
                holder.bindData(data, position)
            }
        }
    }

    /**
     * 绑定View
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokemonViewModel {
        val view = inflateView(parent, R.layout.recycle_item_pokemon)
        return PokemonViewModel(view)
    }

    /**
     * 拿到View的办法
     */
    private fun inflateView(viewGroup: ViewGroup, @LayoutRes viewType: Int): View {
        val layoutInflater = LayoutInflater.from(viewGroup.context)
        return layoutInflater.inflate(viewType, viewGroup, false)
    }
}

/**
 * 绑定数据的方法
 */
class PokemonViewModel(view: View) : DataBindingViewHolder<PokemonItemModel>(view) {

    private val mBinding: RecycleItemPokemonBinding by viewHolderBinding(view)

    override fun bindData(data: PokemonItemModel, position: Int) {
        mBinding.apply {
            data.id = "#${position + 1}"
            pokemon = data
            executePendingBindings()
        }
    }
}