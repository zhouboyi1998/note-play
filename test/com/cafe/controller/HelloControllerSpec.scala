package com.cafe.controller

import org.scalatestplus.play.PlaySpec
import org.scalatestplus.play.guice.GuiceOneAppPerTest
import play.api.http.Status.OK
import play.api.libs.json.Json
import play.api.test.Helpers.{GET, contentAsJson, contentType, defaultAwaitTimeout, status}
import play.api.test.{FakeRequest, Injecting}

class HelloControllerSpec extends PlaySpec with GuiceOneAppPerTest with Injecting {

    "HelloController GET" should {
        "return a valid json response with 'Hello, Peter' when the name is Peter" in {
            val controller = app.injector.instanceOf[HelloController]
            val request = FakeRequest(GET, "/hello/Peter")
            val response = controller.hello("Peter").apply(request)

            status(response) mustBe OK
            contentType(response) mustBe Some("application/json")
            contentAsJson(response) mustBe Json.obj("message" -> "Hello, Peter", "code" -> 200)
        }
    }
}
