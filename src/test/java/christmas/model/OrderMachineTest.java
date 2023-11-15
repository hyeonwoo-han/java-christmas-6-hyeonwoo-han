package christmas.model;

import static org.assertj.core.api.Assertions.assertThat;

import christmas.model.events.ChristmasDDayEvent;
import christmas.model.events.Event;
import christmas.model.events.StarredDatesEvent;
import christmas.model.events.WeekDaysEvent;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class OrderMachineTest {
    private final Map<String, Integer> menusAndCounts = new HashMap<>() {{
        put("해산물파스타", 2);
        put("레드와인", 2);
        put("아이스크림", 3);
    }};
    private final OrderMachine orderMachine = new OrderMachine(menusAndCounts);

    @Test
    @DisplayName("주문 기계 할인 전 총금액 테스트")
    public void orderMachineTotalMoneyBeforeDiscountTest() {
        assertThat(orderMachine.getTotalMoneyBeforeDiscount())
                .contains("205,000원");
    }

    @Test
    @DisplayName("주문 기계 할인 후 총금액 테스트")
    public void orderMachineTotalMoneyAfterDiscountTest() {
        Event christmasEvent = new ChristmasDDayEvent(3); // 1200
        Event starredDatesEvent = new StarredDatesEvent();          // 1000
        Event weekDaysEvent = new WeekDaysEvent(menusAndCounts);    // 2023 * 3(디저트 개수) = 6069
        HashSet<Event> appliedEvents = new HashSet<>(List.of(christmasEvent, starredDatesEvent, weekDaysEvent));

        assertThat(orderMachine.getTotalMoneyAfterDiscount(appliedEvents))
                .contains("196,731원");
    }
}
