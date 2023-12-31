package christmas.model.events;

import christmas.constants.menus.Dessert;
import java.util.Map;

public class WeekDaysEvent implements Event {
    private static final int DISCOUNT_UNIT_PRICE = 2023;
    private static final String eventName = "평일 할인";
    private final int discountAmount;

    public WeekDaysEvent(Map<String, Integer> menusAndCounts) {
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
            if (containsDessert(menu)) {
                discountAmount += DISCOUNT_UNIT_PRICE * menusAndCounts.get(menu);
            }
        }
        return discountAmount;
    }

    private boolean containsDessert(String menu) {
        for (Dessert dessert : Dessert.values()) {
            if (dessert.getName().equals(menu)) {
                return true;
            }
        }
        return false;
    }
}
