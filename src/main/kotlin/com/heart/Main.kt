package com.heart

import com.heart.listener.EventListener
import net.dv8tion.jda.api.JDABuilder
import net.dv8tion.jda.api.entities.Activity
import java.util.concurrent.Executors
import java.util.concurrent.ThreadPoolExecutor
import javax.security.auth.login.LoginException

object Main {

    @JvmStatic
    fun main(args: Array<String>) {
       connect()
    }

    fun connect() {
        try {

            JDABuilder.createDefault("YOUR TOKEN")
                .setActivity(Activity.playing("With 0 players"))
                .addEventListeners(EventListener())
                .build()

        }catch (ex : LoginException) {
            ex.printStackTrace()
        }
    }

}