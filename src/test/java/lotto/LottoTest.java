package lotto;

import lotto.domain.Lotto;
import lotto.service.LottoService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {
    @Test
    void 로또_번호의_개수가_6개가_넘어가면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void 로또_번호에_중복된_숫자가_있으면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 로또_생성_테스트() {
        Lotto lotto = new Lotto(List.of(6,2,1,3,5,4));

        Assertions.assertEquals("[1, 2, 3, 4, 5, 6]", lotto.toString());
    }

    @Test
    // 보너스 볼 획득 및 5개 일치 시 0으로 리턴. 그 외에는 당첨된 숫자 개수 리턴.
    void 로또_당첨_숫자_일치_테스트() {
        Lotto lotto = new Lotto(List.of(1,2,3,4,5,6));
        int bonus = 9;

        int winningNumberCount = lotto.getWinningNumberCount(List.of(1, 2, 3, 4, 6, 9), bonus);

        Assertions.assertEquals(winningNumberCount, 0);
    }
}
