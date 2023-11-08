package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class InputManager {
    public static final int WINNING_NUMBER_SIZE = 6;

    public int inputMoney() {
        int moneyInput = 0;
        while (true) {
            try {
                System.out.println("구입금액을 입력해 주세요.");
                moneyInput = Integer.parseInt(Console.readLine().replaceAll("\\s", ""));
                InputValidator.checkDivisibleBy1000(moneyInput);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return moneyInput;
    }

    public List<Integer> inputWinningNumbers() {
        List<Integer> winningLottoNumbers = new ArrayList<>();
        while (true) {
            try {
                System.out.println("\n당첨 번호를 입력해 주세요.");
                String winningNumbersInput = Console.readLine();
                InputValidator.checkValidInput(winningNumbersInput);
                String[] winningNumbers = winningNumbersInput.split(",");
                for (String winningNumber : winningNumbers) {
                    winningLottoNumbers.add(Integer.parseInt(winningNumber.trim()));
                }
                InputValidator.checkWinningNumbers(winningLottoNumbers, WINNING_NUMBER_SIZE);
                return winningLottoNumbers;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
