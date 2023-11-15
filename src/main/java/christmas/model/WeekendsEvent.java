package christmas.model;

public class WeekendsEvent implements Event {
    private static final String eventName = "주말 할인";
    private final int discountAmount;

    public WeekendsEvent(int discountAmount) {
        this.discountAmount = discountAmount;
    }

    public String getEventName() {
        return eventName;
    }

    public int getDiscountAmount() {
        return this.discountAmount;
    }
}
