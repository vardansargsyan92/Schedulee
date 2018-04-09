package com.xamlab.schedulee.views;

import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.xamlab.schedulee.MainApplication;
import com.xamlab.schedulee.R;
import com.xamlab.schedulee.databinding.ActivityMainBinding;
import com.xamlab.schedulee.services.IDataService;
import com.xamlab.schedulee.viewModels.main.MainViewModel;

import java.util.Date;

import javax.inject.Inject;


public class MainActivity extends AppCompatActivity {

    @Inject
    public IDataService dataService;


    private TextView textView;

    private MainViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initBindings();

        textView = findViewById(R.id.tv_text);
        ((MainApplication) getApplication()).getDataServiceComponent().inject(this);
        textView.setText(new Date(dataService.getDate()).toString());

        Button button= findViewById(R.id.validate_btn);
        button.setOnClickListener(view -> {
            viewModel.validator.validateAll();
            textView.setText(viewModel.validator.getError(viewModel.name));
        });



    }

    private void initBindings() {
        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        viewModel = ViewModelProviders.of(this).get(MainViewModel.class);
        binding.setMainViewModel(viewModel);

    }
}
