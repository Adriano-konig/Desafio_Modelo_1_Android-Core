package br.com.zup.desafio_modelo_1.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.fragment.NavHostFragment
import br.com.zup.desafio_modelo_1.PRODUTO_KEY
import br.com.zup.desafio_modelo_1.R
import br.com.zup.desafio_modelo_1.databinding.FragmentValorTotalBinding
import br.com.zup.desafio_modelo_1.home.HomeActivity
import br.com.zup.desafio_modelo_1.model.Produto


class ValorTotalFragment : Fragment() {


    private lateinit var binding: FragmentValorTotalBinding
    private lateinit var listaProduto: ArrayList<Produto>


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentValorTotalBinding.inflate(inflater,container,false)
        (activity as HomeActivity).supportActionBar?.setDisplayHomeAsUpEnabled(true)
        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (activity as HomeActivity).supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        irTelaCadastroDeProduto()
        irTelaVerProduto()
        recuperarExibirDados()
    }



    private fun recuperarExibirDados() {
        val bundle = arguments?.getParcelableArrayList<Produto>(PRODUTO_KEY)

        if (bundle != null){
            listaProduto = bundle
           calculo(listaProduto)
        }

    }

    private fun novoLista():Bundle {
        return bundleOf(PRODUTO_KEY to listaProduto)
    }

    private fun calculo(listaProduto: ArrayList<Produto>){
        var soma = 0.0
        listaProduto.forEach {
           soma += it.getValorProduto() * it.getQuantidadeProduto()
        }
        exibirValor(soma)
    }

    private fun exibirValor(valorTotal: Double){
        binding.textValor.text = valorTotal.toString()
    }

    fun irTelaCadastroDeProduto(){
        binding.buttonCadastrarNovoProduto.setOnClickListener{
            NavHostFragment.findNavController(this).
            navigate(R.id.action_valorTotalFragment_to_telaCadastroProdutosFragment, novoLista())
        }
    }

    fun irTelaVerProduto(){
        binding.buttonVerProduto.setOnClickListener{
            NavHostFragment.findNavController(this).
            navigate(R.id.action_valorTotalFragment_to_telaProdutoCadastradosFragment, novoLista())
        }
    }

}