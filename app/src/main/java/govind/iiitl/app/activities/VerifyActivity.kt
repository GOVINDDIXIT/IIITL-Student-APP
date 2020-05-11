package govind.iiitl.app.activities

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.inputmethod.EditorInfo
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import govind.iiitl.app.R
import govind.iiitl.app.signIn.Login
import kotlinx.android.synthetic.main.activity_verify.*

class VerifyActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_verify)

        submitBtn.setOnClickListener {
            submit()
        }

        verifyText.setOnEditorActionListener { v, actionId, event ->
             when (actionId) {
                EditorInfo.IME_ACTION_DONE -> {
                    val inputMethodManager: InputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
                    inputMethodManager.hideSoftInputFromWindow(v.applicationWindowToken, 0)
                    true
                }
                else -> false
            }
        }
    }

    private fun goToLoginActivity() {
        startActivity(Intent(this, Login::class.java))
        finish()
    }

    private fun submit() {
        val text = "GODREJ"
        if (verifyText.text.toString().toUpperCase() == text) {
            goToLoginActivity()
        } else {
            Toast.makeText(this, "Wrong Answer", Toast.LENGTH_LONG).show()
        }
    }
}
