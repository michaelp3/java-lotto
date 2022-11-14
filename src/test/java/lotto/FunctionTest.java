package lotto;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.LinkedList;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class FunctionTest {

    @Test
    void validateMoneyInputTest() {
        String input = "18000";
        assertThat(Application.validateMoneyInput(input)).isEqualTo(18_000);
    }

    @Test
    void validateMoneyInputTest_예외처리() {
        String input = "-1";
        assertThatThrownBy(() -> {
            Application.validateMoneyInput(input);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void inMoneyRangeTest_FalseCase() {
        int input = -1;
        assertThat(Application.inMoneyRange(input)).isEqualTo(false);
    }

    @Test
    void inMoneyRangeTest_TrueCase() {
        int input = 8000;
        assertThat(Application.inMoneyRange(input)).isEqualTo(true);
    }

    @Test
    void divisibleByThousandTest_TrueCase() {
        int input = 5000;
        assertThat(Application.divisibleByThousand(input)).isEqualTo(true);
    }

    @Test
    void divisibleByThousandTest_FalseCase() {
        int input = 5001;
        assertThat(Application.divisibleByThousand(input)).isEqualTo(false);
    }

    @Test
    void calculateNumberOfLotteriesTest() {
        int money = 8000;
        assertThat(Application.calculateNumberOfLotteries(money)).isEqualTo(8);
    }

    @Test
    void randomPickLotteries_로또_개수_테스트() {
        List<Lotto> lotteries = new LinkedList<>();
        int numberOfLotteries = 8;

        Application.randomPickLotteries(lotteries, numberOfLotteries);
        assertThat(lotteries.size()).isEqualTo(numberOfLotteries);
    }
}