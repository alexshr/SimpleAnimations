package com.otus.alexshr.simpleanimations;

import android.animation.LayoutTransition;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.ViewGroup.LayoutParams;

import com.otus.alexshr.simpleanimations.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        binding.container.getLayoutTransition().enableTransitionType(LayoutTransition.CHANGING);

        binding.button.setOnClickListener(view -> {
            LayoutParams panelParams = binding.panel.getLayoutParams();
            panelParams.height = panelParams.height == 0 ? LayoutParams.MATCH_PARENT : 0;
            binding.panel.setLayoutParams(panelParams);
        });
    }
}
