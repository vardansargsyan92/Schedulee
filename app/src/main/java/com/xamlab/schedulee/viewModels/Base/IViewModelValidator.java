package com.xamlab.schedulee.viewModels.Base;

import android.databinding.ObservableArrayMap;
import android.databinding.ObservableField;

import java.util.ArrayList;

public interface IViewModelValidator {

    boolean validate(ObservableField property);

    boolean validateAll();

    ObservableArrayMap<ObservableField, String> getErrors();

    ArrayList<String> getAllErrorsInString();

    String getError(ObservableField property);

}
