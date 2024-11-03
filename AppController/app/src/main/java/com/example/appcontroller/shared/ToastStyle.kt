package com.example.appcontroller.shared

import android.content.Context
import android.graphics.Color
import android.graphics.Typeface
import android.os.Handler
import android.os.Looper
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.widget.TextView
import android.widget.Toast
import com.example.appcontroller.R

class ToastStyle(private val context: Context) {
    fun showCustomToast(message: String, duration: Long) {
        val inflater: LayoutInflater = LayoutInflater.from(context)
        val layout: View = inflater.inflate(R.layout.custom_toast_layout, null)

        val text: TextView = layout.findViewById(R.id.toast_text)
        text.text = message
        text.setTextColor(Color.WHITE)
        text.textSize = 12f
        text.setTypeface(text.typeface, Typeface.BOLD)

        val toast = Toast(context.applicationContext)
        toast.duration = Toast.LENGTH_SHORT
        toast.view = layout

        toast.setGravity(Gravity.BOTTOM or Gravity.CENTER_HORIZONTAL, 0, 100)
        toast.show()

        Handler(Looper.getMainLooper()).postDelayed({
            toast.cancel()
        }, duration)
    }
}
