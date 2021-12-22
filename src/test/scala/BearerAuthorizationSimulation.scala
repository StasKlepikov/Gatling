package simulations

import io.gatling.core.Predef._
import io.gatling.core.structure.ScenarioBuilder
import io.gatling.http.Predef._

class BearerAuthorizationSimulation extends BaseSimulation {
  val scn: ScenarioBuilder =
    scenario("Bearer authorization")
      .exec(
        http("bearer_auth_request")
          .get("/bearer")
          .header("Authorization", "Bearer ExampleTokenValue")
          .check(jsonPath("$..token").is("ExampleTokenValue"))
          .check(status.is(200))
      )

  setUp(scn.inject(
    rampUsersPerSec(5) to 10 during 10)
    .protocols(httpProtocol))
}
