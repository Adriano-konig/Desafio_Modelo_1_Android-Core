package br.com.zup.desafio_modelo_1.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import br.com.zup.desafio_modelo_1.*
import br.com.zup.desafio_modelo_1.databinding.FragmentTelaCadastroProdutosBinding
import br.com.zup.desafio_modelo_1.home.HomeActivity
import br.com.zup.desafio_modelo_1.model.Produto


class TelaCadastroProdutosFragment : Fragment() {

    private lateinit var binding: FragmentTelaCadastroProdutosBinding
    private val listaProduto = mutableListOf<Produto>()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentTelaCadastroProdutosBinding.inflate(inflater, container, false)
        return binding.root
        supportActionBar()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        buttonCadastrar()
        buttonverProduto()
        buttonValorTotal()
    }

    private fun supportActionBar(){
        (activity as HomeActivity).supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    private fun buttonCadastrar(){
        binding.botaoCadastraNovoproduto.setOnClickListener {
            clickCadastro()
        }
    }

    private fun buttonverProduto(){
        binding.botaoVerProduto.setOnClickListener{
            val bundle = bundleOf("PRODUTOS" to listaProduto)
            findNavController().navigate(
                R.id.action_telaCadastroProdutosFragment_to_telaProdutoCadastradosFragment,
                bundle)
        }
    }

    private fun buttonValorTotal(){
        binding.botaoValorTotal.setOnClickListener{
            val bundle = bundleOf(PRODUTO_KEY  to listaProduto)
            NavHostFragment.findNavController(this).navigate(
                R.id.action_telaCadastroProdutosFragment_to_valorTotalFragment,
                bundle)
        }
    }

    private fun clickCadastro() {
            val produto = recuperar()
            if (produto != null){
                listaProduto.add(produto)
                Toast.makeText(context, CADASTRO_SUCESSO, Toast.LENGTH_LONG).show()
                limpar()
            }else{
                Toast.makeText(context, CADASTRO_INCOMPLETO, Toast.LENGTH_LONG).show()
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
     try {
         if (nomeProduto.isEmpty() && quantidadeProduto.isEmpty() &&
             valorProduto.isEmpty() && receitaProduto.isEmpty()){
             binding.EditNomeDeProduto.error = CAMPO_OBRIGATORIO
             binding.EditQuantidadeProduto.error = CAMPO_OBRIGATORIO
             binding.EditValorProduto.error= CAMPO_OBRIGATORIO
             binding.EditReceita.error = CAMPO_OBRIGATORIO
         }else if(nomeProduto.isEmpty()){
             binding.EditNomeDeProduto.error = CAMPO_OBRIGATORIO
         }else if(quantidadeProduto.isEmpty()){
             binding.EditQuantidadeProduto.error = CAMPO_OBRIGATORIO
         }else if(valorProduto.isEmpty()){
             binding.EditValorProduto.error= CAMPO_OBRIGATORIO
         }else if(receitaProduto.isEmpty()){
             binding.EditReceita.error = CAMPO_OBRIGATORIO
         }else{
             return Produto(
                 nomeProduto,
                 quantidadeProduto.toInt(),
                 valorProduto.toDouble(),
                 receitaProduto
             )
         }
     }catch (ex : Exception){
         ex.toString()
         Toast.makeText(context, CAMPO_NUMERO, Toast.LENGTH_LONG).show()
             binding.EditQuantidadeProduto.error = CAMPO_OBRIGATORIO
             binding.EditValorProduto.error= CAMPO_OBRIGATORIO
     }
        return null
    }
    }

