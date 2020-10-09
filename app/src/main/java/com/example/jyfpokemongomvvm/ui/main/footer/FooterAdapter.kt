package com.example.jyfpokemongomvvm.ui.main.footer

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.paging.LoadState
import androidx.paging.LoadStateAdapter
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.jyfpokemongomvvm.R
import com.example.jyfpokemongomvvm.ui.main.PokemonAdapter

/**
 * <pre>
 *     author: Jafar
 *     date  : 2020/10/9
 *     desc  :
 * </pre>
 */
class FooterAdapter(val adapter: PokemonAdapter): LoadStateAdapter<NetworkStateItemViewHolder>() {
    override fun onBindViewHolder(holder: NetworkStateItemViewHolder, loadState: LoadState) {

        // 在第0个位置 铺开 并设置数据
        val params = holder.itemView.layoutParams
        if (params is StaggeredGridLayoutManager.LayoutParams) {
            params.isFullSpan = true
        }
        holder.bindData(loadState, 0)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        loadState: LoadState
    ): NetworkStateItemViewHolder {
        // 设置View 并实现回调
        val view = inflateView(parent, R.layout.recycle_item_network_state)
        return NetworkStateItemViewHolder(view) {adapter.retry()}
    }

    private fun inflateView(viewGroup: ViewGroup, @LayoutRes viewType: Int): View {
        val layoutInflater = LayoutInflater.from(viewGroup.context)
        return layoutInflater.inflate(viewType, viewGroup, false)
    }
}