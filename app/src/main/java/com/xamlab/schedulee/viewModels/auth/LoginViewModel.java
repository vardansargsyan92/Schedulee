package com.xamlab.schedulee.viewModels.auth;

import android.arch.lifecycle.ViewModel;
import android.databinding.ObservableField;

import com.xamlab.schedulee.viewModels.base.IValidateableViewModel;
import com.xamlab.schedulee.viewModels.base.IViewModelValidator;

import javax.xml.validation.Validator;

public class LoginViewModel extends ViewModel implements IValidateableViewModel {

    public LoginValidator validator;

    public LoginCommand loginCommand;

    @Override
    public LoginValidator getValidator() {
        return validator;
    }

    public ObservableField<String> email = new ObservableField<>();

    public ObservableField<String> password = new ObservableField<>();

    public ObservableField<String> getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email.set(email);
    }

    public ObservableField<String> getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password.set(password);
    }


    public LoginViewModel() {
        validator = new LoginValidator(this);
        loginCommand = new LoginCommand(this);
    }
}
