package com.xamlab.schedulee.viewModels.Base.implementation;

import android.arch.lifecycle.ViewModel;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public abstract class BaseViewModel extends ViewModel {
    private final PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);
    private PropertyChangeListener listener;

    protected BaseViewModel() {
        addPropertyChangedListener();
    }

    private void addPropertyChangedListener() {


        listener = new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent e) {
                onPropertyChanged(e);
            }
        };
        propertyChangeSupport.addPropertyChangeListener(listener);
    }

    protected void onPropertyChanged(PropertyChangeEvent e) {

    }

    protected void raisePropertyChanged(String propertyName, Object oldValue, Object newValue) {
        propertyChangeSupport.firePropertyChange(propertyName, oldValue, newValue);
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        propertyChangeSupport.removePropertyChangeListener(listener);
    }
}
