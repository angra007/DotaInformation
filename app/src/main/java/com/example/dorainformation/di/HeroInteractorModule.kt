package com.example.dorainformation.di

import android.app.Application
import com.example.hero_interactor.HeroInteractors
import com.squareup.sqldelight.android.AndroidSqliteDriver
import com.squareup.sqldelight.db.SqlDriver
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object HeroInteractorModule {

    @Provides
    @Singleton
    @Named("heroAndroidSqlDriver")
    fun provideAndroidDriver(app: Application): SqlDriver {
        return AndroidSqliteDriver(
            schema = HeroInteractors.schema,
            context = app,
            name = HeroInteractors.dbName
        )
    }

    @Provides
    @Singleton
    fun provideHeroInteractor(
        @Named("heroAndroidSqlDriver") sqlDriver: SqlDriver
    ): HeroInteractors {
        return HeroInteractors.build(
            sqlDriver = sqlDriver
        )
    }
}