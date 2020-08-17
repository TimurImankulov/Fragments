package com.example.lesson14

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.FrameLayout
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), FragmentListener {

    private var container: FrameLayout? = null
    private val secondFragment = SecondFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupViews()
        setupListeners()
    }

    private fun setupListeners() {
        btnAdd?.setOnClickListener {
            supportFragmentManager
                .beginTransaction()
                .add(R.id.container, FirstFragment())
                .commit()
        }
    }

    private fun setupViews() {
        container = findViewById(R.id.container)
    }

    override fun replaceFragment() {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.container, secondFragment)
            .commit()
    }

    override fun removeFragment() {
        supportFragmentManager
            .beginTransaction()
            .remove(secondFragment)
            .commit()
    }
}

