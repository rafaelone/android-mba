package rafael.com.br.barshall.repository

import rafael.com.br.barshall.api.getSalaoAPI
import rafael.com.br.barshall.model.Client
import rafael.com.br.barshall.model.StatusAPI
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ClientRepository{

    fun newClient(client: Client,
                  onComplete: (Client?) -> Unit,
                  onError: (Throwable?) -> Unit) {

        getSalaoAPI().newClient(client).enqueue(object : Callback<Client> {
            override fun onFailure(call: Call<Client>?, t: Throwable?) {
                onError(t)
            }

            override fun onResponse(call: Call<Client>?, response: Response<Client>?) {
                onComplete(response?.body())
            }

        })
    }
}