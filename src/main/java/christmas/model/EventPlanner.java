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

    // 적용된 이벤트들의 이름, 할인금액 Map 반환
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

    // 적용된 이벤트들의 총 혜택 금액 계산 후 반환
    public int getTotalDiscountAmount() {
        int totalDiscountAmount = 0;
        for (Event event : appliedEvents) {
            totalDiscountAmount += event.getDiscountAmount();
        }
        return totalDiscountAmount;
    }

    // 총 혜택 금액에 따라 뱃지 이름을 반환
    public String getBadgeNameByDiscount() {
        if (getTotalDiscountAmount() >= Badge.SANTA_BADGE.getCondition()) {
            return Badge.SANTA_BADGE.getName();
        }
        if (getTotalDiscountAmount() >= Badge.TREE_BADGE.getCondition()) {
            return Badge.TREE_BADGE.getName();
        }
        if (getTotalDiscountAmount() >= Badge.STAR_BADGE.getCondition()) {
            return Badge.STAR_BADGE.getName();
        }
        return "없음";
    }
}
