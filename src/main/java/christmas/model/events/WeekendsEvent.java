package christmas.model.events;

import christmas.constants.MainDish;
import java.util.Map;

public class WeekendsEvent implements Event {
    private static final int DISCOUNT_UNIT_PRICE = 2023;
    private static final String eventName = "주말 할인";
    private final int discountAmount;

    public WeekendsEvent(Map<String, Integer> menusAndCounts) {
        this.discountAmount = calculateDiscountAmount(menusAndCounts);
    }

    public String getEventName() {
        return eventName;
    }

    public int getDiscountAmount() {
        return this.discountAmount;
    }

    private int calculateDiscountAmount(Map<String, Integer> menusAndCounts) {
        int discountAmount = 0;
        for (String menu : menusAndCounts.keySet()) {
            if (containsMainDish(menu)) {
                discountAmount += DISCOUNT_UNIT_PRICE * menusAndCounts.get(menu);
            }
        }
        return discountAmount;
    }

    private boolean containsMainDish(String menu) {
        for (MainDish mainDish : MainDish.values()) {
            if (mainDish.getName().equals(menu)) {
                return true;
            }
        }
        return false;
    }
}
