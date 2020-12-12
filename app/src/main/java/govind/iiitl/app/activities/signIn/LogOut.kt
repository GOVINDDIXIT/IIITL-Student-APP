package govind.iiitl.app.activities.signIn

import android.app.AlertDialog
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DecodeFormat
import com.bumptech.glide.request.RequestOptions
import com.bumptech.glide.request.target.Target
import com.firebase.ui.auth.AuthUI
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuth.AuthStateListener
import com.google.firebase.auth.FirebaseUser
import govind.iiitl.app.R
import kotlinx.android.synthetic.main.activity_log_out.*

class LogOut : AppCompatActivity() {
    private lateinit var sp: SharedPreferences
    private var mAuth: FirebaseAuth? = null
    private var mAuthListener: AuthStateListener? = null
    private var currentFirebaseUser: FirebaseUser? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_log_out)
        setupUserProfile()
        mAuth = FirebaseAuth.getInstance()
        mAuthListener = AuthStateListener { firebaseAuth: FirebaseAuth ->
            if (firebaseAuth.currentUser == null) {
                sp = getSharedPreferences("login", MODE_PRIVATE)
                val editor = sp.edit()
                editor.clear()
                editor.apply()
                goToLoginActivity()
            }
        }
        LogOutBtn.setOnClickListener { showLogoutDialog() }
    }

    private fun goToLoginActivity() {
        val intent = Intent(this@LogOut, Login::class.java)
        intent.flags =
            Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_CLEAR_TOP
        startActivity(intent)
        finish()
    }

    private fun showLogoutDialog() {
        val builder = AlertDialog.Builder(this@LogOut)
        builder.setMessage("Are you sure want to logout?")
        builder.setCancelable(true)
        builder.setPositiveButton("Yes") { dialog, id ->
            AuthUI.getInstance()
                .signOut(this)
                .addOnCompleteListener {
                    sp.edit().putBoolean("logged", false).apply()
                    Toast.makeText(this, "User is successfully logged out", Toast.LENGTH_LONG)
                }
            mAuth!!.signOut()
        }
        builder.setNegativeButton("No") { dialog, id -> dialog.cancel() }
        val alert = builder.create()
        alert.show()
    }

    //To set the user profile, fetch email, image, Name of the user
    private fun setupUserProfile() {
        currentFirebaseUser = FirebaseAuth.getInstance().currentUser
        user_name.text = currentFirebaseUser!!.displayName
        val s = currentFirebaseUser!!.email
        user_email.text = s!!.substring(0, Math.min(s.length, 10))
        val userPhotoUrl = currentFirebaseUser!!.photoUrl
        val originalPieceOfUrl = "s96-c/photo.jpg"
        var newUrl = ""
        val newPieceOfUrlToAdd = "s400-c/photo.jpg"
        if (userPhotoUrl != null) {
            val photoPath = userPhotoUrl.toString()
            newUrl = photoPath.replace(originalPieceOfUrl, newPieceOfUrlToAdd)
        }
        val options = RequestOptions()
        options.circleCrop()
        options.format(DecodeFormat.PREFER_ARGB_8888)
        options.override(Target.SIZE_ORIGINAL)
        if (newUrl.isNotEmpty()) {
            Glide.with(this).load(newUrl).apply(options).into(user_image)
        } else {
            user_name.visibility = View.GONE
        }
    }

    override fun onStart() {
        super.onStart()
        mAuth!!.addAuthStateListener(mAuthListener!!)
    }
}