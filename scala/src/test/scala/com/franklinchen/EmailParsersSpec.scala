package com.franklinchen

import org.specs2._
import org.specs2.specification._

import scala.util.parsing.combinator.RegexParsers

class EmailParsersSpec extends Specification
     with matcher.ParserMatchers { def is = s2"""
  The local part parser
    parses all-lowercase local part       $e1
    fails to parse local part with a plus $e2

  The email parser
    parses good email                               $e3
    fails to parse bad email with incomplete domain $e4
  """

  def e1 =
    parsers.localPart must succeedOn("prez")

  def e2 =
    parsers.localPart must failOn("+spam").
      withMsg("""string matching regex `\[a-zA-Z\]\+' expected but `\+' found""")

  def e3 =
    parsers.email must succeedOn("prez@whitehouse.gov")

  def e4 =
    parsers.email must failOn("prez@whitehouse.").
      withMsg("""string matching regex `\[\^@\\.\]' expected but end of source found""")

  override val parsers = EmailParsers
}
