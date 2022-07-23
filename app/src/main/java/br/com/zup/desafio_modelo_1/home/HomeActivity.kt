package br.com.zup.desafio_modelo_1.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import br.com.zup.desafio_modelo_1.FragmentClick
import br.com.zup.desafio_modelo_1.R
import br.com.zup.desafio_modelo_1.databinding.ActivityHomeBinding
import br.com.zup.desafio_modelo_1.databinding.FragmentTelaCadastroProdutosBinding
import br.com.zup.desafio_modelo_1.fragment.TelaCadastroProdutosFragment
import br.com.zup.desafio_modelo_1.fragment.TelaPrincipalFragment

class HomeActivity : AppCompatActivity(), FragmentClick {

    private lateinit var binding: ActivityHomeBinding
    private var botaoCadastrar: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
//        supportActionBar?.setDisplayHomeAsUpEnabled(true)


        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.container) as NavHostFragment
        val navController: NavController = navHostFragment.navController
        NavigationUI.setupActionBarWithNavController(this, navController)

    }

    override fun clickFragmento(button: Button) {
        TODO("Not yet implemented")
    }

//        supportFragmentManager
//            .beginTransaction()
//            .add(binding.container.id,TelaPrincipalFragment())
//            .commit()


   // botaoCadastrar = findViewById(R.id.botaoCadastraNovoproduto)
//}
}