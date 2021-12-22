package simulations

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.http.protocol.HttpProtocolBuilder

abstract class BaseSimulation extends Simulation {
  protected val httpProtocol: HttpProtocolBuilder = http.baseUrl("https://httpbin.org")
    .acceptHeader("application/json")
    .userAgentHeader("Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/96.0.4664.45 Safari/537.36")
}