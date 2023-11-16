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
        while (true) {
            try {
                String invalidVisitDate = Console.readLine();
                return inputValidation.getValidatedVisitDate(invalidVisitDate);
            } catch (IllegalArgumentException exception) {
                System.out.println(ErrorMessage.DATE_ERROR.getContent());
            }
        }
    }

    public Map<String, Integer> getOrderInput() {
        while (true) {
            try {
                String invalidOrders = Console.readLine();
                return inputValidation.getValidatedOrder(invalidOrders);
            } catch (IllegalArgumentException exception) {
                System.out.println(ErrorMessage.ORDER_ERROR.getContent());
            }
        }
    }
}
