package christmas.view;

import christmas.constants.Message;
import java.text.NumberFormat;
import java.util.Locale;
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
        System.out.print("\n");
    }

    public void confirmOrder(Map<String, Integer> menusAndCounts) {
        System.out.println(Message.ORDERED_MENU_INFORM);
        for (String menu : menusAndCounts.keySet()) {
            int count = menusAndCounts.get(menu);
            System.out.println(menu + " " + count + "개");
        }
        System.out.println("\n");
    }

    public void printTotalMoneyBeforeDiscount(String formattedTotalMoneyBeforeDiscount) {
        System.out.println(Message.TOTAL_PRICE_BEFORE_DISCOUNT_INFORM);
        System.out.println(formattedTotalMoneyBeforeDiscount);
    }

    public void printTotalMoneyAfterDiscount(String formattedTotalMoneyAfterDiscount) {
        System.out.println(Message.DISCOUNTED_TOTAL_PRICE_INFORM);
        System.out.println(formattedTotalMoneyAfterDiscount);
    }

    public void printEventDiscountInfo(Map<String, Integer> eachBenefits) {
        System.out.println(Message.BENEFIT_INFORM);
        for (String event : eachBenefits.keySet()) {
            if (event.equals("없음")) {
                System.out.println(event);
            }
            String formattedBenefit = formatNumberAsCurrency(eachBenefits.get(event));
            System.out.println(event + ": -" + formattedBenefit);
        }
    }

    public void printTotalBenefit(int totalBenefit) {
        System.out.println(Message.TOTAL_BENEFIT_INFORM);
        String formattedTotalBenefit = formatNumberAsCurrency(totalBenefit);
        System.out.println(formattedTotalBenefit);
    }

    public void printBadge(String badgeName) {
        System.out.println(Message.BADGE_INFORM);
        System.out.println(badgeName);
    }

    private String formatNumberAsCurrency(int money) {
        NumberFormat formatter = NumberFormat.getNumberInstance(Locale.US);
        formatter.setGroupingUsed(true);
        return formatter.format(money) + "원";
    }
}
