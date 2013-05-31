package com.franklinchen

import scala.util.parsing.combinator.JavaTokenParsers

object FancyToyJSONParsers extends JavaTokenParsers {
  def stringLiteralStripped: Parser[String] =
    stringLiteral ^^ { s => s.substring(1, s.length-1) }

  def value: Parser[ToyJSON] = obj |
    arr |
    stringLiteralStripped ^^ { s => JString(s) } |
    floatingPointNumber ^^ { s => JFloat(s.toFloat) } |
    "null" ^^^ JNull |
    "true" ^^^ JBoolean(true) |
    "false" ^^^ JBoolean(false)

  def obj: Parser[JObject] = "{" ~>
      (repsep(member, ",") ^^
       { aList => JObject(aList.toMap) }) <~ "}"

  def arr: Parser[JArray] = "[" ~>
      (repsep(value, ",") ^^
       { aList => JArray(aList) }) <~ "]"

  def member: Parser[(String, ToyJSON)] =
    ((stringLiteralStripped <~ ":") ~ value) ^^ {
    case s ~ v => s -> v
  }

  def main(args: Array[String]) {
    val j = """{
      "distance" : 5.6,
      "address" : {
        "street" : "0 Nowhere Road",
        "neighbors" : ["X", "Y"],
        "garage" : null
      }
    }"""

    parseAll(value, j) match {
      case Success(result, _) =>
        println(result)
      case failure: NoSuccess =>
        println("Parse failed, and here's why:")
        println(failure)
    }
  }
}
