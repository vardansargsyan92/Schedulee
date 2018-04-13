package com.xamlab.schedulee.views.base;

import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.databinding.ListChangeRegistry;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.xamlab.schedulee.R;
import com.xamlab.schedulee.databinding.ActivityLoginBinding;
import com.xamlab.schedulee.databinding.ActivityMainBinding;
import com.xamlab.schedulee.services.IDataClient;
import com.xamlab.schedulee.services.IDataService;
import com.xamlab.schedulee.services.Repo;
import com.xamlab.schedulee.viewModels.auth.LoginViewModel;
import com.xamlab.schedulee.viewModels.main.MainViewModel;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class LoginActivity extends AppCompatActivity {


    private LoginViewModel viewModel;
    private ActivityLoginBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initBindings();

        test();

    }

    private void test() {
        Retrofit retrofitBuilder = new Retrofit.Builder()
                .baseUrl("https://api.github.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        IDataClient client = retrofitBuilder.create(IDataClient.class);
        Call<List<Repo>> call = client.getListOfRepos("vardansargsyan92");


        call.enqueue(new Callback<List<Repo>>() {
            @Override
            public void onResponse(Call<List<Repo>> call, Response<List<Repo>> response) {
                List<Repo> res = response.body();
                Toast.makeText(LoginActivity.this, "OK", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<List<Repo>> call, Throwable throwable) {

            }
        });
    }


    private void initBindings() {
        binding = DataBindingUtil.setContentView(this, R.layout.activity_login);
        viewModel = ViewModelProviders.of(this).get(LoginViewModel.class);
        binding.setViewModel(viewModel);
    }


}
