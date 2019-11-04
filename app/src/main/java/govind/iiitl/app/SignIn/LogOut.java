package govind.iiitl.app.SignIn;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.Target;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import govind.iiitl.app.R;

public class LogOut extends AppCompatActivity {

    SharedPreferences sp;
    private Button mLogOutButton;
    private Button LinkToBlogBtn;
    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;
    private FirebaseUser currentFirebaseUser;
    private TextView username;
    private TextView usermailId;
    private ImageView userDisplayPicture;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_out);
        setupUserProfile();
        LinkToBlogBtn = findViewById(R.id.linktoBlogBtn);
        LinkToBlogBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openWebPage("http://iiitlblog.blogspot.com/");
            }
        });

        mAuth = FirebaseAuth.getInstance();
        mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                if (firebaseAuth.getCurrentUser() == null) {
                    sp = getSharedPreferences("login", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sp.edit();
                    editor.clear();
                    editor.apply();
                    startActivity(new Intent(LogOut.this, Login.class));
                    finish();
                }
            }
        };

        mLogOutButton = findViewById(R.id.LogOutBtn);
        mLogOutButton.setOnClickListener(view -> mAuth.signOut());
    }

    //To set the user profile, fetch email, image, Name of the user
    private void setupUserProfile() {
        currentFirebaseUser = FirebaseAuth.getInstance().getCurrentUser();
        username = findViewById(R.id.user_name);
        usermailId = findViewById(R.id.user_email);
        userDisplayPicture = findViewById(R.id.user_image);
        username.setText(currentFirebaseUser.getDisplayName());
        String s = currentFirebaseUser.getEmail();
        usermailId.setText(s.substring(0, Math.min(s.length(), 10)));
        Uri userPhotoUrl = currentFirebaseUser.getPhotoUrl();
        String originalPieceOfUrl = "s96-c/photo.jpg";
        String newUrl = "";
        String newPieceOfUrlToAdd = "s400-c/photo.jpg";
        if (userPhotoUrl != null) {
            String photoPath = userPhotoUrl.toString();
            newUrl = photoPath.replace(originalPieceOfUrl, newPieceOfUrlToAdd);
        }
        RequestOptions options = new RequestOptions();
        options.circleCrop();
        options.format(DecodeFormat.PREFER_ARGB_8888);
        options.override(Target.SIZE_ORIGINAL);
        Glide.with(this).load(newUrl).apply(options).into(userDisplayPicture);
    }

    @Override
    protected void onStart() {
        super.onStart();
        mAuth.addAuthStateListener(mAuthListener);
    }

    public void openWebPage(String url) {
        Toast.makeText(LogOut.this, "Wait a while....", Toast.LENGTH_SHORT).show();
        Intent implicit = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        startActivity(implicit);
    }

    private void goToLogin() {
        startActivity(new Intent(this, Login.class));
    }
}
