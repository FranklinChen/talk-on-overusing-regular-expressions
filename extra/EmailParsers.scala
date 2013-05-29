object EmailParsers extends RegexParsers {
  override def skipWhitespace = false

  def localPart: Parser[String] = """[a-zA-Z]+""".r
  def at = "@"
  def domainChar = """[^@\.]""".r
  def subDomain = rep1(domainChar)
  def dot = "."
  def domain = rep1(subDomain ~ dot) ~ subDomain
  def email = localPart ~ at ~ domain
}
