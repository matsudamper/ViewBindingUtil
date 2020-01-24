package net.matsudamper.viewbindingutil

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import net.matsudamper.viewbindingutil.databinding.ActivityMainBinding

class InflateSampleActivity : AppCompatActivity() {
    private val binding by lazy { inflateViewBinding<ActivityMainBinding>() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        title = this::class.java.simpleName

        supportFragmentManager.beginTransaction()
            .replace(binding.fragmentContainer.id, InflateSampleFragment())
            .commit()

    }
}