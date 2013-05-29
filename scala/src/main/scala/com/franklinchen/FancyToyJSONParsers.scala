package com.franklinchen

import scala.util.parsing.combinator.JavaTokenParsers

object FancyToyJSONParsers extends JavaTokenParsers {
  def value: Parser[ToyJSON] = obj |
    arr |
    stringLiteralStripped ^^ { JString(_) } |
    floatingPointNumber ^^ { s => JFloat(s.toFloat) } |
    "null" ^^^ JNull |
    "true" ^^^ JBoolean(true) |
    "false" ^^^ JBoolean(false)

  def stringLiteralStripped: Parser[String] =
    stringLiteral ^^ { s => s.substring(1, s.length-1) }

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
}
