package com.xamlab.schedulee.utilities;

import com.baidu.unbiz.fluentvalidator.Validator;
import com.baidu.unbiz.fluentvalidator.ValidatorContext;
import com.baidu.unbiz.fluentvalidator.ValidatorHandler;

import java.util.ArrayList;

public abstract class BaseValidationRules<T> extends ValidatorHandler<T> implements Validator<T> {

    private ArrayList<String> errorMessages = new ArrayList<>();


    public void addMessage(String validationErrorMessage) {
        if (errorMessages.stream().filter(m -> m.equals(validationErrorMessage)).toArray().length == 0) {
            errorMessages.add(validationErrorMessage);
        }
    }

    public void clear() {
        errorMessages = new ArrayList<>();
    }


    @Override
    public boolean validate(ValidatorContext context, T t) {

        if (errorMessages.size() == 0) {

            return true;
        }
        StringBuilder builder = new StringBuilder();
        for (String message : errorMessages) {
            builder.append(message);
            builder.append("\n");
        }
        context.addErrorMsg(builder.toString());
        return false;
    }
}
