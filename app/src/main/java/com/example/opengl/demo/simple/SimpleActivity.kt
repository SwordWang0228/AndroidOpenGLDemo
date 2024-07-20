package com.example.opengl.demo.simple

import android.opengl.GLSurfaceView
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.opengl.demo.databinding.ActivitySimpleBinding
import com.example.opengl.demo.utils.getGLVersion

class SimpleActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySimpleBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySimpleBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // OpenGL ES 3.0版本
        binding.glView.run {
            setEGLContextClientVersion(getGLVersion())
            setRenderer(TriangleRender())
            renderMode = GLSurfaceView.RENDERMODE_WHEN_DIRTY
        }
    }

    override fun onPause() {
        super.onPause()
        binding.glView.onPause()
    }

    override fun onResume() {
        super.onResume()
        binding.glView.onResume()
    }

}