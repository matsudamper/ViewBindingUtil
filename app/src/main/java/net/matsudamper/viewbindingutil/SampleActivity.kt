package net.matsudamper.viewbindingutil

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import net.matsudamper.viewbindingutil.databinding.ActivityMainBinding
import java.lang.Exception

class SampleActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Create view and bind
        val binding = ViewBindingUtil.inflate<ActivityMainBinding>(layoutInflater)

        // bind
        val binding2 = ViewBindingUtil.bind<ActivityMainBinding>(binding.root)

        title = this::class.java.simpleName
        setContentView(binding.root)

        if (binding.root != binding2.root) {
            throw Exception("Never pass here")
        }

        startActivity(Intent(this, BindSampleActivity::class.java))
    }
}
