package christmas.model;

public class StarredDatesEvent implements Event {
    private static final String eventName = "특별 할인";
    private final int discountAmount;

    public StarredDatesEvent(int discountAmount) {
        this.discountAmount = discountAmount;
    }

    public String getEventName() {
        return eventName;
    }

    public int getDiscountAmount() {
        return this.discountAmount;
    }
}
