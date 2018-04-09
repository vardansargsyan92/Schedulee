package com.xamlab.schedulee.utilities;

import com.baidu.unbiz.fluentvalidator.ValidatorContext;


public class NameValidationRules extends BaseValidationRules<String> {


    private final String nameIsToShort = "The name is to short";
    private final String nameIsRequired = "The name is required";
    private final String nameIsToLong = "The name is to long";

    @Override
    public boolean validate(ValidatorContext context, String s) {

        clear();

        if (s.length() < 4) addMessage(nameIsToShort);

        if (s.isEmpty()) addMessage(nameIsRequired);

        if (s.length() > 9) addMessage(nameIsToLong);

        return super.validate(context, s);
    }
}


