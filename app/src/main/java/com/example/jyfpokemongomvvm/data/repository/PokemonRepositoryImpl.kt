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
import com.example.jyfpokemongomvvm.ui.MainActivity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import timber.log.Timber

/**
 * <pre>
 *     author: Jafar
 *     date  : 2020/9/29
 *     desc  : Pokemon仓库的实现类
 *     1：PokemonRemoteMediator 用于实现数据库和网络的访问
 *     2：Mapper
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
            Timber.tag(MainActivity.TAG).d("先从数据库拿列表数据")
            db.pokemonDao().getPokemon()
        }.flow.map { pagingData ->
            Timber.tag(MainActivity.TAG).d("获取到列表数据，进行mapper")
            pagingData.map { mapper2ItemModel.map(it) }
        }
    }

    /**
     * 详情页相关
     */
    override suspend fun fetchPokemonInfo(name: String): Flow<PokemonResult<PokemonInfoModel>> {
        return flow {
            try {
                val pokemonDao = db.pokemonInfoDao()
                // 1：查询数据库是否存在，如果不存在请求网络
                var infoModel = pokemonDao.getPokemon(name)
                if (infoModel == null) {
                    // 网络请求
                    Timber.tag(MainActivity.TAG).d("数据库数据不存在，请求详情页数据")
                    val netWorkPokemonInfo = api.fetchPokemonInfo(name)
                    // 2：将网络上请求的数据，换转成的数据库的 model
                    Timber.tag(MainActivity.TAG).d("将请求到的详情页数据转换为页面需要的Model")
                    infoModel = PokemonInfoEntity.convert2PokemonInfoEntity(netWorkPokemonInfo)
                    // 3：更新数据库
                    Timber.tag(MainActivity.TAG).d("将请求到的详情页数据插入数据库")
                    pokemonDao.insertPokemon(infoModel)
                }
                // 将数据源的 model 转换成上层用到的 model，
                // ui 不能直接持有数据源，防止数据源的变化，影响上层的 ui
                val model = mapper2InfoModel.map(infoModel)

                // 发射转换后的数据
                Timber.tag(MainActivity.TAG).d("发射详情页数据")
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