package com.example.hw1a2.ui.Board

import android.content.Context
import android.graphics.Color
import android.opengl.Visibility
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.navigation.NavController
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.ViewPager
import com.example.hw1a2.Prefs
import com.example.hw1a2.R
import com.example.hw1a2.databinding.ItemBoardBinding
import com.example.hw1a2.databinding.ItemNewsBinding
import com.tbuonomo.viewpagerdotsindicator.DotsIndicator
import java.text.SimpleDateFormat
import java.util.*

class BoardAdapter( val context: Context ,val navController: NavController) :
    RecyclerView.Adapter<BoardAdapter.ViewHolder>() {

    var list = arrayListOf("Emil", "Emil", "Emil", "Opa")
    private val image = arrayListOf(R.raw.one,R.raw.two,R.raw.thee)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemBoardBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(position)
    }

    override fun getItemCount() = list.size



    inner class ViewHolder(private var binding: ItemBoardBinding) ://
        RecyclerView.ViewHolder(binding.root) {
        fun bind(position: Int) {

            binding.title.text = list[position]
            binding.lottione.setAnimation(image[position])

            if (position == list.lastIndex){
                binding.btnStart.visibility = View.VISIBLE
            }else{
                binding.btnStart.visibility = View.INVISIBLE
            }

            binding.btnStart.setOnClickListener {
                Prefs(context).saveState()
                navController.navigateUp()
            }
        }
    }
}



