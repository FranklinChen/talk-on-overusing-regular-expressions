# http://docs.python.org/2/library/re.html
import re

# Python does not have string interpolation

LOCAL_PART = r'[a-zA-Z]+'
DOMAIN_CHAR = r'[^@\.]'
SUB_DOMAIN = r'{}+'.format(DOMAIN_CHAR)
AT = r'@'
DOT = r'\.'
DOMAIN = r'( {0} {1} )+ {0}'.format(SUB_DOMAIN, DOT)
EMAIL = r'\A {} {} {} \Z'.format(LOCAL_PART, AT, DOMAIN)

EMAIL_REGEX = re.compile(EMAIL, re.X)

def match(s):
    return EMAIL_REGEX.match(s)
