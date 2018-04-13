package com.xamlab.schedulee.viewModels.main;

import com.xamlab.schedulee.bindings.Command;


public class TestCommand extends Command {

    private MainViewModel viewModel;


    public TestCommand(MainViewModel viewModel) {
        this.viewModel = viewModel;
    }

    @Override
    public void execute() {

        this.viewModel.validator.validateAll();
        setEnabled(false);

    }
}
