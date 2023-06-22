package lotto.domain

class RandomLottoGenerator : LottoGenerator {
    override fun generate(numbers: List<Int>): Lotto {
        val lottoNumbers = LottoNumber.LOTTO_NUMBER_RANGE
            .shuffled()
            .take(Lotto.LOTTO_NUMBER_COUNT)
            .map { LottoNumber(it) }

        return Lotto(lottoNumbers)
    }
}
