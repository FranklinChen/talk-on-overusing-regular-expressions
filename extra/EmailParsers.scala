import scala.util.parsing.combinator.RegexParsers

object EmailParsers extends RegexParsers {
  override def skipWhitespace = false

  def localPart: Parser[String] = """[a-zA-Z]+""".r
  def domainChar = """[^@\.]""".r
  def at = "@"
  def dot = "."
  def subDomain = rep1(domainChar)
  def domain = rep1(subDomain ~ dot) ~ subDomain
  def email = localPart ~ at ~ domain
}
