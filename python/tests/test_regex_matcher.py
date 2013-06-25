from email_validator import regex_matcher

def test_good_email():
    assert regex_matcher.match('prez@whitehouse.gov') is not None

def test_incomplete_domain():
    assert regex_matcher.match('prez@whitehouse.') is None
