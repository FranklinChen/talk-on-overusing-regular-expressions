package com.franklinchen

import scala.util.parsing.combinator.JavaTokenParsers

object ToyJSONParsers extends JavaTokenParsers {
  def value: Parser[Any] = obj |
    arr |
    stringLiteral |
    floatingPointNumber |
    "null" |
    "true" | "false"

  def obj = "{" ~ repsep(member, ",") ~ "}"

  def arr = "[" ~ repsep(value, ",") ~ "]"

  def member = stringLiteral ~ ":" ~ value
}
