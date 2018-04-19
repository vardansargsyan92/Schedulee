package com.xamlab.schedulee.di;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = GithubModule.class)
public interface GithubComponent {
    IGithubService gihubService();
}
