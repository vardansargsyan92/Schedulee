package com.xamlab.schedulee.controls;

import android.content.Context;
import android.databinding.BindingAdapter;
import android.databinding.ObservableArrayMap;
import android.databinding.ObservableField;
import android.support.design.widget.TextInputLayout;
import android.util.AttributeSet;



public class EntryEx extends TextInputLayout {


    public EntryEx(Context context) {
        super(context);
    }

    public EntryEx(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public EntryEx(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    @BindingAdapter(value = {"errors","property"})
    public static void setError(TextInputLayout textInputLayout,
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
