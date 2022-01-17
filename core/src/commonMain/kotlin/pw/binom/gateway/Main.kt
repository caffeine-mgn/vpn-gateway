package pw.binom.gateway

import kotlinx.coroutines.*
import pw.binom.io.httpClient.HttpClient
import pw.binom.io.httpClient.create
import pw.binom.io.httpServer.HttpServer
import pw.binom.network.Network
import pw.binom.network.NetworkAddress
import pw.binom.network.bindUdp

private fun rr(f: suspend CoroutineScope.() -> Unit) {
    runBlocking {
        f(this)
    }
}

fun main(args: Array<String>) {
    rr {
        val udpPort = Dispatchers.Network.bindUdp(NetworkAddress.Immutable(host = "127.0.0.1", port = 36534))
        val client = HttpClient.create()
        launch {
            while (currentCoroutineContext().isActive){

            }
        }
        println("OLOLO!")
    }
}