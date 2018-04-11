package com.xamlab.schedulee.viewModels.main;

import com.xamlab.schedulee.bindings.Command;

public class TestCommand extends Command {

    private  MainViewModel viewModel;


    public TestCommand(MainViewModel viewModel){
        this.viewModel=viewModel;
    }

    @Override
    public void execute() {

        boolean b= isEnabled();
        this.viewModel.setPassword("sasfgfsgfd");
        setEnabled(false);
    }
}
