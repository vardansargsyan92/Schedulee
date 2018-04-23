package com.xamlab.schedulee.views;

import android.app.Activity;
import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.xamlab.schedulee.R;
import com.xamlab.schedulee.databinding.ActivityTestBinding;
import com.xamlab.schedulee.di.DaggerGithubComponent;
import com.xamlab.schedulee.di.DaggerTestViewModelComponent;
import com.xamlab.schedulee.di.GithubComponent;
import com.xamlab.schedulee.di.GithubModule;
import com.xamlab.schedulee.di.ITestViewModel;
import com.xamlab.schedulee.di.TestViewModel;
import com.xamlab.schedulee.di.TestViewModelComponent;
import com.xamlab.schedulee.di.TestViewModelModule;
import com.xamlab.schedulee.viewModels.auth.LoginViewModel;

public class TestActivity extends AppCompatActivity {

    private ITestViewModel testViewModel;
    private ActivityTestBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        InitBinding();
    }

    private void InitBinding() {

        TestViewModelComponent component = DaggerTestViewModelComponent
                .builder()
                .testViewModelModule(new TestViewModelModule(this))
                .build();

        binding = DataBindingUtil.setContentView(this, R.layout.activity_test);
        testViewModel = component.getTestViewModel();
        binding.setViewModel(testViewModel);
    }
}
