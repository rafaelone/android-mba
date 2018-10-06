package rafael.com.br.barshall.view.main

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.util.Log
import okhttp3.Response
import rafael.com.br.barshall.Repository.SalaoRepository
import rafael.com.br.barshall.model.ResponseStatus
import rafael.com.br.barshall.model.StatusAPI

class MainViewModel : ViewModel(){

    val salaoRepository = SalaoRepository()
    val responseStatus: MutableLiveData<ResponseStatus> = MutableLiveData()
    val isLoading: MutableLiveData<Boolean> = MutableLiveData()

    fun checkStatus(){
        salaoRepository.checkAPI(onComplete = {
            isLoading.value = false
            responseStatus.value = ResponseStatus(true, "Api esta rodando")
        }, onError = {
            isLoading.value = false
            responseStatus.value = ResponseStatus(false, it?.message!!)
        })
    }

}