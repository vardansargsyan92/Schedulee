package com.xamlab.schedulee.di;

import android.databinding.ObservableField;

public interface ITestViewModel {
    ObservableField<String> getName();

    void setName(String name);
}
