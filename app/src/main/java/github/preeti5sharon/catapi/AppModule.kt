package github.preeti5sharon.catapi

import com.squareup.moshi.Moshi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideMoshi() = Moshi.Builder().build()

    @Provides
    @Singleton
    fun provideRetrofit(moshi: Moshi) =
        Retrofit.Builder().baseUrl("https://api.thecatapi.com/v1/images/")
            .addConverterFactory(MoshiConverterFactory.create(moshi)).build()

    @Provides
    @Singleton
    fun provideService(retrofit: Retrofit) = retrofit.create(CatService::class.java)

    @Provides
    @Singleton
    fun provideRepository(service: CatService) = CatRepository(service)
}
