package com.kurly.kurlyinventory.repository

import com.kurly.kurlyinventory.domain.StockEntity
import org.springframework.data.jpa.repository.JpaRepository

interface StockRepository:JpaRepository<StockEntity, Long> {
}