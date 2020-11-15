package govind.iiitl.app

import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Intent
import androidx.core.app.NotificationCompat
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage

class MessagingService : FirebaseMessagingService() {
    override fun onMessageReceived(remoteMessage: RemoteMessage) {
        showNotification(remoteMessage.notification!!.body)
    }

    private fun showNotification(message: String?) {
        val pi = PendingIntent.getActivity(this, 0, Intent(this, MainActivity::class.java), 0)
        val notification = NotificationCompat.Builder(this)
                .setSmallIcon(R.drawable.ic_stat_name)
                .setContentTitle("IIITL")
                .setContentText(message)
                .setContentIntent(pi)
                .setAutoCancel(true)
                .build()
        val notificationManager = getSystemService(NOTIFICATION_SERVICE) as NotificationManager
        notificationManager.notify(0, notification)
    }
}