package com.xamlab.schedulee.viewModels.main;

import android.arch.lifecycle.ViewModel;
import android.databinding.ObservableField;

import com.xamlab.schedulee.viewModels.Base.IValidateableViewModel;

public class MainViewModel extends ViewModel implements IValidateableViewModel {


    public MainValidator validator;

    public TestCommand testCommand;

    @Override
    public MainValidator getValidator() {
        return validator;
    }


    public MainViewModel() {
        validator = new MainValidator(this);
        testCommand = new TestCommand(this);
    }

    public ObservableField<String> name = new ObservableField<>();

    public ObservableField<String> getName() {
        return name;
    }

    public void setName(String name) {
        this.name.set(name);
    }


    public ObservableField<String> password = new ObservableField<>();

    public ObservableField<String> getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password.set(password);
    }


}


