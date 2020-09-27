package com.example.jyfpokemongomvvm.ui

import android.os.Bundle
import com.example.jyfpokemongomvvm.R
import com.hi.dhl.jdatabinding.DataBindingAppCompatActivity
import dagger.hilt.android.AndroidEntryPoint

/**
 * 1：此处引入@AndroidEntryPoint是为了让外界省去初始化的步骤，就可以直接使用该类
 * 术语：依赖注入 Hilt
 * 2：继承DataBindingAppCompatActivity以实现DataBinding功能
 */
@AndroidEntryPoint
class MainActivity : DataBindingAppCompatActivity() {

//    private val mBinding: ActivityMainBinding by binding(R.layout.activity_main)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}