package github.preeti5sharon.catapi

import androidx.lifecycle.ViewModel
import androidx.paging.Pager
import androidx.paging.PagingConfig
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CatViewModel @Inject constructor(private val repository: CatRepository): ViewModel() {
    private val pagingConfig = PagingConfig(10, 10, false, 10)
    fun getCatResponse() = Pager(pagingConfig, 0) {
        CatPagingSource(repository)
    }
}
