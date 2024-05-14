package com.example.sendpokeapp

import android.annotation.SuppressLint
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat

@SuppressLint("MissingPermission")
fun showNotification(context: Context, title: String, content: String) {
    val channelId = "default_channel_id"
    val channelName = "Default Channel"
    val notificationId = 1

    // Create notification channel
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
        val importance = NotificationManager.IMPORTANCE_DEFAULT
        val channel = NotificationChannel(channelId, channelName, importance).apply {
            description = "Default Channel Description"
        }
        val notificationManager = context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        notificationManager.createNotificationChannel(channel)
    }

    // Build the notification
    val builder = NotificationCompat.Builder(context, channelId)
        .setSmallIcon(android.R.drawable.ic_dialog_info)
        .setContentTitle(title)
        .setContentText(content)
        .setPriority(NotificationCompat.PRIORITY_DEFAULT)

    // Show the notification
    with(NotificationManagerCompat.from(context)) {
        notify(notificationId, builder.build())
    }
}

@Composable
fun UserHome(){
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement =  Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
//        Image(painter = painterResource(id = R.drawable.a), contentDescription = "User Home",
//            modifier = Modifier.fillMaxSize())
        val context = LocalContext.current

     Button(
            onClick = {
                showNotification(context, "Button Clicked", "You clicked the button!")
            },
            modifier = Modifier.padding(16.dp)
        ) {
            Text("Poke")
        }
    }
}