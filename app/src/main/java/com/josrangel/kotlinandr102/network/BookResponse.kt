package com.josrangel.kotlinandr102.network

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty

@JsonIgnoreProperties(ignoreUnknown = true)
data class BookResponse(

	@field:JsonProperty("payload")
	val payload: List<PayloadItem?>? = null,

	@field:JsonProperty("success")
	val success: Boolean? = null
)
@JsonIgnoreProperties(ignoreUnknown = true)
data class PayloadItem(

	@field:JsonProperty("minimum_price")
	val minimumPrice: String? = null,

	@field:JsonProperty("maximum_price")
	val maximumPrice: String? = null,

	@field:JsonProperty("book")
	val book: String? = null,

	@field:JsonProperty("minimum_value")
	val minimumValue: String? = null,

	@field:JsonProperty("maximum_amount")
	val maximumAmount: String? = null,

	@field:JsonProperty("maximum_value")
	val maximumValue: String? = null,

	@field:JsonProperty("minimum_amount")
	val minimumAmount: String? = null
)
