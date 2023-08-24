package com.example.jktvehicleapp.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import com.example.jktvehicleapp.R;
import com.example.jktvehicleapp.databinding.ActivityMainBinding;
import com.example.jktvehicleapp.databinding.CustomPopupDialogBinding;
import com.example.jktvehicleapp.fragment.AboutUsFragment;
import com.example.jktvehicleapp.fragment.HomeFragment;
import com.example.jktvehicleapp.fragment.RideHistoyFragment;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private ActivityMainBinding binding;
    TextView tvHeaderName;
    ActionBarDrawerToggle actionBarDrawerToggle;
    private Fragment fragment = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Window w = getWindow();
            w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        }

        initView();
        initListener();


        if(savedInstanceState==null){
            fragment = new HomeFragment();
            getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer, new HomeFragment()).commit();
            binding.navView.setCheckedItem(R.id.nav_home);
        }
    }

    private void initListener() {
        binding.rlSearch.setOnClickListener(nilam->{
            startActivity(new Intent(MainActivity.this, SearchActivity.class));
        });

    }

    private void initView() {

        binding.navView.setNavigationItemSelectedListener(MainActivity.this);

        binding.drawerLayout.setVisibility(View.VISIBLE);

        actionBarDrawerToggle = new ActionBarDrawerToggle(this, binding.drawerLayout, binding.toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);

        binding.drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.navView);
        View headerView = navigationView.getHeaderView(0);
        TextView tvHeaderName = (TextView) headerView.findViewById(R.id.tvHeaderName);
        tvHeaderName.setText("Nilam Naaznin");

        tvHeaderName.setOnClickListener(n->{
            Intent intent=new Intent(MainActivity.this,ProfileActivity.class);
            startActivity(intent);
        });
    }

    @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

            switch (menuItem.getItemId()){

                case R.id.nav_home:
                    fragment = new HomeFragment();
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer, new HomeFragment()).commit();
                    binding.navView.setCheckedItem(R.id.nav_home);
                    binding.toolbar.setVisibility(View.VISIBLE);
                    break;

                case R.id.nav_ride_history:
                    fragment = new RideHistoyFragment();
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer, new RideHistoyFragment()).commit();
                    binding.navView.setCheckedItem(R.id.nav_ride_history);
                    binding.toolbar.setVisibility(View.INVISIBLE);
                    break;

           /*     case R.id.nav_about_us:
                    fragment = new AboutUsFragment();
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer, new AboutUsFragment()).commit();
                    binding.navView.setCheckedItem(R.id.nav_about_us);
                    binding.toolbar.setVisibility(View.INVISIBLE);
                    break;*/
            }
            binding.drawerLayout.closeDrawer(GravityCompat.START);
            return true;
        }

    @Override
    public void onBackPressed() {

        if( fragment instanceof HomeFragment){
            Intent startMain = new Intent(Intent.ACTION_MAIN);
            startMain.addCategory(Intent.CATEGORY_HOME);
            startMain.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            binding.toolbar.setVisibility(View.VISIBLE);
            startActivity(startMain);
        }

        else{
            fragment = new HomeFragment();
            getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer, new HomeFragment()).commit();
            binding.navView.setCheckedItem(R.id.nav_home);
        }

    }
}