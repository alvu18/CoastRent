package com.example.coastrent

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.SeekBar
import com.example.coastrent.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

  private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        binding.saleText.setText(getString(R.string.saleText, binding.saleBar.progress))

        binding.saleBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {

            override fun onProgressChanged(seekBar: SeekBar, progress: Int, fromUser: Boolean) {

                binding.saleText.setText(

                    getString(
                        R.string.saleText,
                        binding.saleBar.progress
                    )

                )
            }

            override fun onStartTrackingTouch(seekBar: SeekBar) {

            }

            override fun onStopTrackingTouch(seekBar: SeekBar) {

            }



        })

        binding.priceActivityButton.setOnClickListener { view: View ->
            val hour = binding.editHourText.text.toString()

                val intent = SaleActivity.newIntent(this@MainActivity,
                 2000,binding.saleBar.progress, hour.toInt())
                startActivity(intent)

        }

    }
}