package christmas.model;

public class PresentEvent implements Event {
    private static final String eventName = "증정 이벤트";
    private final int discountAmount;

    public PresentEvent(int discountAmount) {
        this.discountAmount = discountAmount;
    }

    public String getEventName() {
        return eventName;
    }

    public int getDiscountAmount() {
        return this.discountAmount;
    }
}
