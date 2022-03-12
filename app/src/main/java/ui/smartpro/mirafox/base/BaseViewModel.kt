package ui.smartpro.mirafox.base

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import org.koin.core.component.KoinComponent
import timber.log.Timber

open class BaseViewModel(app: Application) : AndroidViewModel(app), KoinComponent {

    var progressData: MutableLiveData<Boolean> = MutableLiveData()
    val uiDispatcher = Dispatchers.Main.immediate
    val job = CoroutineExceptionHandler { context, exception ->
        Timber.d("coroutine exception $exception")
    }
    val modelScope = CoroutineScope(uiDispatcher + job)

    protected fun updateProgress(progress: Boolean) {
        this.progressData.value = progress
    }
}