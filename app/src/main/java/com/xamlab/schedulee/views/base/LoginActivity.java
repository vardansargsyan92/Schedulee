package com.xamlab.schedulee.views.base;

import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.xamlab.schedulee.MainApplication;
import com.xamlab.schedulee.R;
import com.xamlab.schedulee.databinding.ActivityLoginBinding;
import com.xamlab.schedulee.di.DaggerGithubComponent;
import com.xamlab.schedulee.di.GithubComponent;
import com.xamlab.schedulee.di.GithubModule;
import com.xamlab.schedulee.di.IGithubService;
import com.xamlab.schedulee.services.IDataClient;
import com.xamlab.schedulee.services.IDataService;
import com.xamlab.schedulee.services.Repo;
import com.xamlab.schedulee.viewModels.auth.LoginViewModel;

import java.util.List;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import testServices.IDataService1;


public class LoginActivity extends AppCompatActivity {


    @Inject
    public IDataService1 dataService1;

    private LoginViewModel viewModel;
    private ActivityLoginBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ((MainApplication) getApplication()).getTestComponent().inject(this);
        initBindings();

        test();

        viewModel.setEmail(dataService1.getDate1() + "");

    }

    private void test() {
        /*Retrofit retrofitBuilder = new Retrofit.Builder()
                .baseUrl("https://api.github.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        IDataClient client = retrofitBuilder.create(IDataClient.class);*/
        GithubComponent component = DaggerGithubComponent
                .builder()
                .githubModule(new GithubModule("https://api.github.com/"))
                .build();

        Call<List<Repo>> call = component.gihubService().getListRepos("vardansargsyan92");


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
