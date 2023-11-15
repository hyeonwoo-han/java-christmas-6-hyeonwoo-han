package christmas.model.events;

import christmas.constants.MainDish;
import java.util.Map;

public class WeekendsEvent implements Event {
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
                discountAmount += 2023;
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
