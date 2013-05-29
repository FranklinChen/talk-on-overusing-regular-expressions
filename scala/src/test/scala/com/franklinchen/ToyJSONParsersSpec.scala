package com.franklinchen

import org.specs2._
import org.specs2.specification._

import scala.util.parsing.combinator.RegexParsers

class ToyJSONParsersSpec extends Specification
     with matcher.ParserMatchers { def is = s2"""
  The toy JSON parser
    parses nested data       $e1
  """

  def e1 =
    parsers.value must succeedOn("""{
      "distance" : 5.6,
      "address" : {
        "street" : "0 Nowhere Road",
        "neighbors": ["X", "Y"],
        "garage" : null
      }
    }""")

  override val parsers = ToyJSONParsers
}
