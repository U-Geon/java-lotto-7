package lotto.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.global.ErrorMessage;

public class Validator {

    public Validator() {}

    public static int isLottoPriceValid(String input) {
        try {
            int price = Integer.parseInt(input);
            if(price < 0) {
                throw new IllegalArgumentException(ErrorMessage.ILLEGAL_PRICE_ERROR);
            } else if(price % 1000 != 0) {
                throw new IllegalArgumentException(ErrorMessage.INVALID_PRICE_ERROR);
            }
            return price;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.ILLEGAL_PRICE_ERROR);
        }
    }

    public static String isEmpty(String input) {
        if(input.isEmpty()) {
            throw new IllegalArgumentException(ErrorMessage.EMPTY_INPUT_VALUE);
        }
        return input;
    }

    public static int isLottoNumberFormatValid(String input) {
        try {
            int number = Integer.parseInt(input);
            if(number < 0 || number > 45) {
                throw new IllegalArgumentException(ErrorMessage.ILLEGAL_LOTTO_NUMBER);
            }
            return number;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.ILLEGAL_LOTTO_NUMBER);
        }
    }

    public static int validateBonusNumber(List<Integer> numbers, String input) {
        int number = isLottoNumberFormatValid(input);

        List<Integer> hasBonusNumber = new ArrayList<>(numbers);
        hasBonusNumber.add(number);

        isLottoNumbersDuplicated(hasBonusNumber);

        return number;
    }

    public static void isLottoNumbersDuplicated(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        if (numbers.size() != uniqueNumbers.size()) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATED_LOTTO_NUMBER);
        }
    }

}
