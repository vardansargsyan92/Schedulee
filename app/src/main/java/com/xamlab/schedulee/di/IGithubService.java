package com.xamlab.schedulee.di;

import com.xamlab.schedulee.services.Repo;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface IGithubService {
    @GET("/users/{user}/repos")
    Call<List<Repo>> getListRepos(@Path("user") String user);
}
