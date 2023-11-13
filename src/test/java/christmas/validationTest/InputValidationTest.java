package christmas.validationTest;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import christmas.validation.InputValidation;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class InputValidationTest {

    private final InputValidation inputValidation = new InputValidation();

    @ParameterizedTest
    @ValueSource(strings = {"삼십일", "32", " ", "2023.12.12", "2023-12-12"})
    @DisplayName("날짜 검증 테스트")
    public void validDateTest(String input) {
        assertThatThrownBy(() -> inputValidation.validateEventDate(input))
                .isExactlyInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"해산물파스타:2,레드와인:2", "알리오올리오:1,타파스:2", "해산물파스타:0,레드와인:2", "해산물파스타:2,해산물파스타:1,레드와인1", "레드와인:1",
            "해산물파스타:15,레드와인:6"})
    @DisplayName("주문 메뉴 검증 테스트")
    public void validateOrderTest(String input) {
        assertThatThrownBy(() -> inputValidation.validateOrder(input))
                .isExactlyInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
    }
}
