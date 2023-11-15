package christmas.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class EventPlannerTest {
    private final int visitDate = 3;
    private final Map<String, Integer> menusAndCounts = new HashMap<>() {{
        put("해산물파스타", 2);
        put("레드와인", 2);
        put("아이스크림", 3);
    }};

    private void generateEvenets(EventPlanner eventPlanner) {
        eventPlanner.generateChristmasDDayEvents(visitDate);
        eventPlanner.generateStarredDatesEvents();
        eventPlanner.generatePresentEvent();
        eventPlanner.generateWeekDaysEvents(menusAndCounts);
    }

    @Test
    @DisplayName("조건에 따라 이벤트 생성후 확인 테스트")
    public void generateEventsTest() {
        EventPlanner eventPlanner = new EventPlanner();
        generateEvenets(eventPlanner);

        assertThat(eventPlanner.getEventDiscountInfo().toString())
                .contains("크리스마스 디데이 할인", "특별 할인", "증정 이벤트", "평일 할인");
    }

    @Test
    @DisplayName("조건에 따라 뱃지 이름 반환 확인 테스트")
    public void getBadgeNameByDiscountTest() {
        EventPlanner eventPlanner = new EventPlanner();
        generateEvenets(eventPlanner);

        assertThat(eventPlanner.getBadgeNameByDiscount())
                .contains("산타");
    }
}
