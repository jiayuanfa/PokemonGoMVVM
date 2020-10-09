package com.example.jyfpokemongomvvm.ui.main.footer

import android.view.View
import androidx.core.view.isVisible
import androidx.paging.LoadState
import com.example.jyfpokemongomvvm.databinding.RecycleItemNetworkStateBinding
import com.hi.dhl.jdatabinding.DataBindingViewHolder

/**
 * <pre>
 *     author: Jafar
 *     date  : 2020/10/9
 *     desc  :
 * </pre>
 */
class NetworkStateItemViewHolder(view: View, private val retryCallback: () -> Unit) :
        DataBindingViewHolder<LoadState>(view) {
    private val mBinding: RecycleItemNetworkStateBinding by viewHolderBinding(view)

    override fun bindData(data: LoadState, position: Int) {
        mBinding.apply {
            // 正在加载，显示进度条
            progress.isVisible = data is LoadState.Loading
            // 加载失败 显示并点击重试按钮
            retryButton.isVisible = data is LoadState.Error
            retryButton.setOnClickListener { retryCallback() }
            // 加载失败 显示错误原因
            errorMsg.isVisible = !(data as? LoadState.Error)?.error?.message.isNullOrBlank()
            errorMsg.text = (data as? LoadState.Error)?.error?.message
        }
    }
}