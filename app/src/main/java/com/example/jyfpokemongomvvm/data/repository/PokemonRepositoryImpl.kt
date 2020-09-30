package com.example.jyfpokemongomvvm.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.jyfpokemongomvvm.data.entity.PokemonEntity
import com.example.jyfpokemongomvvm.data.entity.PokemonInfoEntity
import com.example.jyfpokemongomvvm.data.local.AppDataBase
import com.example.jyfpokemongomvvm.data.mapper.Mapper
import com.example.jyfpokemongomvvm.data.remote.PokemonResult
import com.example.jyfpokemongomvvm.data.remote.PokemonService
import com.example.jyfpokemongomvvm.model.PokemonInfoModel
import com.example.jyfpokemongomvvm.model.PokemonItemModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map

/**
 * <pre>
 *     author: Jafar
 *     date  : 2020/9/29
 *     desc  : Pokemon仓库的实现类
 * </pre>
 */
class PokemonRepositoryImpl(
    private val api: PokemonService,
    val db: AppDataBase,
    private val pageConfig: PagingConfig,
    private val mapper2ItemModel: Mapper<PokemonEntity, PokemonItemModel>,
    private val mapper2InfoModel: Mapper<PokemonInfoEntity, PokemonInfoModel>
) : Repository {

    override fun fetchPokemonList(): Flow<PagingData<PokemonItemModel>> {
        return Pager(
            config = pageConfig,
            remoteMediator = PokemonRemoteMediator(api, db)
        ) {
            db.pokemonDao().getPokemon()
        }.flow.map { pagingData ->
            pagingData.map { mapper2ItemModel.map(it) }
        }
    }

    override suspend fun fetchPokemonInfo(name: String): Flow<PokemonResult<PokemonInfoModel>> {
        return flow {
            try {
                val pokemonDao = db.pokemonInfoDao()
                // 查询数据库是否存在，如果不存在请求网络
                var infoModel = pokemonDao.getPokemon(name)
                if (infoModel == null) {
                    // 网络请求
                    val netWorkPokemonInfo = api.fetchPokemonInfo(name)

                    // 将网路请求的数据，换转成的数据库的 model，之后插入数据库
                    infoModel = PokemonInfoEntity.convert2PokemonInfoEntity(netWorkPokemonInfo)
                    // 插入更新数据库
                    pokemonDao.insertPokemon(infoModel)
                }
                // 将数据源的 model 转换成上层用到的 model，
                // ui 不能直接持有数据源，防止数据源的变化，影响上层的 ui
                val model = mapper2InfoModel.map(infoModel)

                // 发射转换后的数据
                emit(PokemonResult.Success(model))
            } catch (e: Exception) {
                emit(PokemonResult.Failure(e.cause))
            }
        }.flowOn(Dispatchers.IO) // 通过 flowOn 切换到 io 线程
    }

    companion object {
        private val TAG = "PokemonRepositoryImpl"
    }
}