package br.com.zup.desafio_modelo_1.fragment

import android.os.Bundle
import android.os.Parcelable.PARCELABLE_WRITE_RETURN_VALUE
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.core.os.bundleOf
import androidx.core.view.get
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.zup.desafio_modelo_1.PRODUTO_KEY
import br.com.zup.desafio_modelo_1.R
import br.com.zup.desafio_modelo_1.databinding.FragmentTelaCadastroProdutosBinding
import br.com.zup.desafio_modelo_1.databinding.FragmentTelaProdutoCadastradosBinding
import br.com.zup.desafio_modelo_1.databinding.ProdutoItemBinding
import br.com.zup.desafio_modelo_1.fragment.adapter.ProdutoAdapter
import br.com.zup.desafio_modelo_1.model.Produto

class TelaProdutoCadastradosFragment : Fragment() {
    private lateinit var binding: FragmentTelaProdutoCadastradosBinding
    private val produtoAdapter: ProdutoAdapter by lazy {
        ProdutoAdapter(arrayListOf(), this::irDetalhe)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        BuscarDados()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentTelaProdutoCadastradosBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        exibirRecyclerView()
    }


    private fun exibirRecyclerView(){
        binding.recyclerView.adapter = produtoAdapter
        binding.recyclerView.layoutManager = LinearLayoutManager(context)
    }

    private fun BuscarDados(){
        val listaProduto = arguments?.getParcelableArrayList<Produto>("PRODUTOS")
        if (listaProduto != null){
            produtoAdapter.atualizarListaProduto(listaProduto)
        }
    }

    private fun irDetalhe(produto: Produto) {
        val bundle = bundleOf("PRODUTO_KEY" to produto)
        NavHostFragment.findNavController(this).navigate(
            R.id.action_telaProdutoCadastradosFragment_to_detalhesFragment, bundle
        )
    }

}

