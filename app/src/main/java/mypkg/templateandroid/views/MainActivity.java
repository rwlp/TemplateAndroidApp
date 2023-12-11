package mypkg.templateandroid.views;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.core.view.GravityCompat;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import java.util.Objects;

import mypkg.templateandroid.R;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout drawerLayout;
    private NavController navController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Declaration and initialization of variables.
        BottomNavigationView bottomNavigationView;
        Toolbar toolbar;
        NavigationView navigationView;
        drawerLayout = findViewById(R.id.dl_drawer_mainactivity);
        navController = Navigation.findNavController(this, R.id.f_navhostfragment_mainactivity);
        toolbar = findViewById(R.id.tb_topBar_mainactivity);
        bottomNavigationView = findViewById(R.id.bnv_bottombar_mainactivity);
        navigationView = findViewById(R.id.nv_rightmenu_mainactivity);
        navigationView.setNavigationItemSelectedListener(this);

        // Setting TopBar
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setDisplayShowTitleEnabled(false);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        // Setting bottom Navigation bar
        bottomNavigationView.setOnItemSelectedListener(item -> {
            int id = item.getItemId();
            if (id == R.id.button_home_bottombar ) {
                navController.navigate(R.id.homeFragment);
                return true;
            } else if (id == R.id.button_content_bottombar ) {
                navController.navigate(R.id.contentFragment);
                return true;
            } else if (id == R.id.button_senddata_bottombar) {
                navController.navigate(R.id.sendDataFragment);
                return true;
            } else if (id == R.id.button_donate_bottombar) {
                navController.navigate(R.id.donateFragment);
                return true;
            } else if (id == R.id.button_moremenu_bottombar) {
                navController.navigate(R.id.moreMenuFragment);
                return true;
            }

            return false;
        });
    }

    /**
     * Implements the NavigationView.OnNavigationItemSelectedListener.
     * This method controls the behavior of the Navigation Drawer Menu.
     * For more details, refer to the documentation at developer.android.com/guide.
     *
     * @param item The selected item.
     * @return boolean indicating the selected menu button.
     */
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        // Here are handle the navigation in Menu of Navigation Drawer Menu
        int id = item.getItemId();
        if (id == R.id.navDrawerButtonProfileSettings) {
            navController.navigate(R.id.sendDataFragment);
            drawerLayout.closeDrawer(GravityCompat.START); // Close the navigation drawer
            return true;
        }
        drawerLayout.closeDrawer(GravityCompat.START); // Close the navigation drawer
        return false;
    }
}