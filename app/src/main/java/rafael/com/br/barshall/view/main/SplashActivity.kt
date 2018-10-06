package rafael.com.br.barshall.view.main

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.util.Log
import rafael.com.br.barshall.R
import rafael.com.br.barshall.api.SalaoAPI
import rafael.com.br.barshall.model.ResponseStatus
import rafael.com.br.barshall.model.StatusAPI
import rafael.com.br.barshall.view.login.LoginActivity

class SplashActivity : AppCompatActivity() {

    lateinit var mainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        mainViewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
        mainViewModel.responseStatus.observe(this, statusObserver)
        mainViewModel.checkStatus()



    }

    private var statusObserver = Observer<ResponseStatus>{
    if(it?.success == true){
        loading()
    }
    Log.i("testando", "state: " + it?.success )
    }

    private fun loading(){
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
