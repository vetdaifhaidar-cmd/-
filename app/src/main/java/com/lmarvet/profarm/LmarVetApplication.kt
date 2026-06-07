import androidx.multidex.MultiDexApplication
import dagger.hilt.android.HiltAndroidApp
import timber.log.Timber

@HiltAndroidApp
class LmarVetApplication : MultiDexApplication() {
    
    override fun onCreate() {
        super.onCreate()
        
        // Initialize Timber for logging
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
        
        // Initialize other libraries
        initializeLibraries()
    }
    
    private fun initializeLibraries() {
        // Initialize Glide
        // Initialize other libraries
    }
}
