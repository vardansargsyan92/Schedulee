package com.xamlab.schedulee.bindings;

import android.databinding.BindingAdapter;
import android.view.View;

public class ViewBIndings {

    @BindingAdapter(value = {"command"})
    public static void bindViewCommand(View view, final ICommand command) {
        view.setOnClickListener(v -> {
            command.execute();
        });
    }
}
