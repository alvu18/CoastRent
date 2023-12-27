package com.example.coastrent

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.coastrent.databinding.ActivitySaleBinding


const val EXTRA_PRICE = "com.bignerdranch.android.coastrent.price"

const val EXTRA_SALE = "com.bignerdranch.android.coastrent.sale"

const val EXTRA_HOUR = "com.bignerdranch.android.coastrent.hour"
class SaleActivity : AppCompatActivity() {

 private lateinit var binding: ActivitySaleBinding

    private var price = 0

    private var sale = 0

    private var hour = 0

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        binding = ActivitySaleBinding.inflate(layoutInflater)

        setContentView(binding.root)

        price = intent.getIntExtra(EXTRA_PRICE,0)

        sale = intent.getIntExtra(EXTRA_SALE,0)

        hour = intent.getIntExtra(EXTRA_HOUR,0)



        val resPrice = hour * price * (1 - (sale.toDouble() / 100.0))

        binding.resultText.setText(getString(R.string.resultText,resPrice.toInt()))

    }

    companion object {
        fun newIntent(packageContext: Context, price: Int, sale:Int,hour:Int): Intent {

            return Intent(packageContext, SaleActivity::class.java).apply {

                putExtra(EXTRA_PRICE, price)

                putExtra(EXTRA_SALE, sale)

                putExtra(EXTRA_HOUR, hour)

            }
        }
    }
}