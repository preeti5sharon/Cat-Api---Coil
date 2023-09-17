package github.preeti5sharon.catapi


class CatRepository(private val service: CatService) {
    suspend fun getCatResponse(limit: Int, page: Int) = service.getCatResponse(limit,page)
}