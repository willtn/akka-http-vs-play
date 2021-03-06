package com.whiteprompt.api.utils

import de.heikoseeberger.akkahttpjson4s._
import org.json4s.ext.UUIDSerializer
import org.json4s.{DefaultFormats, jackson}

trait Json4sJacksonSupport extends Json4sSupport {
  implicit val serialization = jackson.Serialization
  implicit val formats = DefaultFormats + UUIDSerializer

  implicit val prettyPrint = Json4sSupport.ShouldWritePretty.True
}