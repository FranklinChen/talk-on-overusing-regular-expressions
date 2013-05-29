require 'parslet'

# A simplified email address parser
class EmailValidator::Parser < Parslet::Parser
  rule(:local_part) { match['a-zA-Z'].repeat(1) }
  rule(:at)         { str('@') }
  rule(:domain_char) { match['^@\\.'] }
  rule(:sub_domain) { domain_char.repeat(1) }
  rule(:dot)    { str('.') }
  rule(:domain) { (sub_domain >> dot).repeat(1) >>
                  sub_domain }
  rule(:email)  { local_part >> at >> domain }
end
