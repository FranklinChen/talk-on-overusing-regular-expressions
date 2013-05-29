require 'parslet'

# A fancy email address parser, based on
# http://davidcel.is/blog/2012/09/06/stop-validating-email-addresses-with-regex/
class EmailValidator::FancyParser < Parslet::Parser
  rule(:qtext) { match['^\\x0d\\x22\\x5c\\x80-\\xff'] }
  rule(:dtext) { match['^\\x0d\\x5b-\\x5d\\x80-\\xff'] }
# Parslet currently unhappy with the \x7f-xff
#  rule(:atom) { match['^\\x00-\\x20\\x22\\x28\\x29\\x2c\\x2e\\x3a-\\x3c\\x3e\\x40\\x5b-\\x5d\\x7f-\\xff'].repeat(1) }
  rule(:atom) { match['^\\x00-\\x20\\x22\\x28\\x29\\x2c\\x2e\\x3a-\\x3c\\x3e\\x40\\x5b-\\x5d'].repeat(1) }
  rule(:quoted_pair) { str('\\') >> match['\\x00-\\x7f'] }
  rule(:domain_literal) { str('[') >>
    (dtext | quoted_pair).repeat >>
    str(']') }
  rule(:double_quote) { str('"') }
  rule(:quoted_string) { double_quote >>
    (qtext | quoted_pair).repeat >>
    double_quote }
  rule(:at) { str('@') }
  rule(:domain_ref) { atom }
  rule(:sub_domain) { domain_ref | domain_literal }
  rule(:word) { atom | quoted_string }
  rule(:dot) { str('.') }
  rule(:domain) { sub_domain >> (dot >> sub_domain).repeat }
  rule(:local_part) { word >> (dot >> word).repeat }
  rule(:email) { local_part >> at >> domain }
end
