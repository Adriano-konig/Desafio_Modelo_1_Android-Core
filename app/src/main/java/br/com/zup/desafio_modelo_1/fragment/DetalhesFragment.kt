package br.com.zup.desafio_modelo_1.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.zup.desafio_modelo_1.R
import br.com.zup.desafio_modelo_1.databinding.FragmentDetalhesBinding
import br.com.zup.desafio_modelo_1.model.Produto


class DetalhesFragment : Fragment() {

    private lateinit var binding: FragmentDetalhesBinding
    private val listaProduto = mutableListOf<Produto>()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDetalhesBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        exibirDetalhe()
    }

    private fun  exibirDetalhe(){
        binding.nomeProdutoEditado.text = listaProduto.toString()
        binding.quantidadeEditado.text = listaProduto.toString()
        binding.valorEditado.text = listaProduto.toString()
        binding.receitaEditado.text = listaProduto.toString()
//        binding.recyclerView.adapter = produtoAdapter
//        binding.recyclerView.layoutManager = LinearLayoutManager(context)
    }
}