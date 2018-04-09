package com.xamlab.schedulee.services;


import com.xamlab.schedulee.services.implementation.DataService;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by varda on 3/29/2018.
 */

@Module
public class DataServiceModule {

    @Provides
    @Singleton
    static  IDataService provideMyExample(){
        return  new DataService();
    }
}
