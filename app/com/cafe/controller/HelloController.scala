package com.cafe.controller

import play.api.libs.json.Json
import play.api.mvc.{Action, AnyContent, BaseController, ControllerComponents}

import javax.inject.{Inject, Singleton}

@Singleton
class HelloController @Inject()(val controllerComponents: ControllerComponents) extends BaseController {

    def hello(name: String): Action[AnyContent] = Action {
        Ok(Json.obj("message" -> s"Hello, $name", "code" -> 200))
    }
}
