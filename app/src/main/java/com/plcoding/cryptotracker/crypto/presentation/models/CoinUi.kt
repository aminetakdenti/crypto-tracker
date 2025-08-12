package com.plcoding.cryptotracker.crypto.presentation.models

import android.icu.text.NumberFormat
import androidx.annotation.DrawableRes
import com.plcoding.cryptotracker.crypto.domain.Coin
import com.plcoding.cryptotracker.core.presentation.util.getDrawableIdForCoin
import java.util.Locale

data class CoinUi(
    val id: String,
    val rank: Int,
    val name: String,
    val symbol: String,
    val marketCapUsd: DisplayNumber,
    val priceUsd: DisplayNumber,
    val changePercent24Hr: DisplayNumber,
    @DrawableRes val iconRes: Int,
)

data class DisplayNumber(
    val value: Double,
    val formatted: String
)

fun Coin.toCoinUi (): CoinUi {
    return CoinUi(
        id = id,
        name = name,
        rank = rank,
        symbol = symbol,
        marketCapUsd = marketCapUsd.toDisplyableNumber(),
        priceUsd = priceUsd.toDisplyableNumber(),
        changePercent24Hr = changePercent24Hr.toDisplyableNumber(),
        iconRes = getDrawableIdForCoin(symbol)
    )
}

fun Double.toDisplyableNumber(): DisplayNumber {
    val formatter = NumberFormat.getNumberInstance(Locale.getDefault()). apply {
        minimumFractionDigits = 2
        maximumFractionDigits = 2
    }

    return DisplayNumber(
        value = this,
        formatted = formatter.format(this)
    )
}