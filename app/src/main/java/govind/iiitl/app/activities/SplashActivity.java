package govind.iiitl.app.activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

import govind.iiitl.app.MainActivity;
import govind.iiitl.app.R;

public class SplashActivity extends AppCompatActivity {
    SharedPreferences sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        sp = getSharedPreferences("login", MODE_PRIVATE);

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if (sp.getBoolean("logged", false)) {
                    goToMainActivity();
                } else {
                    goToVerifyActivity();
                }
            }
        }, 2000);
    }

    private void goToMainActivity() {
        Intent intent = new Intent(SplashActivity.this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    private void goToVerifyActivity() {
        Intent intent = new Intent(SplashActivity.this, VerifyActivity.class);
        startActivity(intent);
        finish();
    }
}
