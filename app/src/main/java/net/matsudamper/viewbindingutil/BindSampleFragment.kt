package net.matsudamper.viewbindingutil

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import net.matsudamper.viewbindingutil.databinding.FragmentMainBinding

class BindSampleFragment : Fragment(R.layout.fragment_main) {
    private val binding by bindViewBinding<FragmentMainBinding>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.button.setOnClickListener {
            Toast.makeText(context, "Clicked", Toast.LENGTH_SHORT).show()
            startActivity(Intent(context, InflateSampleActivity::class.java))
        }
    }
}