package com.example.jyfpokemongomvvm.ui

import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import androidx.paging.LoadState
import com.example.jyfpokemongomvvm.R
import com.example.jyfpokemongomvvm.databinding.ActivityMainBinding
import com.example.jyfpokemongomvvm.ui.main.MainViewModel
import com.example.jyfpokemongomvvm.ui.main.PokemonAdapter
import com.example.jyfpokemongomvvm.ui.main.footer.FooterAdapter
import com.hi.dhl.jdatabinding.DataBindingAppCompatActivity
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.flow.collectLatest
import timber.log.Timber

/**
 * 1：此处引入@AndroidEntryPoint是为了让外界省去初始化的步骤，就可以直接使用该类
 * 术语：依赖注入 Hilt
 * 2：继承DataBindingAppCompatActivity以实现DataBinding功能
 */
@AndroidEntryPoint
class MainActivity : DataBindingAppCompatActivity() {

    companion object {
        const val TAG = "jyfLog"
    }
    private val mBinding: ActivityMainBinding by binding(R.layout.activity_main)
    private val mViewModel: MainViewModel by viewModels()
    private val mPokemonAdapter by lazy {
        PokemonAdapter()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mBinding.apply {
            Timber.tag(MainActivity.TAG).d("设置Adapter")
            mRv.adapter = mPokemonAdapter.withLoadStateFooter(FooterAdapter(mPokemonAdapter))
            Timber.tag(MainActivity.TAG).d("设置XML中的Model")
            mainViewModel = mViewModel
            lifecycleOwner = this@MainActivity
        }

        mViewModel.postOfData().observe(this, Observer {
            Timber.tag(TAG).d("拿到数据，刷新列表")
            mPokemonAdapter.submitData(lifecycle, it)
            swipeRefresh.isEnabled = false
        })

        lifecycleScope.launchWhenCreated {
            mPokemonAdapter.loadStateFlow.collectLatest { state ->
                swipeRefresh.isRefreshing = state.refresh is LoadState.Loading
            }
        }
    }
}