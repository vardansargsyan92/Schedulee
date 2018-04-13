package com.xamlab.schedulee.viewModels.auth;

import com.baidu.unbiz.fluentvalidator.ValidatorContext;
import com.xamlab.schedulee.utilities.BaseValidationRules;

public class PasswordValidationRules extends BaseValidationRules<String> {

    private final String passwordIsRequired = "Password is required";
    private final String passwordIsToShort = "Password is to short";

    @Override
    public boolean validate(ValidatorContext context, String s) {
        clear();
        if (s.isEmpty()) addMessage(passwordIsRequired);
        if (s.length() < 4) addMessage(passwordIsToShort);
        return super.validate(context, s);
    }
}
