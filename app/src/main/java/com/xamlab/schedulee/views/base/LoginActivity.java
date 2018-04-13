package com.xamlab.schedulee.views.base;

import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.xamlab.schedulee.R;
import com.xamlab.schedulee.databinding.ActivityLoginBinding;
import com.xamlab.schedulee.databinding.ActivityMainBinding;
import com.xamlab.schedulee.services.IDataService;
import com.xamlab.schedulee.viewModels.auth.LoginViewModel;
import com.xamlab.schedulee.viewModels.main.MainViewModel;


public class LoginActivity extends AppCompatActivity {


    private LoginViewModel viewModel;
    private ActivityLoginBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initBindings();

    }


    private void initBindings() {
        binding = DataBindingUtil.setContentView(this, R.layout.activity_login);
        viewModel = ViewModelProviders.of(this).get(LoginViewModel.class);
        binding.setViewModel(viewModel);
    }


}
