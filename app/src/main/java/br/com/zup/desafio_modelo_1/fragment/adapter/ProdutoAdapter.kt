package br.com.zup.desafio_modelo_1.fragment.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.zup.desafio_modelo_1.databinding.ProdutoItemBinding
import br.com.zup.desafio_modelo_1.model.Produto

class ProdutoAdapter (
    private var listaProdutos: MutableList<Produto>,
    private val clickProduto:(produto:Produto) -> Unit
        ): RecyclerView.Adapter<ProdutoAdapter.ViewHolder>(){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ProdutoItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false)

        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val produto = listaProdutos[position]
        holder.adicionarProdutosView(produto)
        holder.binding.cvItemLista.setOnClickListener{
            clickProduto(produto)
        }

    }

    override fun getItemCount() = listaProdutos.size

    fun atualizarListaProduto(novaLista: MutableList<Produto>){
        if (listaProdutos.size == 0){
            listaProdutos = novaLista
        }else{
            listaProdutos.addAll(novaLista)
        }
        notifyDataSetChanged()
    }

    class ViewHolder(val binding: ProdutoItemBinding):RecyclerView.ViewHolder(binding.root){
        fun adicionarProdutosView(produto: Produto){
            binding.tvNomeProduto.text = produto.getNomeProduto()
        }
    }

}