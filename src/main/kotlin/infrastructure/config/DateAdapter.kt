package br.com.estudo.infrastructure.config

import com.google.gson.JsonDeserializationContext
import com.google.gson.JsonDeserializer
import com.google.gson.JsonElement
import com.google.gson.JsonPrimitive
import com.google.gson.JsonSerializationContext
import com.google.gson.JsonSerializer
import java.lang.reflect.Type
import java.time.LocalDate
import java.time.format.DateTimeFormatter

class LocalDateAdapter : JsonSerializer<LocalDate>, JsonDeserializer<LocalDate> {
    private val formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy")

    override fun serialize(
        src: LocalDate?,
        typeOfSrc: Type?,
        context: JsonSerializationContext?
    ): JsonElement = JsonPrimitive(src?.format(formatter))

    override fun deserialize(
        json: JsonElement?,
        typeOfT: Type?,
        context: JsonDeserializationContext?
    ): LocalDate = LocalDate.parse(json!!.asString, formatter)
}