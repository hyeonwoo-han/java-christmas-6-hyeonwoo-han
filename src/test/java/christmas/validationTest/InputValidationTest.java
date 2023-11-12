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
        assertThatThrownBy(() -> inputValidation.validEventDate(input))
                .isExactlyInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.");
    }
}
