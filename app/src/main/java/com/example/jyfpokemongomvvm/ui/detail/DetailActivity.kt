package com.example.jyfpokemongomvvm.ui.detail

import android.content.Context
import com.example.jyfpokemongomvvm.model.PokemonItemModel

class DetailActivity {
    companion object {
        private val TAG = "DetailActivity"
        private val KEY_LIST_MODEL = "listModel"
        fun jumpActivity(context: Context, params: PokemonItemModel) {
//            context.startActivity<DetailActivity>(KEY_LIST_MODEL to params)
        }
    }
}