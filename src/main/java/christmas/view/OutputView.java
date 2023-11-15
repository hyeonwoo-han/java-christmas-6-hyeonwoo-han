package christmas.view;

import christmas.constants.Message;
import java.util.Map;

public class OutputView {
    public void sayGreeting() {
        System.out.println(Message.GREETING);
    }

    public void askVisittingDate() {
        System.out.println(Message.ASK_VISITING_DATE);
    }

    public void askOrder() {
        System.out.println(Message.ASK_ORDER);
    }

    public void previewEventBenefit(int visitDate) {
        System.out.println(Message.PREVIEW_EVENT_BENEFIT.getEventPreviewMsg(visitDate));
    }

    public void confirmOrder(Map<String, Integer> menusAndCounts) {
        System.out.println(Message.ORDERED_MENU_INFORM);
        for (String menu : menusAndCounts.keySet()) {
            int count = menusAndCounts.get(menu);
            System.out.println(menu + " " + count + "개");
        }
    }
}
