package com.example.myapplication

import kotlinx.serialization.Serializable

@Serializable
class ApiResult<T>(
    var code: String? = null,
    var success: Boolean? = null,
    var data: List<T>? = null,
)
//object UserListSerializer : JsonTransformingSerializer<List<LeadFollowUp>>(ListSerializer(LeadFollowUp.serializer())) {
//    // If response is not an array, then it is a single object that should be wrapped into the array
//    override fun transformDeserialize(element: JsonElement): JsonElement =
//        if (element !is JsonArray) JsonArray(listOf(element)) else element
//}
//@Serializable(with = ResponseSerializer::class)
//sealed class Response<out T> {
//    data class data<out T>(val data: T) : Response<T>()
//    data class Error(val message: String) : Response<Nothing>()
//}
//
//class ResponseSerializer<T>(private val dataSerializer: KSerializer<T>) : KSerializer<Response<T>> {
//    @InternalSerializationApi
//    override val descriptor: SerialDescriptor = buildSerialDescriptor("Response", PolymorphicKind.SEALED) {
//        element("Ok", buildClassSerialDescriptor("Ok") {
//            element<String>("message")
//        })
//        element("Error", dataSerializer.descriptor)
//    }
//
//    override fun deserialize(decoder: Decoder): Response<T> {
//        // Decoder -> JsonDecoder
//        require(decoder is JsonDecoder) // this class can be decoded only by Json
//        // JsonDecoder -> JsonElement
//        val element = decoder.decodeJsonElement()
//        // JsonElement -> value
//        if (element is JsonObject && "error" in element)
//            return Response.Error(element["error"]!!.jsonPrimitive.content)
//        return Response.data(decoder.json.decodeFromJsonElement(dataSerializer, element))
//    }
//
//    override fun serialize(encoder: Encoder, value: Response<T>) {
//        // Encoder -> JsonEncoder
//        require(encoder is JsonEncoder) // This class can be encoded only by Json
//        // value -> JsonElement
//        val element = when (value) {
//            is Response.data -> encoder.json.encodeToJsonElement(dataSerializer, value.data)
//            is Response.Error -> buildJsonObject { put("error", value.message) }
//        }
//        // JsonElement -> JsonEncoder
//        encoder.encodeJsonElement(element)
//    }
//}

@Serializable
data class LeadFollowUp(
    var id: Int? = 0,
    var name: String? = ""
)

@Serializable
class EmptyBody()