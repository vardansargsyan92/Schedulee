package com.xamlab.schedulee.di;

import android.arch.lifecycle.ViewModel;
import android.databinding.ObservableField;

import java.security.PublicKey;

public class TestViewModel extends ViewModel implements ITestViewModel {

    ObservableField<String> name = new ObservableField<>();

    public ObservableField<String> getName() {
        return name;
    }

    public void setName(String name) {
        this.name.set(name);
    }
}
