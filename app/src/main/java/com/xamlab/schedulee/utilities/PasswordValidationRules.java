package com.xamlab.schedulee.utilities;

import com.baidu.unbiz.fluentvalidator.ValidatorContext;

public class PasswordValidationRules extends BaseValidationRules<String> {

    private final String passwordIsRequired = "The password is required";
    private final String passwordIsToShort = "The password is to short";

    @Override
    public boolean validate(ValidatorContext context, String s) {
        clear();
        if (s.isEmpty()) addMessage(passwordIsRequired);
        if (s.length() < 4) addMessage(passwordIsToShort);
        return super.validate(context, s);
    }
}
