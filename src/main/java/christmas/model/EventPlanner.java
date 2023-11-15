package christmas.model;

import christmas.constants.Badge;
import christmas.model.events.ChristmasDDayEvent;
import christmas.model.events.Event;
import christmas.model.events.PresentEvent;
import christmas.model.events.StarredDatesEvent;
import christmas.model.events.WeekDaysEvent;
import christmas.model.events.WeekendsEvent;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class EventPlanner {
    private static final Set<Event> appliedEvents = new HashSet<>();

    public void generateStarredDatesEvents() {
        appliedEvents.add(new StarredDatesEvent());
    }

    public void generatePresentEvent() {
        appliedEvents.add(new PresentEvent());
    }

    public void generateChristmasDDayEvents(int visitDate) {
        appliedEvents.add(new ChristmasDDayEvent(visitDate));
    }

    public void generateWeekDaysEvents(Map<String, Integer> menusAndCounts) {
        appliedEvents.add(new WeekDaysEvent(menusAndCounts));
    }

    public void generateWeekendsEvent(Map<String, Integer> menusAndCounts) {
        appliedEvents.add(new WeekendsEvent(menusAndCounts));
    }

    public Map<String, Integer> getEventDiscountInfo() {
        if (appliedEvents.isEmpty()) {
            return Map.of("없음", 0);
        }
        return appliedEvents.stream()
                .collect(Collectors.toMap(
                        Event::getEventName,
                        Event::getDiscountAmount,
                        (oldValue, newValue) -> newValue)
                );
    }

    // total benefit = total discount + present price
    public int getTotalBenefitAmount() {
        int totalBenefitAmount = 0;
        for (Event event : appliedEvents) {
            totalBenefitAmount += event.getDiscountAmount();
        }
        return totalBenefitAmount;
    }

    public int getTotalDiscountAmount() {
        int totalDiscountAmount = 0;
        for (Event event : appliedEvents) {
            if (!(event instanceof PresentEvent)) {
                totalDiscountAmount += event.getDiscountAmount();
            }
        }
        System.out.println(totalDiscountAmount);
        return totalDiscountAmount;
    }

    public String getBadgeNameByDiscount() {
        if (getTotalBenefitAmount() >= Badge.SANTA_BADGE.getCondition()) {
            return Badge.SANTA_BADGE.getName();
        }
        if (getTotalBenefitAmount() >= Badge.TREE_BADGE.getCondition()) {
            return Badge.TREE_BADGE.getName();
        }
        if (getTotalBenefitAmount() >= Badge.STAR_BADGE.getCondition()) {
            return Badge.STAR_BADGE.getName();
        }
        return "없음";
    }
}
