package github.preeti5sharon.catapi

import androidx.paging.PagingSource
import androidx.paging.PagingState
import github.preeti5sharon.catapi.model.CatResponseItem

class CatPagingSource(private val repository: CatRepository) :
    PagingSource<Int, CatResponseItem>() {
    override fun getRefreshKey(state: PagingState<Int, CatResponseItem>): Int? {
        return null
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, CatResponseItem> {
        val offset = params.key ?: 0
        val limit = params.loadSize
        val response = repository.getCatResponse(limit, offset).body()
        return LoadResult.Page(response.orEmpty(), offset - 1, offset + 1)
    }
}
