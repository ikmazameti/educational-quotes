package com.femi.educationalquotes

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.femi.educationalquotes.databinding.ItemQuoteBinding

/**
 * TODO: Create adapter to show list of quotes
 *
 *
 */
class QuoteAdapter() : ListAdapter<Quote, QuoteAdapter.QuoteViewHolder>(QuoteDiff) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuoteViewHolder {
        val binding = ItemQuoteBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return QuoteViewHolder(binding)
    }


    override fun onBindViewHolder(holder: QuoteViewHolder, position: Int) {
        holder.bind(getItem(position))
    }


    class QuoteViewHolder(private val binding: ItemQuoteBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(quote: Quote) {
            binding.quoteTextView.text = quote.text
            binding.authorTextView.text = quote.author
        }
    }

    object QuoteDiff : DiffUtil.ItemCallback<Quote>() {
        override fun areItemsTheSame(
            oldItem: Quote, newItem: Quote
        ): Boolean = oldItem == newItem

        override fun areContentsTheSame(
            oldItem: Quote, newItem: Quote
        ): Boolean = oldItem.id == newItem.id
    }
}