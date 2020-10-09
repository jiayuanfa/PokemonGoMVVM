package com.example.jyfpokemongomvvm.ui.detail

import android.content.Context
import androidx.activity.viewModels
import com.example.jyfpokemongomvvm.R
import com.example.jyfpokemongomvvm.databinding.ActivityDetailsBinding
import com.example.jyfpokemongomvvm.model.PokemonItemModel
import com.hi.dhl.jdatabinding.DataBindingAppCompatActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailActivity : DataBindingAppCompatActivity() {

    private val mBindingActivity: ActivityDetailsBinding by binding(R.layout.activity_details)
    private val mViewModel: DetailViewModel by viewModels()
    lateinit var mPokemonModel: PokemonItemModel

    companion object {
        private val TAG = "DetailActivity"
        private val KEY_LIST_MODEL = "listModel"
        fun jumpActivity(context: Context, params: PokemonItemModel) {
//            context.startActivity<DetailActivity>(KEY_LIST_MODEL to params)
        }
    }
}