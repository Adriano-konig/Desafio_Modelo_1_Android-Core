package br.com.zup.desafio_modelo_1.fragment

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import br.com.zup.desafio_modelo_1.FragmentClick
import br.com.zup.desafio_modelo_1.PRODUTO_KEY
import br.com.zup.desafio_modelo_1.R
import br.com.zup.desafio_modelo_1.databinding.FragmentTelaCadastroProdutosBinding
import br.com.zup.desafio_modelo_1.fragment.adapter.ProdutoAdapter
import br.com.zup.desafio_modelo_1.home.HomeActivity
import br.com.zup.desafio_modelo_1.model.Produto


class TelaCadastroProdutosFragment : Fragment() {

    private lateinit var binding: FragmentTelaCadastroProdutosBinding
    private lateinit var fragmentClick: FragmentClick
    private val listaProduto = mutableListOf<Produto>()

    override fun onAttach(context: Context) {
        super.onAttach(context)
        try {
            fragmentClick = context as HomeActivity
        }catch (ex:Exception){
            Log.i("Error","Erro na inicialização da interfaceClick ${ex.message}")
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentTelaCadastroProdutosBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.botaoCadastraNovoproduto.setOnClickListener {
            clickCadastro()
        }

        binding.botaoVerProduto.setOnClickListener{
            val bundle = bundleOf("PRODUTOS" to listaProduto)
            findNavController().navigate(R.id.action_telaCadastroProdutosFragment_to_telaProdutoCadastradosFragment,bundle)
        }

       binding.botaoValorTotal.setOnClickListener{
           val bundle = bundleOf("PRODUTOS"  to listaProduto)
           findNavController().navigate(R.id.action_telaCadastroProdutosFragment_to_valorTotalFragment, bundle)
       }

    }

    fun clickCadastro() {
            val produto = recuperar()
            if (produto != null){
                listaProduto.add(produto)
                Toast.makeText(context, "Produto cadastrado com sucesso!", Toast.LENGTH_LONG).show()
                limpar()
            }
    }
    private fun limpar() {
        binding.EditNomeDeProduto.text.clear()
        binding.EditQuantidadeProduto.text.clear()
        binding.EditValorProduto.text.clear()
        binding.EditReceita.text.clear()
    }
    private fun recuperar():Produto?{
        val nomeProduto = binding.EditNomeDeProduto.text.toString()
        val quantidadeProduto = binding.EditQuantidadeProduto.text.toString()
        val valorProduto = binding.EditValorProduto.text.toString()
        val receitaProduto = binding.EditReceita.text.toString()

        if (nomeProduto.isEmpty() && quantidadeProduto.isEmpty() && valorProduto.isEmpty() && receitaProduto.isEmpty()){
            binding.EditNomeDeProduto.error = "Campo obrigatório"
            binding.EditQuantidadeProduto.error = "Campo obrigatório"
            binding.EditValorProduto.error="Campo obrigatório"
            binding.EditReceita.error = "Campo obrigatório"
        }else if(nomeProduto.isEmpty()){
            binding.EditNomeDeProduto.error = "Campo obrigatório"
        }else if(quantidadeProduto.isEmpty()){
            binding.EditQuantidadeProduto.error = "Campo obrigatório"
        }else if(valorProduto.isEmpty()){
            binding.EditValorProduto.error="Campo obrigatório"
        }else if(receitaProduto.isEmpty()){
            binding.EditReceita.error = "Campo obrigatório"
        }else{
            return Produto(nomeProduto, quantidadeProduto.toInt(), valorProduto.toDouble(), receitaProduto)
        }
        return null
    }
    }

