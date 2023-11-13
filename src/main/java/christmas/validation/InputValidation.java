package christmas.validation;

import christmas.constants.Appetizer;
import christmas.constants.Dessert;
import christmas.constants.Drink;
import christmas.constants.ErrorMessage;
import christmas.constants.MainDish;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class InputValidation {


    public void validateEventDate(String input) {
        int date = convertIntoNumber(input);
        if (date < 1 || date > 31) {
            throw new IllegalArgumentException(ErrorMessage.DATE_ERROR.getContent());
        }
    }

    public void validateOrder(String input) {
        HashMap<String, Integer> menusAndCounts = parseOrder(input);
        checkMenu(menusAndCounts);
        isMenuMoreThanOne(menusAndCounts);
        isNotOnlyDrink(menusAndCounts);
        isMenuLessThanTwentyOne(menusAndCounts);
    }

    private void checkMenu(HashMap<String, Integer> menusAndCounts) {
        menusAndCounts.keySet().forEach(menu -> {
            if (!(containsAppetiezer(menu) ||
                    containsMainDish(menu) ||
                    containsDessert(menu) ||
                    containsDrink(menu))) {
                throw new IllegalArgumentException(ErrorMessage.ORDER_ERROR.getContent());
            }
        });
    }

    private boolean containsAppetiezer(String menu) {
        for (Appetizer appetizer : Appetizer.values()) {
            if (appetizer.getName().equals(menu)) {
                return true;
            }
        }
        return false;
    }

    private boolean containsMainDish(String menu) {
        for (MainDish mainDish : MainDish.values()) {
            if (mainDish.getName().equals(menu)) {
                return true;
            }
        }
        return false;
    }

    private boolean containsDessert(String menu) {
        for (Dessert dessert : Dessert.values()) {
            if (dessert.getName().equals(menu)) {
                return true;
            }
        }
        return false;
    }

    private boolean containsDrink(String menu) {
        for (Drink drink : Drink.values()) {
            if (drink.getName().equals(menu)) {
                return true;
            }
        }
        return false;
    }

    private void isMenuMoreThanOne(HashMap<String, Integer> menusAndCounts) {
        menusAndCounts.forEach((menu, count) -> {
            if (count < 1) {
                throw new IllegalArgumentException(ErrorMessage.ORDER_ERROR.getContent());
            }
        });
    }

    private void hasDuplicatedMenu(HashMap<String, Integer> parsedByDash, String menu) {
        parsedByDash.keySet().forEach(key -> {
            if (key.equals(menu)) {
                throw new IllegalArgumentException(ErrorMessage.ORDER_ERROR.getContent());
            }
        });
    }

    private void isNotOnlyDrink(HashMap<String, Integer> menusAndCounts) {
        int countExceptDrink = 0;
        for (String menu : menusAndCounts.keySet()) {
            if (containsAppetiezer(menu) || containsMainDish(menu) || containsDessert(menu)) {
                countExceptDrink += 1;
            }
        }
        if (countExceptDrink < 1) {
            throw new IllegalArgumentException(ErrorMessage.ORDER_ERROR.getContent());
        }
    }

    private void isMenuLessThanTwentyOne(HashMap<String, Integer> menusAndCounts) {
        int totalOrderCount = 0;
        for (int value : menusAndCounts.values()) {
            totalOrderCount += value;
        }
        if (totalOrderCount > 20) {
            throw new IllegalArgumentException(ErrorMessage.ORDER_ERROR.getContent());
        }
    }

    private HashMap<String, Integer> parseOrder(String input) {
        try {
            List<String> parsedByComma = Arrays.asList(input.split(","));
            HashMap<String, Integer> parsedByDash = new HashMap<>();
            parsedByComma.forEach(order -> {
                String[] menuAndCountPerOrder = order.split("-");
                String menu = menuAndCountPerOrder[0];
                int count = convertIntoNumber(menuAndCountPerOrder[1]);
                hasDuplicatedMenu(parsedByDash, menu);
                parsedByDash.put(menu, count);
            });
            return parsedByDash;
        } catch (ArrayIndexOutOfBoundsException exception) {
            throw new IllegalArgumentException(ErrorMessage.ORDER_ERROR.getContent());
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
