package com.example.canvas

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import android.widget.LinearLayout
import androidx.core.content.ContextCompat
import androidx.core.view.get

class MainActivity : AppCompatActivity() {

    private var drawingView: DrawingView? = null
    private var mSelectedCurrentButton: ImageButton? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        drawingView = findViewById(R.id.drawing_view)
        drawingView!!.setSizeForBrush(20.toFloat())
        val brush: ImageButton = findViewById(R.id.brush)

        val linearColorButtons = findViewById<LinearLayout>(R.id.linear_colors)
        mSelectedCurrentButton = linearColorButtons[2] as ImageButton
        mSelectedCurrentButton!!.setImageDrawable(
            ContextCompat.getDrawable(this, R.drawable.color_pellet_pressed)
        )


        brush.setOnClickListener {
            showBrushSizeDialog()
        }
    }

    private fun showBrushSizeDialog(){
        val brushDialog = Dialog(this)
        brushDialog.setContentView(R.layout.drawing_brush_size)
        brushDialog.setTitle("Brush size: ")
        val smallBtn = brushDialog.findViewById<ImageButton>(R.id.brush_small_size)
        val mediumBtn = brushDialog.findViewById<ImageButton>(R.id.brush_medium_size)
        val largeBtn = brushDialog.findViewById<ImageButton>(R.id.brush_large_size)

        smallBtn.setOnClickListener {
            drawingView?.setSizeForBrush(10.toFloat())
            brushDialog.dismiss()
        }

        mediumBtn.setOnClickListener {
            drawingView?.setSizeForBrush(20.toFloat())
            brushDialog.dismiss()
        }

        largeBtn.setOnClickListener {
            drawingView?.setSizeForBrush(30.toFloat())
            brushDialog.dismiss()
        }
        brushDialog.show()
    }

    fun paintClicked(view: View){
        if(view !== mSelectedCurrentButton){
            val imageButton = view as ImageButton
            val colorTag = imageButton.tag.toString()
            drawingView?.changeColor(colorTag)

            imageButton.setImageDrawable(
                ContextCompat.getDrawable(this, R.drawable.color_pellet_pressed)
            )
            mSelectedCurrentButton?.setImageDrawable(
                ContextCompat.getDrawable(this, R.drawable.color_pellet)
            )
            mSelectedCurrentButton = view
        }
    }
}