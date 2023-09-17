package github.preeti5sharon.catapi

import github.preeti5sharon.catapi.model.CatResponseItem
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface CatService {
    @GET("search")
    suspend fun getCatResponse(
        @Query("limit") limit: Int = 10,
        @Query("page") page: Int = 0,
    ): Response<List<CatResponseItem>>
}
