package rafael.com.br.barshall.view.login

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_login.*
import rafael.com.br.barshall.R
import rafael.com.br.barshall.view.register.RegisterActivity

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)


        btnRegister.setOnClickListener {
            goToRegisterActivity()
        }
    }

    fun goToRegisterActivity(){
        val registerIntent = Intent(this, RegisterActivity::class.java)
        startActivity(registerIntent)
    }
}
