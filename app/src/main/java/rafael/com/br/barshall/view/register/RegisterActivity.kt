package rafael.com.br.barshall.view.register

import android.app.Activity
import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_register.*
import okhttp3.Response
import rafael.com.br.barshall.R
import rafael.com.br.barshall.model.ResponseStatus

class RegisterActivity : AppCompatActivity() {

    lateinit var registerViewModel: RegisterViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        registerViewModel = ViewModelProviders.of(this).get(RegisterViewModel::class.java)
        registerViewModel.responseStatus.observe(this, responseStatusObserver)

        btRegister.setOnClickListener {
            registerViewModel.newClient(
                    etNome.text.toString(),
                    etPass.text.toString(),
                    etEmail.text.toString(),
                    etPhone.text.toString()
            )
        }

    }

    private var responseStatusObserver = Observer<ResponseStatus>{
        if(it?.success == true){
            setResult(Activity.RESULT_OK)
            Toast.makeText(this, "Successful registration", Toast.LENGTH_LONG).show()
            finish()
        }else{
            Toast.makeText(this, it?.mensage, Toast.LENGTH_SHORT).show()
        }
    }
}
