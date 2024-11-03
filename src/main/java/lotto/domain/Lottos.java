package lotto.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Lottos {

    private static final Lottos instance = new Lottos(); // 싱글톤 패턴 적용

    private final List<Lotto> lottoList = new ArrayList<>();
    private final int[] winningLottoCounts = new int[7];
    private List<Integer> inputLottoNumbers;
    private Integer bonusNumber;

    private Lottos() {
        Arrays.fill(winningLottoCounts, 0);
    }

    public static Lottos getInstance() {
        return instance;
    }

    public void add(Lotto lotto) {
        lottoList.add(lotto);
    }

    public List<Lotto> getLottoList() {
        return lottoList;
    }

    public int[] getWinningLottoCounts() {
        return winningLottoCounts;
    }

    public List<Integer> getInputLottoNumbers() {
        return inputLottoNumbers;
    }

    public Integer getBonusNumber() {
        return bonusNumber;
    }

    public void setInputLottoNumbers(List<Integer> inputLottoNumbers) {
        this.inputLottoNumbers = inputLottoNumbers;
    }

    public void setBonusNumber(Integer bonusNumber) {
        this.bonusNumber = bonusNumber;
    }

    public void countUp(int index) {
        winningLottoCounts[index]++;
    }
}