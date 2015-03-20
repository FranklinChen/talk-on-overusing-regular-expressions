require 'email_validator/regex_matcher'

describe EmailValidator::RegexMatcher do
  subject(:matcher) { EmailValidator::RegexMatcher.new }

  context "email" do
    it "matches good email" do
      expect(matcher.match('prez@whitehouse.gov')).not_to be_nil
    end

    # Note that there is no useful error message to extract!
    it "fails to match bad email with incomplete domain" do
      expect(matcher.match('prez@whitehouse.')).to be_nil
    end
  end
end
