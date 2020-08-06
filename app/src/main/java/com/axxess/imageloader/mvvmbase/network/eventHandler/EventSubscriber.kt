package com.axxess.imageloader.mvvmbase.network.eventHandler

interface EventSubscriber {
    fun onEvent(event: Event?)
}