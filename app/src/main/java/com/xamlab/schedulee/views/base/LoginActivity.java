package com.xamlab.schedulee.views.base;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

import com.xamlab.schedulee.MainApplication;
import com.xamlab.schedulee.R;
import com.xamlab.schedulee.services.IDataService;

import java.util.Date;

import javax.inject.Inject;

public class LoginActivity extends AppCompatActivity {

    @Inject
    IDataService dataService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

    }
}
