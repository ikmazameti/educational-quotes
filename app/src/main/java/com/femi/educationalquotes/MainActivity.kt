package com.femi.educationalquotes

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.femi.educationalquotes.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val quoteAdapter = QuoteAdapter()

    private val quotes = listOf(
        Quote(1, "The only true wisdom is in knowing you know nothing.", "Socrates"),
        Quote(2, "I think, therefore I am.", "René Descartes"),
        Quote(3, "To be, or not to be, that is the question.", "William Shakespeare")
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.quotes.adapter = quoteAdapter
        quoteAdapter.submitList(quotes)
    }


}