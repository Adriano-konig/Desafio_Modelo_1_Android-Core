package br.com.zup.desafio_modelo_1.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import br.com.zup.desafio_modelo_1.CLICA_FAVORITADO
import br.com.zup.desafio_modelo_1.PRODUTO_KEY
import br.com.zup.desafio_modelo_1.databinding.FragmentDetalhesBinding
import br.com.zup.desafio_modelo_1.home.HomeActivity
import br.com.zup.desafio_modelo_1.model.Produto


class DetalhesFragment : Fragment() {

    private lateinit var binding: FragmentDetalhesBinding
    private val listaProduto = mutableListOf<Produto>()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDetalhesBinding.inflate(inflater,container,false)
        (activity as HomeActivity).supportActionBar?.setDisplayHomeAsUpEnabled(true)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        trazerDados()
        favoritarProduto()
    }

    private fun trazerDados(){
        val produto = arguments?.getParcelable<Produto>(PRODUTO_KEY)
        if(produto != null){
            exibirDetalhe(produto = produto)
        }
    }

    private fun  exibirDetalhe(produto: Produto){
        binding.nomeProdutoEditado.text = produto.getNomeProduto()
        binding.quantidadeEditado.text = produto.getQuantidadeProduto().toString()
        binding.valorEditado.text = produto.getValorProduto().toString()
        binding.receitaEditado.text = produto.getReceita()
//        binding.recyclerView.adapter = produtoAdapter
//        binding.recyclerView.layoutManager = LinearLayoutManager(context)
    }

    private fun favoritarProduto() {
        binding.icFavoritar.setOnClickListener {
            Toast.makeText(context, CLICA_FAVORITADO, Toast.LENGTH_LONG).show()
        }
    }
}