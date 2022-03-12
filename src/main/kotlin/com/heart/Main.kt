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

            JDABuilder.createDefault("OTExNzgyOTg2MjkzMzM4MTI0.YZmaFA.lIio2CPDwVmDfCEvbkbLFMi6j04")
                .setActivity(Activity.playing("com 0 jogadores"))
                .addEventListeners(EventListener())
                .build()

        }catch (ex : LoginException) {
            ex.printStackTrace()
        }
    }

}