package com.xamlab.schedulee.viewModels.main;


import com.xamlab.schedulee.viewModels.auth.PasswordValidationRules;
import com.xamlab.schedulee.viewModels.base.implementation.BaseViewModelValidator;

public class MainValidator extends BaseViewModelValidator {

    public MainValidator(MainViewModel viewModel) {

        addRule(viewModel.name, String.class, new NameValidationRules());
        addRule(viewModel.password, String.class, new PasswordValidationRules());

    }
}
