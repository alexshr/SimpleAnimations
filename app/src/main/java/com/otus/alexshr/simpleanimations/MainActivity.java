package com.otus.alexshr.simpleanimations;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.LayoutTransition;
import android.databinding.DataBindingUtil;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.ViewGroup.LayoutParams;

import com.otus.alexshr.simpleanimations.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        binding.container.getLayoutTransition().enableTransitionType(LayoutTransition.CHANGING);

        binding.button.setOnClickListener(view -> {
            LayoutParams panelParams = binding.panel.getLayoutParams();
            panelParams.height = panelParams.height == 0 ? LayoutParams.MATCH_PARENT : 0;
            binding.panel.setLayoutParams(panelParams);

            Animator flowerScaleAnim = AnimatorInflater.loadAnimator(this, R.animator.flower_scale_animator);

            Animatable animatable = (Animatable) binding.flower.getDrawable();

            new Handler().postDelayed(() -> {
                ((AnimationDrawable) binding.explosion.getDrawable()).stop();
                if (panelParams.height == 0) {
                    binding.flower.clearAnimation();
                    animatable.stop();
                } else {
                    ((AnimationDrawable) binding.explosion.getDrawable()).start();
                    flowerScaleAnim.setTarget(binding.flower);
                    flowerScaleAnim.start();
                    animatable.start();
                }
            }, 500);
        });
    }
}
