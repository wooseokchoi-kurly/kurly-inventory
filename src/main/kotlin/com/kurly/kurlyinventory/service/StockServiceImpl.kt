package com.kurly.kurlyinventory.service

import com.kurly.kurlyinventory.controller.dto.StockDto
import com.kurly.kurlyinventory.domain.StockEntity
import com.kurly.kurlyinventory.repository.StockRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class StockServiceImpl(
        val stockRepository: StockRepository
) : StockService {

    @Transactional(readOnly = true)
    override fun findAllStock(): List<StockDto> {
        return stockRepository.findAll().map { i -> i.toDto() }
    }

    @Transactional(readOnly = true)
    override fun findByStockId(stockId: Long): StockDto {
        val stockEntity: StockEntity = stockRepository.findByIdOrNull(stockId)
                ?: throw IllegalArgumentException("존재하지 않는 재고 입니다.")

        return stockEntity.toDto()
    }

    @Transactional
    override fun saveStock(stockDto: StockDto) {
        stockRepository.save(StockEntity(stockDto))
    }

    @Transactional
    override fun updateStock(stockDto: StockDto) {
        val stockEntity = (stockRepository.findByIdOrNull(stockDto.id)
                ?: throw IllegalArgumentException("존재하지 않는 재고 입니다."))

        stockEntity.apply {
            allocQty = stockDto.allocQty ?: allocQty
            qty = stockDto.qty ?: qty
            lotNum = stockDto.lotNum ?: lotNum
            location = stockDto.location ?: location
            skuName = stockDto.skuName ?: skuName
        }
    }
}