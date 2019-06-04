package com.example.flutter;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.FrameLayout;

import io.flutter.facade.Flutter;
import io.flutter.view.FlutterView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FlutterView flutterView = Flutter.createView(this, getLifecycle(), "");
        setContentView(flutterView);
        View parent = (View) flutterView.getParent();
        parent.setVisibility(View.INVISIBLE);
        flutterView.addFirstFrameListener(() -> {
            System.out.println("============================");
            parent.setVisibility(View.VISIBLE);
        });
    }
}
