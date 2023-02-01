package com.kurly.kurlyinventory.controller.dto

import io.swagger.v3.oas.annotations.media.Schema

data class StockDto(
        @Schema(description = "할당수량", example = "10")
        var allocQty: Int?,

        @Schema(description = "가용수량", example = "100")
        var qty: Int?,

        @Schema(description = "로트번호", example = "lot000001")
        var lotNum: String?,

        @Schema(description = "지번", example = "ct-ar-lc-01")
        var location: String?,

        @Schema(description = "상품명", example = "와일드터키")
        var skuName: String?,

        @Schema(description = "재고아이디", example = "1")
        var id: Long?
)
