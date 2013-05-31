package com.franklinchen

object PrettyRegexMatcher extends RegexMatcher {
  override val name = "pretty regex matcher"

  val user = """[a-zA-Z]+"""
  val domainChar = """[^@\.]"""
  val domainSegment = raw"""(?x) $domainChar+"""
  val at = """@"""
  val dot = """\."""
  val domain = raw"""(?x)
    ( $domainSegment $dot )+ $domainSegment"""
  val email = raw"""(?x) \A $user $at $domain \z"""

  val emailRegex = email.r

  def matches(s: String): Boolean =
    (emailRegex findFirstMatchIn s).nonEmpty
}
