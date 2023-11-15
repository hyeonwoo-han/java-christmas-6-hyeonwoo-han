package christmas.model.events;

public class StarredDatesEvent implements Event {
    private static final String eventName = "특별 할인";
    private final int discountAmount;

    public StarredDatesEvent() {
        this.discountAmount = 1000;
    }

    public String getEventName() {
        return eventName;
    }

    public int getDiscountAmount() {
        return this.discountAmount;
    }
}
