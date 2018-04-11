package com.xamlab.schedulee.bindings;

import android.databinding.BaseObservable;

import com.xamlab.schedulee.BR;


public abstract class Command extends BaseObservable implements ICommand {

    private boolean isEnabled;
    private boolean isRefreshing;


    public Command() {
        setEnabled(true);
        setRefreshing(false);
    }


    @Override
    public boolean isEnabled() {
        return this.isEnabled;
    }

    @Override
    public void setEnabled(boolean value) {
        this.isEnabled = value;
        notifyPropertyChanged(BR._all);
    }

    @Override
    public boolean isRefreshing() {
        return this.isRefreshing;
    }

    @Override
    public void setRefreshing(boolean value) {
        this.isRefreshing = value;
        notifyPropertyChanged(BR._all);
    }

}
