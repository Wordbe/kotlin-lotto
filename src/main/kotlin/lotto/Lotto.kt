package lotto

class Lotto(
    val lottoNumbers: List<LottoNumber>,
) {
    init {
        require(lottoNumbers.size == lottoNumbers.distinct().size) { "로또번호는 중복이 없어야 합니다." }
        require(lottoNumbers.size == LOTTO_NUMBER_COUNT) { "로또번호는 ${LOTTO_NUMBER_COUNT}개 이어야 합니다." }
    }

    fun matchPrize(other: Lotto, bonusLottoNumber: LottoNumber): Prize {
        val matchedLottoNumbers = lottoNumbers.filter { other.lottoNumbers.contains(it) }
        val bonusMatched = lottoNumbers.any { it == bonusLottoNumber }
        return Prize.match(matchedLottoNumbers.size, bonusMatched)
    }

    companion object {
        const val LOTTO_NUMBER_COUNT = 6

        fun draw(lottoGenerator: LottoGenerator): Lotto = lottoGenerator.generate()

        fun of(numbers: List<Int>): Lotto {
            return Lotto(numbers.map { LottoNumber(it) })
        }
    }
}
