from pyparsing import *

ParserElement.setDefaultWhitespaceChars('')

local_part = OneOrMore(Regex(r'[a-zA-Z]'))
domain_char = Regex(r'[^@\.]')
at = Literal('@')
dot = Literal('.')
sub_domain = OneOrMore(domain_char)
domain = OneOrMore(sub_domain + dot) + sub_domain
email = local_part + at + domain

def parse(s):
    return email.parseString(s)
