package net.matsudamper.viewbindingutil

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import net.matsudamper.viewbindingutil.databinding.ActivityMainBinding

class BindSampleActivity : AppCompatActivity(R.layout.activity_main) {
    private val binding by bindViewBinding<ActivityMainBinding>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        title = this::class.java.simpleName

        supportFragmentManager.beginTransaction()
                .replace(binding.fragmentContainer.id, BindSampleFragment())
                .commit()
    }
}
