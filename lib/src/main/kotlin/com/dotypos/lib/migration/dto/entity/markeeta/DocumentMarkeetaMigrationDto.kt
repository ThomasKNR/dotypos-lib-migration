@file:UseSerializers(
    BigDecimalSerializer::class,
    DateSerializer::class
)

package com.dotypos.lib.migration.dto.entity.markeeta

import com.dotypos.lib.migration.dto.entity.BaseEntityDto
import com.dotypos.lib.migration.dto.entity.iface.WithId
import com.dotypos.lib.migration.dto.entity.iface.WithName
import com.dotypos.lib.migration.dto.entity.iface.WithVersion
import com.dotypos.lib.migration.serialization.BigDecimalSerializer
import com.dotypos.lib.migration.serialization.DateSerializer
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.UseSerializers
import java.math.BigDecimal
import java.util.*

/**
 * Billing documents in Markeeta.
 */
@Serializable
data class DocumentMarkeetaMigrationDto (
    @SerialName(WithId.SERIAL_NAME)
    override val id: Long,

    @SerialName("type")
    val type: Type,

    @SerialName(WithName.SERIAL_NAME)
    override val name: String,

    /**
     * Code of document.
     */
    @SerialName("documentCode")
    val documentCode: String,

    /**
     * Url of document for download in pdf format.
     */
    @SerialName("url")
    val url: String,

    /**
     * Price without vat.
     */
    @SerialName("priceWithoutVat")
    val priceWithoutVat: BigDecimal,

    /**
     * Price with vat.
     */
    @SerialName("priceWithVat")
    val priceWithVat: BigDecimal,

    /**
     * Creation date.
     */
    @SerialName("creationDate")
    val creationDate: Date,

    /**
     * Date of taxable supply.
     */
    @SerialName("dateOfTaxableSupply")
    val dateOfTaxableSupply: Date,

    /**
     * Due date.
     */
    @SerialName("dueDate")
    val dueDate: Date,

    @SerialName(WithVersion.SERIAL_NAME)
    override val version: Long,
) : BaseEntityDto(), WithName {

    /**
     * Types of billing documents.
     */
    @Serializable
    enum class Type {

        @SerialName("license_invoice")
        LICENSE_INVOICE,

        @SerialName("sim_invoice")
        SIM_INVOICE,

        @SerialName("package_invoice")
        PACKAGE_INVOICE,

        @SerialName("payment_schedule")
        PAYMENT_SCHEDULE,
    }
}