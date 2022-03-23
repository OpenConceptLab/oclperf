package org.openconceptlab.oclperf;

import io.gatling.javaapi.core.*;
import io.gatling.javaapi.http.*;

import static io.gatling.javaapi.core.CoreDsl.*;
import static io.gatling.javaapi.http.HttpDsl.*;

public class VisitHomepage extends Simulation {

  {
    HttpProtocolBuilder httpProtocol = http
      .baseUrl(TestConfig.getBaseUrl())
      .inferHtmlResources(AllowList(), DenyList())
      .acceptHeader("*/*")
      .acceptEncodingHeader("gzip, deflate")
      .acceptLanguageHeader("en-US,en;q=0.5")
      .userAgentHeader("Mozilla/5.0 (X11; Fedora; Linux x86_64; rv:94.0) Gecko/20100101 Firefox/94.0");


    ScenarioBuilder scn = scenario("VisitHomepage")
      .exec(
        http("request_root")
          .get("/")
      );

	  setUp(scn.injectOpen(atOnceUsers(TestConfig.getMaxUsers()))).protocols(httpProtocol);
  }
}
