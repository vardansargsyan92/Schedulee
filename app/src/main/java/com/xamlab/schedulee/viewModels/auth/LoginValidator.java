package com.xamlab.schedulee.viewModels.auth;

import android.support.annotation.NonNull;

import com.xamlab.schedulee.utilities.BaseValidationRules;
import com.xamlab.schedulee.viewModels.base.implementation.BaseViewModelValidator;

public class LoginValidator extends BaseViewModelValidator {


    public LoginValidator(LoginViewModel viewModel) {

        addRule(viewModel.email, String.class, new EmailValidationRules());
        addRule(viewModel.password, String.class, new PasswordValidationRules());
    }
}
