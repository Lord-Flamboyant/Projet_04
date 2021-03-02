package com.example.maru.Main;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import com.example.maru.R;
import com.example.maru.View.Room.ListPageAdapter;
import com.example.maru.View.NewMeeting;
import com.example.maru.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding activityMainBinding;
    ListPageAdapter mListPageAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityMainBinding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = activityMainBinding.getRoot();
        setContentView(view);
        configureToolbar();

        mListPageAdapter = new ListPageAdapter(getSupportFragmentManager());
        activityMainBinding.container.setAdapter(mListPageAdapter);
        activityMainBinding.buttonAddMeeting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent newMeeting = new Intent(MainActivity.this, NewMeeting.class);
                startActivity(newMeeting);
            }
        });

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu,menu);
        return true;
    }

    private void configureToolbar() {
        Toolbar toolbar = activityMainBinding.mytoolbar.toolbar;
        setSupportActionBar(toolbar);
    }
}

/// TODO: make research option