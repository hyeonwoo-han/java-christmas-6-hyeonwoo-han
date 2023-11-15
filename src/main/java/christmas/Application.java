package christmas;

import christmas.controller.ChristmasController;
import christmas.validation.InputValidation;
import christmas.view.InputView;
import christmas.view.OutputView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        InputView inputView = new InputView(new InputValidation());
        OutputView outputView = new OutputView();
        ChristmasController christmasController = new ChristmasController(inputView, outputView);
        christmasController.runEventPlanner();
    }
}
