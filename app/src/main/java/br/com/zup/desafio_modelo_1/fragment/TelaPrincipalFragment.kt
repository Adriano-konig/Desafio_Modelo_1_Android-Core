package br.com.zup.desafio_modelo_1.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.Navigation
import br.com.zup.desafio_modelo_1.R


class TelaPrincipalFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_tela_principal,container,false)
        view.findViewById<Button>(R.id.button).setOnClickListener{
            Navigation.findNavController(view)
                .navigate(R.id.action_telaPrincipalFragment_to_telaCadastroProdutosFragment)
        }
        return view
    }
    }