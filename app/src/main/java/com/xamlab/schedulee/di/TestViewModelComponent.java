package com.xamlab.schedulee.di;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = TestViewModelModule.class)
public interface TestViewModelComponent {

    ITestViewModel getTestViewModel();
}
