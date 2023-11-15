package christmas.model.events;

public class ChristmasDDayEvent implements Event {
    private static final String eventName = "크리스마스 디데이 할인";
    private final int discountAmount;

    public ChristmasDDayEvent(int discountAmount) {
        this.discountAmount = discountAmount;
    }

    public String getEventName() {
        return eventName;
    }

    public int getDiscountAmount() {
        return this.discountAmount;
    }
}
