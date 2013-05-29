package com.franklinchen

import org.specs2._
import org.specs2.specification._

trait RegexMatcherSpec extends Specification { def is = s2"""
  ${matcher.name}
    matches good email                              $e1
    fails to match bad email with incomplete domain $e2
  """

  def e1 =
    matcher.matches("prez@whitehouse.gov") must beTrue

  def e2 =
    matcher.matches("prez@whitehouse.") must beFalse

  val matcher: RegexMatcher
}
