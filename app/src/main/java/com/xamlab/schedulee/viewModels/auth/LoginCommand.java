package com.xamlab.schedulee.viewModels.auth;

import com.xamlab.schedulee.bindings.Command;

public class LoginCommand extends Command {

    private LoginViewModel viewModel;

    public LoginCommand(LoginViewModel viewModel) {
        this.viewModel = viewModel;
    }

    @Override
    public void execute() {
        viewModel.validator.validateAll();
        /*if (viewModel.validator.getAllErrorsInString().size() != 0) setEnabled(false);*/
    }
}
