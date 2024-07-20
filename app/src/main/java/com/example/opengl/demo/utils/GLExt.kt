package com.example.opengl.demo.utils

import android.app.ActivityManager
import android.content.Context
import com.example.opengl.demo.MyApplication


fun getGLVersion(): Int {
    val activityManager =
        MyApplication.getInstance().getSystemService(Context.ACTIVITY_SERVICE) as ActivityManager?
    val configurationInfo = activityManager?.deviceConfigurationInfo
    val supportsEs3 = (configurationInfo?.reqGlEsVersion ?: 0) >= 0x30000
    return if (supportsEs3) 3 else 2
}