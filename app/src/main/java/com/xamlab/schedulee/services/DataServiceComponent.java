package com.xamlab.schedulee.services;


import com.xamlab.schedulee.views.MainActivity;
import com.xamlab.schedulee.views.base.LoginActivity;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by varda on 3/29/2018.
 */

@Singleton
@Component(modules = DataServiceModule.class)
public interface DataServiceComponent {

    void  inject(MainActivity mainActivity);

    void  inject(LoginActivity loginActivity);

}
