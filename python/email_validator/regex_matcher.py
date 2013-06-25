# http://docs.python.org/2/library/re.html
import re

def match(s):
    return re.match(r'\A[a-zA-Z]+@([^@\.]+\.)+[^@\.]+\Z', s)
