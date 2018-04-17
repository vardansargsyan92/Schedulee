package com.xamlab.schedulee.services;

import com.xamlab.schedulee.views.MainActivity;
import com.xamlab.schedulee.views.base.LoginActivity;

import javax.inject.Singleton;

import dagger.Component;
import testServices.implementation.DataServiceModule1;


@Component(modules = DataServiceModule1.class)
public interface TestComponent {

    void  inject(LoginActivity loginActivity);

}
