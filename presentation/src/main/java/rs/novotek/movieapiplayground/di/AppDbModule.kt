package rs.novotek.movieapiplayground.di

import dagger.Module
import dagger.Provides
import rs.novotek.data.MoviesRepositoryImpl
import rs.novotek.domain.backend.RestApi
import rs.novotek.domain.repository.MoviesRepository
import javax.inject.Singleton

@Module
class AppDbModule {

    @Singleton
    @Provides
    fun provideMoviesRepository(restApi: RestApi): MoviesRepository = MoviesRepositoryImpl(restApi)

    /*
    @Singleton
    @Provides
    fun provideNoteDao(context: Context) = createNoteDao(context)

    @Singleton
    @Provides
    fun provideNoteModelMapper() = NoteModelMapperImpl()

    @Singleton
    @Provides
    fun provideNoteRepository(noteDao: NoteDaoImpl, mapper: NoteModelMapperImpl): NoteRepository = NoteRepositoryImpl(noteDao, mapper)
    */
}