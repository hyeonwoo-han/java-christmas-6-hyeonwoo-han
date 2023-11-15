package christmas.model.events;

public class ChristmasDDayEvent implements Event {
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
            return 1000;
        }
        // visitDate is not DECEMBER_FIRST
        return 1000 + ((visitDate - DECEMBER_FIRST) * 100);
    }
}
