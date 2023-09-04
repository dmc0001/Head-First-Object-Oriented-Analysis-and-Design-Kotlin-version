package com.example.chan1.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import com.example.chan1.R
import com.example.chan1.databinding.ActivityFindGuitarTesterBinding


class FindGuitarTesterActivity : AppCompatActivity() {
    private lateinit var binding: ActivityFindGuitarTesterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFindGuitarTesterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navController = findNavController(R.id.HostFragment)
    }


}