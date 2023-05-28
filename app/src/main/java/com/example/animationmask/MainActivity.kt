package com.example.animationmask

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.widget.Adapter
import androidx.recyclerview.widget.GridLayoutManager
import com.example.animationmask.databinding.ActivityMainBinding
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding
    private lateinit var adapter: MyAdapter
    private val mask1 = Array<Int>(16) { it*6}
    private val mask2 = Array<Int>(16) { it*6+2}
    private val mask3 = Array<Int>(16) { it*6+4}
    private val mask4 = Array<Int>(6) { it}
    private val mask5 = Array<Int>(6) { it+12}
    private val mask6 = Array<Int>(6) { it+24}
    private val mask7 = Array<Int>(6) { it+36}
    private val mask8 = Array<Int>(6) { it+48}
    private val mask9 = Array<Int>(6) { it+60}
    private val mask10 = Array<Int>(6) { it+72}
    private val mask11 = Array<Int>(6) { it+84}
    private var position=1
    private val hashMap= hashMapOf<Int,Array<Int>>(1 to mask1,2 to mask2,3 to mask3,4 to mask4,5 to mask5,6 to mask6,
        6 to mask6,7 to mask7,8 to mask8,9 to mask9,10 to mask10,11 to mask11)

    private val countDownTimer=object :CountDownTimer(11000,1000) {
        override fun onTick(millisUntilFinished: Long) {
            val random=Random.nextInt(96)
            adapter= MyAdapter(applicationContext,hashMap[position]!!,random)
            binding.recyclerview.layoutManager=GridLayoutManager(applicationContext,6)
            binding.recyclerview.adapter=adapter
            position++

        }

        override fun onFinish() {
            position=1
            this.start()
        }


    }




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        countDownTimer.start()



    }

    override fun onRestart() {
        super.onRestart()
        position=1
        countDownTimer.start()
    }

    override fun onStop() {
        super.onStop()
        countDownTimer.cancel()
    }

    override fun onDestroy() {
        super.onDestroy()
        countDownTimer.cancel()
    }
}