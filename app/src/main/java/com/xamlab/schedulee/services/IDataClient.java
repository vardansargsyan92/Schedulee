package com.xamlab.schedulee.services;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface IDataClient {


    @GET("/users/{user}/repos")
    Call<List<Repo>> getListOfRepos(@Path("user") String user);

}
