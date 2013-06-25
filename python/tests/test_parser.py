import pytest

import pyparsing
from email_validator import parser

def test_good_email():
    assert parser.parse('prez@whitehouse.gov') is not None

def test_incomplete_domain():
    with pytest.raises(pyparsing.ParseException) as info:
        parser.parse('prez@whitehouse.')

        assert info.value.msg == "Expected Re:('[^@\\.]') (at char 16), (line:1, col:17)"
