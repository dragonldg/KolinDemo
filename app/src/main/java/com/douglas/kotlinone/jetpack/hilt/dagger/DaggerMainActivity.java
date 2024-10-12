package com.douglas.kotlinone.jetpack.hilt.dagger;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.douglas.kotlinone.R;

import javax.inject.Inject;

public class DaggerMainActivity extends AppCompatActivity {

    @Inject
    HttpObject httpObject;

    @Inject
    HttpObject httpObject2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dagger_main);
        DaggerHttpComponent.create().injectMainActivity(this);
        System.out.println(httpObject.toString());
        System.out.println(httpObject2.toString());
    }
}