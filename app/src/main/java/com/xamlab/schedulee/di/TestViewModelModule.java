package com.xamlab.schedulee.di;

import android.app.Activity;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.support.v4.app.FragmentActivity;

import com.xamlab.schedulee.viewModels.auth.LoginViewModel;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class TestViewModelModule {
    private FragmentActivity activity;

    public TestViewModelModule(FragmentActivity activity) {
        this.activity = activity;
    }

    @Provides
    @Singleton
    ITestViewModel provideTestViewModel() {

        return ViewModelProviders.of(activity).get(TestViewModel.class);
    }

}
