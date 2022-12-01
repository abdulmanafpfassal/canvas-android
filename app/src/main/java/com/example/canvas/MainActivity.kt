package com.example.canvas

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton

class MainActivity : AppCompatActivity() {

    private var drawingView: DrawingView? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        drawingView = findViewById(R.id.drawing_view)
        drawingView!!.setSizeForBrush(20.toFloat())
        val brush: ImageButton = findViewById(R.id.brush)

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
}