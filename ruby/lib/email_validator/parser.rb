require 'parslet'

class EmailValidator::Parser < Parslet::Parser
  rule(:local_part) { match['a-zA-Z'].repeat(1) }
  rule(:domain_char) { match['^@\\.'] }
  rule(:at)         { str('@') }
  rule(:dot)    { str('.') }
  rule(:sub_domain) { domain_char.repeat(1) }
  rule(:domain) { (sub_domain >> dot).repeat(1) >>
                  sub_domain }
  rule(:email)  { local_part >> at >> domain }
end
