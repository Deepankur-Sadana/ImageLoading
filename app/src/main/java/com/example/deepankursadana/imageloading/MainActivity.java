package com.example.deepankursadana.imageloading;


import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.deepankursadana.imageloading.fragments.ContainerFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        loadFragment();
    }

    protected void loadFragment(){
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        ContainerFragment containerFragment = ContainerFragment.newInstance(null);// newInstance() is a static factory method.
        transaction.replace(R.id.container, containerFragment);
        transaction.commit();
    }
}
