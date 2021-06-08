package cl.maleb.testtransbank.utils

import androidx.room.TypeConverter
import cl.maleb.testtransbank.api.detail.*
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import cl.maleb.testtransbank.api.list.Result

class Converters {
    @TypeConverter
    fun restoreListInt(listOfInt: String?): List<Int?>? {
        return Gson().fromJson(listOfInt, object : TypeToken<List<Int?>?>() {}.type)
    }

    @TypeConverter
    fun saveListInt(listOfInt: List<Int?>?): String? {
        return Gson().toJson(listOfInt)
    }

    @TypeConverter
    fun restoreListString(listOfString: String?): List<String?>? {
        return Gson().fromJson(listOfString, object : TypeToken<List<String?>?>() {}.type)
    }

    @TypeConverter
    fun saveListString(listOfString: List<String?>?): String? {
        return Gson().toJson(listOfString)
    }

    @TypeConverter
    fun restoreListGenreData(objectToRestore: String?): List<Genre>? {
        return Gson().fromJson(objectToRestore, object : TypeToken<List<Genre>?>() {}.type)
    }

    @TypeConverter
    fun saveListGenreData(objectToSave: List<Genre>?): String? {
        return Gson().toJson(objectToSave)
    }

    @TypeConverter
    fun restoreListProductionCompanyData(objectToRestore: String?): List<ProductionCompany>? {
        return Gson().fromJson(
            objectToRestore,
            object : TypeToken<List<ProductionCompany>?>() {}.type
        )
    }

    @TypeConverter
    fun saveListProductionCompanyData(objectToSave: List<ProductionCompany>?): String? {
        return Gson().toJson(objectToSave)
    }

    @TypeConverter
    fun restoreListProductionCountryData(objectToRestore: String?): List<ProductionCountry>? {
        return Gson().fromJson(
            objectToRestore,
            object : TypeToken<List<ProductionCountry>?>() {}.type
        )
    }

    @TypeConverter
    fun saveListProductionCountryData(objectToSave: List<ProductionCountry>?): String? {
        return Gson().toJson(objectToSave)
    }

    @TypeConverter
    fun restoreListSpokenLanguageData(objectToRestore: String?): List<SpokenLanguage>? {
        return Gson().fromJson(objectToRestore, object : TypeToken<List<SpokenLanguage>?>() {}.type)
    }

    @TypeConverter
    fun saveListSpokenLanguageData(objectToSave: List<SpokenLanguage>?): String? {
        return Gson().toJson(objectToSave)
    }

    @TypeConverter
    fun restoreListResultData(objectToRestore: String?): List<Result>? {
        return Gson().fromJson(objectToRestore, object : TypeToken<List<Result>?>() {}.type)
    }

    @TypeConverter
    fun saveListResultData(objectToSave: List<Result>?): String? {
        return Gson().toJson(objectToSave)
    }


}