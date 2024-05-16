package com.reynaldo.horoscapp.domain.model

enum class HoroscopeModel(val index: Int) {
    Aries(1),
    Taurus(2),
    Gemini(3),
    Cancer(4),
    Leo(5),
    Virgo(6),
    Libra(7),
    Scorpio(8),
    Sagittarius(9),
    Capricorn(10),
    Aquarius(11),
    Pisces(12);
    companion object {
        fun fromIndex(index: Int): HoroscopeModel? {
            val valor= values().find { it.index == index }
            if(valor != null){
                return valor;
            }
            return Aries;
        }
    }
}