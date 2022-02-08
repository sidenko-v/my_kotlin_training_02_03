//Вы решили мотивировать пользователей генерировать покупать больше музыки.
//Схема достаточно простая: чем большую сумму потратил пользователь, тем большую скидку на приобретение следующих композиций вы ему даёте.
//Условия следующие:
//Если предыдущая сумма покупок от 0 до 1 000 рублей, то никаких скидок нет (как в лекции).
//Если предыдущая сумма покупок от 1 001 до 10 000 рублей, то стандартная скидка - 100 рублей (как в лекции).
//Если предыдущая сумма покупок от 10 001 рубль и выше то % составляет 5% от суммы.
//Все цены указаны в рублях.
//При этом постоянные пользователи — те, кто покупает ежемесячно, назовём их «меломаны», дополнительно получают 1% скидки сверху.
//Важно: скидки не суммируются, а применяются сверху. Например, у пользователя скидка 5%, значит 1% применяется к 95%:
//
//покупка - 100 рублей →
//
//после применения 5% скидки - 95 рублей.
//
//после применения 1% скидки - 94 рубля 05 копеек.
//Подумайте о том, как вы будете хранить информацию о том, постоянно покупает пользователь музыку или нет.
//
//Подсказка
//Итог: у вас должен быть репозиторий на GitHub, в котором будет ваш Gradle-проект.

fun main() {
    val previousPurchaseAmountInRub = 13422F.toInt()
    val currentPurchaseAmountInRub = 12345F

    val isMusicLover = true

    val zeroDiscountInRub = 0F
    val middleDiscountInRub = 100F
    val highDiscountInPercent = 5F
    val highDiscountInRub: Float = previousPurchaseAmountInRub * highDiscountInPercent / 100
    val additionalDiscountForMusicLoversInPercent = 1F

    var additionalDiscountForMusicLoversInRub = 0F
    var currentDiscountInRub = 0F


    if (previousPurchaseAmountInRub <= 1000) {
        currentDiscountInRub = zeroDiscountInRub
    } else if (1001 <= previousPurchaseAmountInRub && previousPurchaseAmountInRub <= 10000) {
        currentDiscountInRub = middleDiscountInRub
    } else {
        currentDiscountInRub = highDiscountInRub
    }

    if (isMusicLover == true) {
        additionalDiscountForMusicLoversInRub =
            (currentPurchaseAmountInRub - currentDiscountInRub) * additionalDiscountForMusicLoversInPercent / 100
    }

    currentDiscountInRub = currentDiscountInRub + additionalDiscountForMusicLoversInRub


    println("Cкидка $currentDiscountInRub")

}
