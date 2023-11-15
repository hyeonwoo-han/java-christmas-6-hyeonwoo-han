package christmas.model.events;

public class WeekDaysEvent implements Event {
    private static final String eventName = "평일 할인";
    private final int discountAmount;

    public WeekDaysEvent(int discountAmount) {
        this.discountAmount = discountAmount;
    }

    public String getEventName() {
        return eventName;
    }

    public int getDiscountAmount() {
        return this.discountAmount;
    }
}
