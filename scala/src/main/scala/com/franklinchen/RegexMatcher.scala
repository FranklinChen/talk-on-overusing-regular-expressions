package com.franklinchen

trait RegexMatcher {
  val name: String
  def matches(s: String): Boolean
}
