package com.xamlab.schedulee.viewModels.base.implementation;

import android.databinding.Observable;
import android.databinding.ObservableArrayMap;
import android.databinding.ObservableField;
import android.util.Log;

import com.baidu.unbiz.fluentvalidator.FluentValidator;
import com.baidu.unbiz.fluentvalidator.Result;
import com.baidu.unbiz.fluentvalidator.Validator;
import com.xamlab.schedulee.viewModels.base.IViewModelValidator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static com.baidu.unbiz.fluentvalidator.ResultCollectors.toSimple;

public class BaseViewModelValidator implements IViewModelValidator {


    private final String TAG = "BaseValidateableViewModel : LOGS ";

    private Map<ObservableField, Validator> validationRules = new HashMap<>();

    private ObservableArrayMap<ObservableField, String> errors = new ObservableArrayMap<>();


    private HashMap<ObservableField, Class> propertiesClassMap = new HashMap<>();


    protected void addRule(ObservableField property, Class propertyClass, Validator validator) {



        property.addOnPropertyChangedCallback(new Observable.OnPropertyChangedCallback() {
            @Override
            public void onPropertyChanged(android.databinding.Observable sender, int propertyId) {
                PropertyChanged(sender);
            }
        });


        if (!validationRules.containsKey(property)) {

            if (!propertiesClassMap.containsKey(property)) {
                propertiesClassMap.put(property, propertyClass);
            }

            validationRules.put(property, validator);
        }
    }

    private void PropertyChanged(android.databinding.Observable sender) {

        ObservableField property = (ObservableField) sender;
        if (validationRules.size() == 0) {
            Log.e(TAG, "There isn't t any defined validation rule");
            return;
        }
        validate(property);

    }


    @Override
    public boolean validate(ObservableField property) {


        if (errors.containsKey(property)) {
            errors.remove(property);
        }


        if (property.get() == null) {
            Class c = propertiesClassMap.get(property);
            try {
                property.set(c.newInstance());
            } catch (InstantiationException | IllegalAccessException e) {
                e.printStackTrace();
            }

        }

        Result result = FluentValidator.checkAll().on(property.get(),
                validationRules.get(property)).doValidate().result(toSimple());


        if (!result.isSuccess()) {
            errors.put(property, result.getErrors().get(0));

            return false;
        }
        return true;

    }

    @Override
    public boolean validateAll() {
        boolean isValid = true;
        for (ObservableField property : validationRules.keySet()) {
            boolean result = validate(property);
            if (!result) isValid = false;

        }
        return isValid;
    }


    @Override
    public String getError(ObservableField property) {
        if (errors.containsKey(property)) {
            return errors.get(property);
        }
        return "";
    }

    @Override
    public ObservableArrayMap<ObservableField, String> getErrors() {
        return errors;
    }

    @Override
    public ArrayList<String> getAllErrorsInString() {
        ArrayList<String> res = new ArrayList<>();
        for (ObservableField item : errors.keySet()) {
            res.add(errors.get(item));
        }
        return res;

    }


}
