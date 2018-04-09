package com.xamlab.schedulee.viewModels.main;

import android.arch.lifecycle.ViewModel;
import android.databinding.ObservableField;

import com.xamlab.schedulee.viewModels.Base.IValidateableViewModel;
import com.xamlab.schedulee.viewModels.Base.IViewModelValidator;

public class MainViewModel extends ViewModel implements IValidateableViewModel{

    public MainValidator validator;

    @Override
    public MainValidator getValidator() {
        return validator;
    }

    /*@Override
    public IViewModelValidator getValidator() {
        return null;
    }*/

    public MainViewModel() {
        validator = new MainValidator(this);

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


