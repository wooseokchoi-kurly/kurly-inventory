package com.kurly.kurlyinventory.domain

import com.kurly.kurlyinventory.controller.dto.StockDto
import javax.persistence.*
import org.hibernate.annotations.Comment

@Entity
@Table(name = "stock")
class StockEntity(
        @Comment("할당수량")
        @Column(name = "allocQty")
        var allocQty: Int? = 0,

        @Comment("가용수량")
        @Column(name = "qty")
        var qty: Int,

        @Comment("lot number")
        @Column(name = "lotNum")
        var lotNum: String,

        @Comment("지번")
        @Column(name = "location")
        var location: String,

        @Comment("상품명")
        @Column(name = "skuName")
        var skuName: String
) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "stock_id")
    val id: Long? = null

    fun toDto(): StockDto {
        return StockDto(
                id = this.id,
                allocQty = this.allocQty,
                qty = this.qty,
                lotNum = this.lotNum,
                location = this.location,
                skuName = this.skuName
        )
    }

    constructor(stockDto: StockDto) : this(
            allocQty = stockDto.allocQty!!,
            qty = stockDto.qty!!,
            lotNum = stockDto.lotNum!!,
            location = stockDto.location!!,
            skuName = stockDto.skuName!!
    )
}