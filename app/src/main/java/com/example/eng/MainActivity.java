package com.example.eng;

import android.os.Bundle;

import com.example.eng.databinding.FragmentRegistrationBinding;
import com.example.eng.ui.registration.RegistrationViewModel;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;

import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.NavGraph;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.recyclerview.widget.RecyclerView;

import com.example.eng.databinding.ActivityMainBinding;

import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class MainActivity extends AppCompatActivity {

    private MainViewModel viewModel;
    private ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ViewModelProvider provider = new ViewModelProvider(this);
        viewModel = provider.get(MainViewModel.class);
        initNavigationToMainFlow();
    }
    private void initNavigationToMainFlow(){
        viewModel.user.observe(this, firebaseUser -> {
            NavHostFragment navHostFragment = (NavHostFragment) getSupportFragmentManager()
                    .findFragmentById(R.id.containerFragment);
            NavGraph navGraph;
            NavController navController = navHostFragment.getNavController();
            if (firebaseUser==null){
                navGraph = navController.getNavInflater().inflate(R.navigation.registration_nav_graph);
            } else{
                navGraph = navController.getNavInflater().inflate(R.navigation.main_flow_nav_graph);
            }
            navController.setGraph(navGraph);
        });
    }

}