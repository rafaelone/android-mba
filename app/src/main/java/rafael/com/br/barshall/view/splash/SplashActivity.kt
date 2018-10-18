package rafael.com.br.barshall.view.splash

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.util.Log
import rafael.com.br.barshall.R
import rafael.com.br.barshall.model.ResponseStatus
import rafael.com.br.barshall.view.login.LoginActivity
import rafael.com.br.barshall.view.main.HomeActivity

class SplashActivity : AppCompatActivity() {

    lateinit var splashViewModel: SplashViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        splashViewModel = ViewModelProviders.of(this).get(SplashViewModel::class.java)
        splashViewModel.responseStatus.observe(this, statusObserver)
        splashViewModel.checkStatus()


    }

    private var statusObserver = Observer<ResponseStatus> {
        if (it?.success == true) {
            val sharedPreferences = getSharedPreferences("myapp", Context.MODE_PRIVATE)
            val nome = sharedPreferences.getString("nome", "")
            val id = sharedPreferences.getString("id", "")
            if (nome != "" && id != null) {
                val homeIntent = Intent(this, HomeActivity::class.java)
                startActivity(homeIntent)
                finish()
            } else {
                loading()
            }

        }

    }

    private fun loading() {
        Handler().postDelayed({
            callNextActivity()
        }, 2000)
    }

    private fun callNextActivity() {
        val nextItent = Intent(this, LoginActivity::class.java)
        startActivity(nextItent)
        finish()
    }

}
