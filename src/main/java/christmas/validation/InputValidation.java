package christmas.validation;

import christmas.constants.ErrorMessage;
import java.util.Arrays;
import java.util.List;

public class InputValidation {


    public void validateEventDate(String input) {
        int date = convertIntoNumber(input);
        if (date < 1 || date > 31) {
            throw new IllegalArgumentException(ErrorMessage.DATE_ERROR.getContent());
        }
    }

    public void validateOrder(String input) {
        List<String> menuAndCount = Arrays.asList(input.split(","));
    }

    private void validateOrderFormat() {

    }

    private void checkMenu() {

    }

    private void isMenuMoreThanOne() {

    }

    private void hasDuplicatedMenu() {

    }

    private void isNotOnlyDrink() {

    }

    private void isMenuLessThanTwentyOne() {

    }

    private int convertIntoNumber(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException(ErrorMessage.DATE_ERROR.getContent());
        }
    }
}
