package com.xamlab.schedulee;

import android.app.Application;

import com.xamlab.schedulee.services.DaggerDataServiceComponent;
import com.xamlab.schedulee.services.DaggerTestComponent;
import com.xamlab.schedulee.services.DataServiceComponent;
import com.xamlab.schedulee.services.DataServiceModule;
import com.xamlab.schedulee.services.TestComponent;

import testServices.implementation.DataServiceModule1;


/**
 * Created by varda on 3/29/2018.
 */

public class MainApplication extends Application {

    private DataServiceComponent dataServiceComponent;

    private TestComponent testComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        dataServiceComponent = createMyComponent();
        testComponent = createTestComponent();

    }

    private TestComponent createTestComponent() {
        return DaggerTestComponent
                .builder()
                .build();

    }


    private DataServiceComponent createMyComponent() {
        return DaggerDataServiceComponent
                .builder()
                .build();
    }


    public DataServiceComponent getDataServiceComponent() {
        return dataServiceComponent;
    }

    public TestComponent getTestComponent() {
        return testComponent;
    }
}
