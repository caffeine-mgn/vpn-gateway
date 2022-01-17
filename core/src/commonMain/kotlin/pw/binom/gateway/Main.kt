package pw.binom.gateway

import kotlinx.coroutines.*
import pw.binom.ByteBuffer
import pw.binom.io.httpClient.HttpClient
import pw.binom.io.httpClient.create
import pw.binom.io.httpServer.HttpServer
import pw.binom.net.toURI
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
            while (currentCoroutineContext().isActive) {

            }
        }
        println("OLOLO!")
    }
}

suspend fun runClient() {
    val udpPort = Dispatchers.Network.bindUdp(NetworkAddress.Immutable(host = "127.0.0.1", port = 36534))

    val buf = ByteBuffer.alloc(65535)
    coroutineScope {
        launch {
            while (true) {
                val addr = NetworkAddress.Mutable()
                buf.clear()
                udpPort.read(buf, addr)
            }
        }
    }

    val client = HttpClient.create()
    val wsConnection = client.connect(method = "GET", uri = "http://192.168.88.27:8022".toURI())
        .startWebSocket()
    coroutineScope {
        launch {
            while (currentCoroutineContext().isActive) {

            }
        }
    }

}