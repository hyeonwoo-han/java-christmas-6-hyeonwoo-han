package christmas.view;

import camp.nextstep.edu.missionutils.Console;
import christmas.constants.ErrorMessage;
import christmas.validation.InputValidation;
import java.util.Map;

public class InputView {
    private final InputValidation inputValidation;

    public InputView(InputValidation inputValidation) {
        this.inputValidation = inputValidation;
    }

    public int getVisitDateInput() {
        String invalidVisitDate = Console.readLine();
        while (true) {
            try {
                return inputValidation.getValidatedVisitDate(invalidVisitDate);
            } catch (IllegalArgumentException exception) {
                System.out.println(ErrorMessage.DATE_ERROR);
            }
        }
    }

    public Map<String, Integer> getOrderInput() {
        String invalidOrders = Console.readLine();
        while (true) {
            try {
                return inputValidation.getValidatedOrder(invalidOrders);
            } catch (IllegalArgumentException exception) {
                System.out.println(ErrorMessage.ORDER_ERROR);
            }
        }
    }
}
