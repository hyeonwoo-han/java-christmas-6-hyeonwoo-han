package christmas.view;

import christmas.constants.Message;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.Map;

public class OutputView {
    public void sayGreeting() {
        System.out.println(Message.GREETING.getContent());
    }

    public void askVisittingDate() {
        System.out.println(Message.ASK_VISITING_DATE.getContent());
    }

    public void askOrder() {
        System.out.println(Message.ASK_ORDER.getContent());
    }

    public void previewEventBenefit(int visitDate) {
        System.out.println(Message.PREVIEW_EVENT_BENEFIT.getEventPreviewMsg(visitDate));
        System.out.print("\n");
    }

    public void confirmOrder(Map<String, Integer> menusAndCounts) {
        System.out.println(Message.ORDERED_MENU_INFORM.getContent());
        for (String menu : menusAndCounts.keySet()) {
            int count = menusAndCounts.get(menu);
            System.out.println(menu + " " + count + "개");
        }
        System.out.println("\n");
    }

    public void printTotalMoneyBeforeDiscount(String formattedTotalMoneyBeforeDiscount) {
        System.out.println(Message.TOTAL_PRICE_BEFORE_DISCOUNT_INFORM.getContent());
        System.out.println(formattedTotalMoneyBeforeDiscount);
    }

    public void printTotalMoneyAfterDiscount(String formattedTotalMoneyAfterDiscount) {
        System.out.println(Message.DISCOUNTED_TOTAL_PRICE_INFORM.getContent());
        System.out.println(formattedTotalMoneyAfterDiscount);
        System.out.print("\n");
    }

    public void printPresentMenu(Map<String, Integer> eachBenefits) {
        System.out.println(Message.GIFT_INFORM.getContent());
        if (eachBenefits.containsKey("증정 이벤트")) {
            System.out.println(Message.ONE_CHAMPAGNE.getContent());
            System.out.print("\n");
            return;
        }
        System.out.println("없음");
        System.out.print("\n");
    }

    public void printEventDiscountInfo(Map<String, Integer> eachBenefits) {
        System.out.println(Message.BENEFIT_INFORM.getContent());
        for (String event : eachBenefits.keySet()) {
            if (event.equals("없음")) {
                System.out.println(event);
            }
            String formattedBenefit = formatNumberAsCurrency(eachBenefits.get(event));
            System.out.println(event + ": -" + formattedBenefit);
        }
        System.out.print("\n");
    }

    public void printTotalBenefit(int totalBenefit) {
        System.out.println(Message.TOTAL_BENEFIT_INFORM.getContent());
        String formattedTotalBenefit = formatNumberAsCurrency(totalBenefit);
        System.out.println(formattedTotalBenefit);
        System.out.print("\n");
    }

    public void printBadge(String badgeName) {
        System.out.println(Message.BADGE_INFORM.getContent());
        System.out.println(badgeName);
    }

    private String formatNumberAsCurrency(int money) {
        NumberFormat formatter = NumberFormat.getNumberInstance(Locale.US);
        formatter.setGroupingUsed(true);
        return formatter.format(money) + "원";
    }
}
