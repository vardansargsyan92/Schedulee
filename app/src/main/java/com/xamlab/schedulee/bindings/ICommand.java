package com.xamlab.schedulee.bindings;

import android.databinding.Bindable;
import android.databinding.Observable;

public interface ICommand extends Observable {

    @Bindable
    boolean isEnabled();

    void setEnabled(boolean value);

    @Bindable
    boolean isRefreshing();

    void setRefreshing(boolean value);

    void execute();

    /*void execute(Object parameter);*/


}
