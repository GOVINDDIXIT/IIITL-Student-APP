package govind.iiitl.app.signIn

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.firebase.ui.auth.AuthUI
import com.firebase.ui.auth.AuthUI.IdpConfig
import com.firebase.ui.auth.AuthUI.IdpConfig.EmailBuilder
import com.firebase.ui.auth.AuthUI.IdpConfig.GoogleBuilder
import com.firebase.ui.auth.IdpResponse
import com.google.firebase.auth.FirebaseAuth
import govind.iiitl.app.MainActivity
import govind.iiitl.app.R

class Login : AppCompatActivity() {
    private lateinit var sp: SharedPreferences
    var providers: List<IdpConfig>? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        sp = getSharedPreferences("login", MODE_PRIVATE)
        if (sp.getBoolean("logged", false)) {
            goToMainActivity()
        } else {
            //Init Providers
            providers = listOf(
                    EmailBuilder().build(),  //  new AuthUI.IdpConfig.PhoneBuilder().build(),
                    //  new AuthUI.IdpConfig.FacebookBuilder().build(),
                    GoogleBuilder().build()
            )
            showSignInOptions()
        }
    }

    private fun goToMainActivity() {
        startActivity(Intent(this@Login, MainActivity::class.java))
        finish()
    }

    private fun showSignInOptions() {
        startActivityForResult(
                AuthUI.getInstance().createSignInIntentBuilder()
                        .setAvailableProviders(providers!!)
                        .setTheme(R.style.FirebaseUITheme)
                        .setLogo(R.drawable.graduate)
                        .build(), MY_REQUEST_CODE
        )
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == MY_REQUEST_CODE) {
            val response = IdpResponse.fromResultIntent(data)
            if (resultCode == RESULT_OK) {
                //Get Current User
                val user = FirebaseAuth.getInstance().currentUser!!
                Toast.makeText(this, "Welcome " + user.displayName + "!", Toast.LENGTH_LONG).show()
                sp.edit().putBoolean("logged", true).apply()
                goToMainActivity()
            } else {
                Toast.makeText(this, "Service unavailable. Try login using email", Toast.LENGTH_LONG).show()
            }
        }
    }

    companion object {
        private const val MY_REQUEST_CODE = 1
    }
}