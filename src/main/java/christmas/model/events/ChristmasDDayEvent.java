package christmas.model.events;

public class ChristmasDDayEvent implements Event {
    private static final int BASE_DISCOUNT_PRICE = 1000;
    private static final int DISCOUNT_INCREMENT_UNIT_PRICE = 100;

    private static final int DECEMBER_FIRST = 1;
    private static final String eventName = "크리스마스 디데이 할인";
    private final int discountAmount;

    public ChristmasDDayEvent(int visitDate) {
        this.discountAmount = calculateDiscountAmount(visitDate);
    }

    public String getEventName() {
        return eventName;
    }

    public int getDiscountAmount() {
        return this.discountAmount;
    }

    private int calculateDiscountAmount(int visitDate) {
        if (visitDate == DECEMBER_FIRST) {
            return BASE_DISCOUNT_PRICE;
        }
        // visitDate is not DECEMBER_FIRST
        return BASE_DISCOUNT_PRICE + ((visitDate - DECEMBER_FIRST) * DISCOUNT_INCREMENT_UNIT_PRICE);
    }
}
