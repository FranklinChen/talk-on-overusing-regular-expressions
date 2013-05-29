package com.franklinchen

import org.specs2._
import org.specs2.specification._

import scala.util.parsing.combinator.JavaTokenParsers

class FancyToyJSONParsersSpec extends Specification
     with matcher.ParserMatchers { def is = s2"""
  The fancy toy JSON parser
    parses nested data and then uses it      $e1
  """

  def e1 = {
    parsers.value must succeedOn("""{
      "distance" : 5.6,
      "address" : {
        "street" : "0 Nowhere Road",
        "neighbors" : ["X", "Y"],
        "garage" : null
      }
    }""").withResult({ result: ToyJSON =>
      result.asInstanceOf[JObject].
        map("address").asInstanceOf[JObject].
        map("neighbors").asInstanceOf[JArray].
        list(1).asInstanceOf[JString].
        string
    } ^^ be_==("Y"))
  }

  override val parsers = FancyToyJSONParsers
}
