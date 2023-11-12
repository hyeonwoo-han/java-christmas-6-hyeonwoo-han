package christmas.validation;

import christmas.constants.ErrorMessage;

public class InputValidation {


    public void validEventDate(String input) {
        int date = convertIntoNumber(input);
        if (date < 1 || date > 31) {
            throw new IllegalArgumentException(ErrorMessage.DATE_ERROR.getContent());
        }
    }

    private int convertIntoNumber(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException(ErrorMessage.DATE_ERROR.getContent());
        }
    }
}
