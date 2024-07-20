/*
 *
 * FGLView.java
 *
 * Created by Wuwang on 2016/9/29
 */
package com.example.opengl.demo.render;

import android.content.Context;
import android.opengl.GLSurfaceView;
import android.util.AttributeSet;
import android.util.Log;

import com.example.opengl.demo.render.shape.FGLRender;
import com.example.opengl.demo.render.shape.Shape;

/**
 * Description:
 */
public class FGLView extends GLSurfaceView {

    private static final String TAG = "FGLView";

    private FGLRender renderer;

    public FGLView(Context context) {
        this(context, null);
    }

    public FGLView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        setEGLContextClientVersion(2);
        setRenderer(renderer = new FGLRender(this));
        setRenderMode(GLSurfaceView.RENDERMODE_WHEN_DIRTY);
    }

    public void setShape(Class<? extends Shape> clazz) {
        try {
            renderer.setShape(clazz);
        } catch (Exception e) {
            Log.e(TAG, "setShape: " + e, e);
        }
    }

}
