package br.com.zup.desafio_modelo_1.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
class Produto(
    private var nomeProduto: String,
    private var quantidadeProduto: Int,
    private var valorProduto: Double,
    private var receita: String
):Parcelable {

    fun getNomeProduto() = this.nomeProduto
    fun getQuantidadeProduto() = this.quantidadeProduto
    fun getValorProduto() = this.valorProduto
    fun getReceita() = this.receita
}