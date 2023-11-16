package christmas.model.events;

public class PresentEvent implements Event {
    private static final int CHAMPAGNE_PRICE = 25000;
    private static final String eventName = "증정 이벤트";
    private final int discountAmount;

    public PresentEvent() {
        this.discountAmount = CHAMPAGNE_PRICE;
    }

    public String getEventName() {
        return eventName;
    }

    public int getDiscountAmount() {
        return this.discountAmount;
    }
}
