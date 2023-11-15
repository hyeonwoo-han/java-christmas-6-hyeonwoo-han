package christmas.model;

import christmas.constants.Appetizer;
import christmas.constants.Dessert;
import christmas.constants.Drink;
import christmas.constants.MainDish;
import christmas.constants.Menu;
import christmas.model.events.Event;
import java.text.NumberFormat;
import java.util.HashSet;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

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

    public String getTotalMoneyAfterDiscount(HashSet<Event> appliedEvents) {
        int totalMoneyAfterDiscount = calculateTotalMoneyAfterDiscount(appliedEvents);
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

    private int calculateTotalMoneyAfterDiscount(Set<Event> appliedEvents) {
        int totalDiscountAmount = 0;
        for (Event event : appliedEvents) {
            totalDiscountAmount += event.getDiscountAmount();
        }
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
