package com.xamlab.schedulee.controls;

import android.content.Context;
import android.databinding.BindingAdapter;
import android.databinding.ObservableArrayMap;
import android.databinding.ObservableField;
import android.support.design.widget.TextInputLayout;
import android.util.AttributeSet;



public class ValidatableTextInputLayout {

    @BindingAdapter(value = {"errors","property"})
    public static void setValidationProperties(TextInputLayout textInputLayout,
                                               ObservableArrayMap<ObservableField, String> errors,
                                               ObservableField property) {


        if (!errors.containsKey(property)) {
            textInputLayout.setError("");
            return;
        }
        String error = errors.get(property);
        if (error != null) {
            textInputLayout.setError(error);
        }


    }
}
