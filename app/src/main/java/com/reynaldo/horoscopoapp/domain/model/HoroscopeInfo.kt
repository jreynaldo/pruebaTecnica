package com.reynaldo.horoscapp.domain.model

import com.reynaldo.horoscopoapp.R


sealed class HoroscopeInfo ( val img:Int, val name: Int,val index: Int){
    data object Aries:HoroscopeInfo(R.drawable.aries,R.string.aries,1)
    data object Taurus:HoroscopeInfo(R.drawable.tauro,R.string.taurus,2)
    data object Gemini:HoroscopeInfo(R.drawable.geminis,R.string.gemini,3)
    data object Cancer:HoroscopeInfo(R.drawable.cancer,R.string.cancer,4)
    data object Leo:HoroscopeInfo(R.drawable.leo,R.string.leo,5)
    data object Virgo:HoroscopeInfo(R.drawable.virgo,R.string.virgo,6)
    data object Libra:HoroscopeInfo(R.drawable.libra,R.string.libra,7)
    data object Scorpio:HoroscopeInfo(R.drawable.escorpio,R.string.scorpio,8)
    data object Sagittarius:HoroscopeInfo(R.drawable.sagitario,R.string.sagittarius,9)
    data object Capricorn:HoroscopeInfo(R.drawable.capricornio,R.string.capricorn,10)
    data object Aquarius:HoroscopeInfo(R.drawable.aquario,R.string.aquarius,11)
    data object Pisces:HoroscopeInfo(R.drawable.piscis,R.string.pisces,12)

}