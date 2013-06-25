from email_validator import pretty_regex_matcher

def test_good_email():
    assert pretty_regex_matcher.match('prez@whitehouse.gov') is not None

def test_incomplete_domain():
    assert pretty_regex_matcher.match('prez@whitehouse.') is None
