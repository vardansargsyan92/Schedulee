package com.xamlab.schedulee.viewModels.auth;

import com.baidu.unbiz.fluentvalidator.ValidatorContext;
import com.xamlab.schedulee.utilities.BaseValidationRules;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class EmailValidationRules extends BaseValidationRules<String> {

    private static final String emailRequired = "Email is required";
    private static final String invalidEmail = "Please enter a valid email address";

    public static final Pattern regex =
            Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);

    @Override
    public boolean validate(ValidatorContext context, String s) {
        clear();

        Matcher matcher = regex.matcher(s);
        if (!matcher.find()) addMessage(invalidEmail);

        if (s.isEmpty()) addMessage(emailRequired);

        return super.validate(context, s);
    }
}
