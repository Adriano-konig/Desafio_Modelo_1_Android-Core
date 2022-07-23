package br.com.zup.desafio_modelo_1.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import br.com.zup.desafio_modelo_1.PRODUTO_KEY
import br.com.zup.desafio_modelo_1.R
import br.com.zup.desafio_modelo_1.databinding.FragmentTelaProdutoCadastradosBinding
import br.com.zup.desafio_modelo_1.databinding.FragmentValorTotalBinding
import br.com.zup.desafio_modelo_1.fragment.adapter.ProdutoAdapter
import br.com.zup.desafio_modelo_1.model.Produto


class ValorTotalFragment : Fragment() {


    private lateinit var binding: FragmentValorTotalBinding
    private lateinit var listaProduto: MutableList<Produto>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentValorTotalBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        irTelaCadastroDeProduto()
        irTelaVerProduto()
        recuperarExibirDados()
    }



    private fun recuperarExibirDados(){
        val bundle = arguments?.getParcelable<Produto>("PRODUTOS")

        if (bundle != null){
            val valorTotal = calculo(
                 bundle.getQuantidadeProduto(),
                 bundle.getValorProduto()
            )
            exibirValor(valorTotal)
        }
    }

    private fun calculo(quantidade: Int, valor: Double):Double{
        return (quantidade * valor)
    }

    private fun exibirValor(valorTotal: Double){
        binding.textValor.text = valorTotal.toString()
    }

    fun irTelaCadastroDeProduto(){
        binding.buttonCadastrarNovoProduto.setOnClickListener{
            findNavController().navigate(R.id.action_valorTotalFragment_to_telaCadastroProdutosFragment)
        }
    }

    fun irTelaVerProduto(){
        binding.buttonVerProduto.setOnClickListener{
            findNavController().navigate(R.id.action_valorTotalFragment_to_telaProdutoCadastradosFragment)
        }
    }

}