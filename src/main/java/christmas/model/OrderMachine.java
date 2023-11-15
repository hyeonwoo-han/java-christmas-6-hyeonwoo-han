package christmas.model;

import christmas.constants.menus.Appetizer;
import christmas.constants.menus.Dessert;
import christmas.constants.menus.Drink;
import christmas.constants.menus.MainDish;
import christmas.constants.menus.Menu;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.Map;

public class OrderMachine {
    private static final int DISCOUNT_START_CONDITION = 10000;
    private static final int PRESENT_EVENT_CONDITION = 120000;
    private final int totalMoneyBeforeDiscount;

    public OrderMachine(Map<String, Integer> menusAndCounts) {
        this.totalMoneyBeforeDiscount = calculateTotalMoneyBeforeDiscount(menusAndCounts);
    }

    public String getTotalMoneyBeforeDiscount() {
        return formatNumberAsCurrency(this.totalMoneyBeforeDiscount);
    }

    public String getTotalMoneyAfterDiscount(int totalDiscountAmount) {
        int totalMoneyAfterDiscount = calculateTotalMoneyAfterDiscount(totalDiscountAmount);
        return formatNumberAsCurrency(totalMoneyAfterDiscount);
    }

    public boolean canDiscountStart() {
        return totalMoneyBeforeDiscount >= DISCOUNT_START_CONDITION;
    }

    public boolean doesMatchWithPresentEvent() {
        return totalMoneyBeforeDiscount >= PRESENT_EVENT_CONDITION;
    }

    private int calculateTotalMoneyBeforeDiscount(Map<String, Integer> menusAndCounts) {
        int sum = 0;
        for (String menu : menusAndCounts.keySet()) {
            sum += findMenuPrice(menu, menusAndCounts.get(menu), Appetizer.class);
            sum += findMenuPrice(menu, menusAndCounts.get(menu), Dessert.class);
            sum += findMenuPrice(menu, menusAndCounts.get(menu), Drink.class);
            sum += findMenuPrice(menu, menusAndCounts.get(menu), MainDish.class);
        }
        return sum;
    }

    private int calculateTotalMoneyAfterDiscount(int totalDiscountAmount) {
        return this.totalMoneyBeforeDiscount - totalDiscountAmount;
    }

    private String formatNumberAsCurrency(int money) {
        NumberFormat formatter = NumberFormat.getNumberInstance(Locale.US);
        formatter.setGroupingUsed(true);
        return formatter.format(money) + "원";
    }

    private <E extends Enum<E> & Menu> int findMenuPrice(String menuName, int count, Class<E> menuEnumClass) {
        for (E menu : menuEnumClass.getEnumConstants()) {
            if (menu.getName().equals(menuName)) {
                return menu.getPrice() * count;
            }
        }
        return 0;
    }
}
