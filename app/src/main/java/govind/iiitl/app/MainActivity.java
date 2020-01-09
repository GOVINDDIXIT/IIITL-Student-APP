package govind.iiitl.app;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.net.ConnectivityManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.browser.customtabs.CustomTabsIntent;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.navigation.NavigationView;

import govind.iiitl.app.Adapter.PostAdapter;
import govind.iiitl.app.Models.PostList;
import govind.iiitl.app.SignIn.LogOut;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    DrawerLayout drawerLayout;
    Toolbar toolbar;
    ActionBarDrawerToggle actionBarDrawerToggle;
    NavigationView navigationView;
    RecyclerView recyclerView;
    ImageView noNetworkImageView;
    Button retryButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        noNetworkImageView = findViewById(R.id.no_network_image_view);
        retryButton = findViewById(R.id.retry_button);

        boolean network = isNetworkConnected();

        retryButton.setOnClickListener((View v) -> getData());

        if (network) {
            noNetworkImageView.setVisibility(View.GONE);
            retryButton.setVisibility(View.GONE);
        }

        recyclerView = findViewById(R.id.postList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        setUpToolbar();

        navigationView = findViewById(R.id.navigation_menu);
        navigationView.setItemIconTintList(null);
        navigationView.setNavigationItemSelectedListener(item -> {
            switch (item.getItemId()) {
                case R.id.nav_TimeTable:
                    startActivity(new Intent(MainActivity.this, AskDetail.class));
                    break;
                case R.id.nav_axios:
                    openWebPage(getResources().getString(R.string.axios_website));
                    break;
                case R.id.nav_dsc:
                    openWebPage(getResources().getString(R.string.dsc_website));
                    break;
                case R.id.nav_equinox:
                    openWebPage(getResources().getString(R.string.equinox_website));
                    break;
                case R.id.nav_GetSetFoss:
                    openWebPage(getResources().getString(R.string.GetSetFOSS_website));
                    break;
                case R.id.nav_mess_menu:
                    Intent intent = new Intent(this, MessMenuActivity.class);
                    intent.putExtra("ViewType", "assets");
                    startActivity(intent);
                    break;
                case R.id.nav_ecell:
                    openWebPage(getResources().getString(R.string.ecellwebsite));
                    break;
                case R.id.nav_logOut:
                    startActivity(new Intent(MainActivity.this, LogOut.class));
                    break;
                case R.id.nav_faculty:
                    startActivity((new Intent(MainActivity.this, FacultyActivity.class)));
                    break;
                case R.id.nav_extras:
                    startActivity(new Intent(MainActivity.this, Extra.class));
                    break;
                case R.id.retry_button: {
                    getData();
                    break;
                }
                case R.id.nav_aboutus: {
                    startActivity(new Intent(MainActivity.this, AboutPage.class));
                    break;
                }
            }
            return false;
        });
        getData();
    }

    private boolean isNetworkConnected() {
        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        assert cm != null;
        return cm.getActiveNetworkInfo() != null && cm.getActiveNetworkInfo().isConnected();
    }

    private void openWebPage(String url) {
        CustomTabsIntent.Builder builder = new CustomTabsIntent.Builder();
        builder.setToolbarColor(Color.parseColor("#000000"));
        CustomTabsIntent customTabsIntent = builder.build();
        customTabsIntent.launchUrl(this, Uri.parse(url));
    }

    private void setUpToolbar() {
        drawerLayout = findViewById(R.id.drawerLayout);
        toolbar = findViewById(R.id.toolbar);

        //To give backward Compatibility
        setSupportActionBar(toolbar);

        //To sync Drawer and Toolbar
        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.app_name, R.string.app_name);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
    }

    private void getData() {
        Call<PostList> postList = BloggerAPI.getService().getPostList();
        postList.enqueue(new Callback<PostList>() {
            @Override
            public void onResponse(Call<PostList> call, Response<PostList> response) {
                PostList list = response.body();
                PostAdapter adapter = new PostAdapter(MainActivity.this, list.getItems());
                recyclerView.setAdapter(adapter);

                if (adapter.getItemCount() != 0) {
                    noNetworkImageView.setVisibility(View.GONE);
                    retryButton.setVisibility(View.GONE);
                }
            }

            @Override
            public void onFailure(Call<PostList> call, Throwable t) {
                Toast.makeText(MainActivity.this, "No Internet Connection Found", Toast.LENGTH_SHORT).show();

            }
        });
    }
}
