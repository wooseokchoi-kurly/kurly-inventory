package com.kurly.kurlyinventory.controller

import com.kurly.kurlyinventory.controller.dto.StockDto
import com.kurly.kurlyinventory.service.StockService
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
@Tag(name = "재고관리 API")
class InventoryController(
        val stockService: StockService
) {
    @GetMapping("/v1/stocks")
    @Operation(summary = "재고목록 조회 API", description = "재고목록 조회 API")
    fun getStockList(): List<StockDto> {
        return stockService.findAllStock()
    }

    @GetMapping("/v1/stocks/{stockId}")
    @Operation(summary = "재고목록 조회 API", description = "재고목록 조회 API")
    fun getStock(@PathVariable stockId: Long): StockDto {
        return stockService.findByStockId(stockId)
    }

    @PostMapping("/v1/stocks")
    @Operation(summary = "재고저장 API", description = "재고저장 API")
    fun saveStock(@RequestBody stockDto: StockDto) {
        stockService.saveStock(stockDto)
    }

    @PutMapping("/v1/stocks")
    @Operation(summary = "재고수정 API", description = "재고수정 API")
    fun updateStock(@RequestBody stockDto: StockDto) {
        stockService.updateStock(stockDto)
    }
    
}