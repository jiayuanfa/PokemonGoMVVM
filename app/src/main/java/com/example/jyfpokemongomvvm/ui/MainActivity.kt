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

/**
 * 1：此处引入@AndroidEntryPoint是为了让外界省去初始化的步骤，就可以直接使用该类
 * 术语：依赖注入 Hilt
 * 2：继承DataBindingAppCompatActivity以实现DataBinding功能
 */
@AndroidEntryPoint
class MainActivity : DataBindingAppCompatActivity() {

    private val mBinding: ActivityMainBinding by binding(R.layout.activity_main)
    private val mViewModel: MainViewModel by viewModels()
    private val mPokemonAdapter by lazy {
        PokemonAdapter()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mBinding.apply {
            mRv.adapter = mPokemonAdapter.withLoadStateFooter(FooterAdapter(mPokemonAdapter))
            mainViewModel = mViewModel
            lifecycleOwner = this@MainActivity
        }

        mViewModel.postOfData().observe(this, Observer {
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