package br.com.thaisregina.lmsapp

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = arrayOf(Produtos::class), version=1)
abstract class LMSDatabase: RoomDatabase() {
    abstract fun produtosDAO(): ProdutosDAO
}