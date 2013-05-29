package com.franklinchen

object PrettyRegexMatcher extends RegexMatcher {
  override val name = "pretty regex matcher"

  // These are just strings, not regexes.
  val user = """[a-zA-Z]+"""
  val at = """@"""
  val domainSegment = """[^@\.]+"""
  val dot = """\."""

  // Create a giant string.
  val email = raw"""(?x)
    \A
    $user
    $at
    (
      $domainSegment $dot
    )+
    $domainSegment
    \z"""

  // Finally make a regex.
  val emailRegex = email.r

  override def matches(s: String): Boolean =
    (emailRegex findFirstMatchIn s).nonEmpty
}
