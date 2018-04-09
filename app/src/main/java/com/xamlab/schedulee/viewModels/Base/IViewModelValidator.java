package com.xamlab.schedulee.viewModels.Base;

import android.databinding.ObservableArrayMap;
import android.databinding.ObservableField;

public interface IViewModelValidator {

    boolean validate(ObservableField property);

    boolean validateAll();

    ObservableArrayMap<ObservableField, String> getAllErrors();

    String getError(ObservableField property);

}
