import androidx.room.Room
import com.example.GeekBrainsProf.data.api.DictionaryApi
import com.example.GeekBrainsProf.data.datasource.DictionaryLocalDataSource
import com.example.GeekBrainsProf.data.datasource.DictionaryLocalDataSourceImpl
import com.example.GeekBrainsProf.data.datasource.DictionaryRemoteDataSource
import com.example.GeekBrainsProf.data.datasource.DictionaryRemoteDataSourceImpl
import com.example.GeekBrainsProf.domain.repository.DictionaryRepository
import com.example.GeekBrainsProf.domain.repository.DictionaryRepositoryImpl
import com.example.GeekBrainsProf.presentation.dictionary.DictionaryListFragment
import com.example.GeekBrainsProf.presentation.dictionary.DictionaryListViewModel
import com.example.GeekBrainsProf.presentation.history.HistoryListFragment
import com.example.GeekBrainsProf.presentation.history.HistoryListViewModel
import com.example.database.DataBase
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

object DI {

    private const val BASE_URL = "https://dictionary.skyeng.ru/"

    fun getModule() = module {

        single {
            Room
                .databaseBuilder(androidContext(), DataBase::class.java, "app_db")
                .build()
        }

        single<DictionaryApi> {
            Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(
                    OkHttpClient.Builder()
                        .addInterceptor(HttpLoggingInterceptor().apply {
                            level = HttpLoggingInterceptor.Level.BODY
                        })
                        .build()
                )
                .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(DictionaryApi::class.java)
        }

        single<DictionaryRemoteDataSource> { DictionaryRemoteDataSourceImpl(dictionaryApi = get()) }

        single<DictionaryLocalDataSource> { DictionaryLocalDataSourceImpl(dataBase = get()) }

        single<DictionaryRepository> {
            DictionaryRepositoryImpl(
                dictionaryRemoteDataSource = get(),
                dictionaryLocalDataSource = get()
            )
        }

        scope<HistoryListFragment> {
            viewModel { HistoryListViewModel(dictionaryRepository = get()) }
        }

        scope<DictionaryListFragment> {
            viewModel { DictionaryListViewModel(dictionaryRepository = get()) }
        }

    }

}