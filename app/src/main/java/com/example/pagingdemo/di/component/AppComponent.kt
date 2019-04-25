package com.example.pagingdemo.di.component

import android.app.Application
import com.example.pagingdemo.MainApplication
import com.example.pagingdemo.di.modules.ActivityBuildersModule
import com.example.pagingdemo.di.modules.AppModule
import com.example.pagingdemo.di.modules.NetworkModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidSupportInjectionModule::class,
        ActivityBuildersModule::class,
        AppModule::class,
        NetworkModule::class
    ]
)
interface AppComponent : AndroidInjector<MainApplication> {
    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }
}
