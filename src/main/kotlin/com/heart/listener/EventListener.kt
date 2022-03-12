package com.heart.listener

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.google.gson.JsonObject
import net.dv8tion.jda.api.entities.Activity
import net.dv8tion.jda.api.entities.Guild
import net.dv8tion.jda.api.events.ReadyEvent
import net.dv8tion.jda.api.hooks.ListenerAdapter
import netscape.javascript.JSObject
import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse
import java.util.concurrent.Executors
import java.util.concurrent.TimeUnit

class EventListener : ListenerAdapter() {

    override fun onReady(event: ReadyEvent) {

        val executator = Executors.newScheduledThreadPool(1)



        val task = Runnable {

            val client = HttpClient.newBuilder().build()
            val request = HttpRequest.newBuilder()
                .uri(URI.create("https://api.mcsrvstat.us/bedrock/2/play.nethergames.org"))
                .build();

            val response = client.send(request, HttpResponse.BodyHandlers.ofString());

            val gson = Gson()

            val responseObject = gson.fromJson(response.body(),JsonObject::class.java)

           // println("Total de jogadores: "+responseObject.get("players").asJsonObject.get("online").asInt)

            val players = responseObject.get("players").asJsonObject.get("online").asInt

            event.jda.presence.setPresence(Activity.playing("com $players jogadores"),false)

        }

        executator.scheduleWithFixedDelay(task,0,10,TimeUnit.SECONDS)

    }

}