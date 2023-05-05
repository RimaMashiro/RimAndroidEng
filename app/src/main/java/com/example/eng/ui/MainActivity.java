package com.example.eng.ui;

import android.os.Bundle;

import androidx.annotation.NavigationRes;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.NavGraph;
import androidx.navigation.fragment.NavHostFragment;

import com.example.eng.R;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class MainActivity extends AppCompatActivity {

    private MainViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ViewModelProvider provider = new ViewModelProvider(this);
        viewModel = provider.get(MainViewModel.class);
        initNavigationToMainFlow();
    }

    private void initNavigationToMainFlow() {
        viewModel.user.observe(this, firebaseUser -> {
            NavHostFragment navHostFragment = (NavHostFragment) getSupportFragmentManager()
                    .findFragmentById(R.id.containerFragment);
            NavController navController = navHostFragment.getNavController();
            @NavigationRes
            int navGraphResId = firebaseUser == null ?
                    R.navigation.registration_nav_graph :
                    R.navigation.main_flow_nav_graph;
            NavGraph navGraph = navController.getNavInflater().inflate(navGraphResId);
            navController.setGraph(navGraph);
        });
    }
}