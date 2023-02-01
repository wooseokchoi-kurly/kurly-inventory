package com.kurly.kurlyinventory.service

import com.kurly.kurlyinventory.controller.dto.StockDto
import org.springframework.stereotype.Service

interface StockService {

    fun findAllStock(): List<StockDto>

    fun findByStockId(stockId: Long): StockDto

    fun saveStock(stockDto: StockDto)

    fun updateStock(stockDto: StockDto)
}