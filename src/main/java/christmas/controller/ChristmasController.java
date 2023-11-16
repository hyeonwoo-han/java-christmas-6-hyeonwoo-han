package christmas.controller;

import christmas.model.Calendar;
import christmas.model.EventPlanner;
import christmas.model.OrderMachine;
import christmas.view.InputView;
import christmas.view.OutputView;
import java.util.Map;

public class ChristmasController {
    private final InputView inputView;
    private final OutputView outputView;

    public ChristmasController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void runEventPlanner() {
        outputView.sayGreeting();
        int visitDate = getVisitDate();
        Map<String, Integer> menusAndCounts = order();
        outputView.previewEventBenefit(visitDate);
        OrderMachine orderMachine = new OrderMachine(menusAndCounts);
        EventPlanner eventPlanner = new EventPlanner();
        outputView.confirmOrder(menusAndCounts);
        outputView.printTotalMoneyBeforeDiscount(orderMachine.getTotalMoneyBeforeDiscount());
        if (!orderMachine.canDiscountStart()) {
            showResult(orderMachine, eventPlanner);
            return;
        }
        addAppliedEventsByDate(visitDate, menusAndCounts, eventPlanner);
        addAppliedEventByTotalPrice(menusAndCounts, orderMachine, eventPlanner);
        showResult(orderMachine, eventPlanner);
    }

    private int getVisitDate() {
        outputView.askVisittingDate();
        return inputView.getVisitDateInput();
    }

    private Map<String, Integer> order() {
        outputView.askOrder();
        return inputView.getOrderInput();
    }

    private void prepare() {

    }

    private void showResult(OrderMachine orderMachine, EventPlanner eventPlanner) {
        showEventDiscountInfo(eventPlanner);
        showTotalBenefit(eventPlanner);
        showTotalMoneyAfterDiscount(orderMachine, eventPlanner);
        showBadge(eventPlanner);
    }

    private void addAppliedEventsByDate(int visitDate, Map<String, Integer> menusAndCounts, EventPlanner eventPlanner) {
        Calendar calendar = new Calendar();
        if (calendar.doesMatchWithChristmasDDayEvent(visitDate)) {
            eventPlanner.generateChristmasDDayEvents(visitDate);
        }
        if (calendar.doesMatchWithStarredDatesEvent(visitDate)) {
            eventPlanner.generateStarredDatesEvents();
        }
        if (calendar.doesMatchWithWeekDaysEvent(visitDate)) {
            eventPlanner.generateWeekDaysEvents(menusAndCounts);
        }
        if (calendar.doesMatchWithWeekendsEvent(visitDate)) {
            eventPlanner.generateWeekendsEvent(menusAndCounts);
        }
    }

    private void addAppliedEventByTotalPrice(Map<String, Integer> menusAndCounts, OrderMachine orderMachine,
                                             EventPlanner eventPlanner) {
        if (orderMachine.doesMatchWithPresentEvent()) {
            eventPlanner.generatePresentEvent();
        }
    }

    private void showEventDiscountInfo(EventPlanner eventPlanner) {
        Map<String, Integer> discountInfos = eventPlanner.getEventDiscountInfo();
        outputView.printPresentMenu(discountInfos);
        outputView.printEventDiscountInfo(discountInfos);
    }

    private void showTotalBenefit(EventPlanner eventPlanner) {
        int totalBenefit = eventPlanner.getTotalBenefitAmount();
        outputView.printTotalBenefit(totalBenefit);
    }

    private void showTotalMoneyAfterDiscount(OrderMachine orderMachine, EventPlanner eventPlanner) {
        int totalDiscountAmount = eventPlanner.getTotalDiscountAmount();
        String totalMoneyAfterDiscount = orderMachine.getTotalMoneyAfterDiscount(totalDiscountAmount);
        outputView.printTotalMoneyAfterDiscount(totalMoneyAfterDiscount);
    }

    private void showBadge(EventPlanner eventPlanner) {
        String badgeName = eventPlanner.getBadgeNameByDiscount();
        outputView.printBadge(badgeName);
    }
}
