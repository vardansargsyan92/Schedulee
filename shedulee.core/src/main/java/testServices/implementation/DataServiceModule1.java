package testServices.implementation;


import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import testServices.IDataService1;

@Module
public class DataServiceModule1 {

    @Provides
    static IDataService1 provideIDataService(){
        return  new DataService1();
    }
}
