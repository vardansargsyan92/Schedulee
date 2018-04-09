package com.xamlab.schedulee;

import android.app.Application;

import com.xamlab.schedulee.services.DaggerDataServiceComponent;
import com.xamlab.schedulee.services.DataServiceComponent;
import com.xamlab.schedulee.services.DataServiceModule;


/**
 * Created by varda on 3/29/2018.
 */

public class MainApplication extends Application {

    private DataServiceComponent dataServiceComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        dataServiceComponent = createMyComponent();

    }

    public DataServiceComponent getDataServiceComponent() {
        return dataServiceComponent;
    }

    private DataServiceComponent createMyComponent() {
        return DaggerDataServiceComponent
                .builder()
                .dataServiceModule(new DataServiceModule())
                .build();
    }


}
