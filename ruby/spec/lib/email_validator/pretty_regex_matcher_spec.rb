require 'email_validator/pretty_regex_matcher'

describe EmailValidator::PrettyRegexMatcher do
  subject(:matcher) { EmailValidator::PrettyRegexMatcher.new }

  context "email" do
    it "matches good email" do
      expect(matcher.match('prez@whitehouse.gov')).to be_true
    end

    # Note that there is no useful error message to extract!
    it "fails to match bad email with incomplete domain" do
      expect(matcher.match('prez@whitehouse.')).to be_false
    end
  end
end
