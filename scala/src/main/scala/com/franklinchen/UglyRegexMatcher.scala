package com.franklinchen

object UglyRegexMatcher extends RegexMatcher {
  override val name = "ugly regex matcher"

  val emailRegex = """\A[a-zA-Z]+@([^@\.]+\.)+[^@\.]+\z""".r

  override def matches(s: String): Boolean =
    (emailRegex findFirstMatchIn s).nonEmpty
}
