package nl.endran.skeleton.kotlin.fragments

import nl.endran.skeleton.kotlin.example.ModelInteractor
import nl.endran.skeleton.kotlin.injections.AppModule
import nl.endran.skeleton.kotlin.mvp.BaseFragmentPresenter
import javax.inject.Inject
import javax.inject.Named

class SkeletonFragmentPresenter @Inject constructor(
        @Named(AppModule.MODEL_INTERACTOR_A) val toastInteractor: ModelInteractor,
        @Named(AppModule.MODEL_INTERACTOR_B) val snackbarInteractor: ModelInteractor)
: BaseFragmentPresenter<SkeletonFragmentPresenter.ViewModel>() {

    interface ViewModel {
        fun showToast(message: String)
        fun showSnackbar(message: String)
    }

    override fun onStart() {
        // Use this callback to start some operation, like database a query
    }

    override fun onStop() {
        // Stop any running operation that might be busy in the background
    }

    fun buttonToastClicked(message: String) {
        toastInteractor.executeSomeComplexOperation (message) {
            viewModel?.showToast(it)
        }
    }

    fun buttonSnackbarClicked(message: String) {
        snackbarInteractor.executeSomeComplexOperation (message) {
            viewModel?.showSnackbar(it)
        }
    }
}
