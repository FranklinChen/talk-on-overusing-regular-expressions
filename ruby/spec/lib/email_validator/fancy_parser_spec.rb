require 'email_validator/fancy_parser'
require 'parslet/rig/rspec'

describe EmailValidator::FancyParser do
  subject(:parser) { EmailValidator::FancyParser.new }

  context "email" do
    it "parses good email" do
      expect(parser.email).to parse('prez@whitehouse.gov')
    end

    it "fails to parse bad email with incomplete domain" do
      expect { parser.email.parse('prez@whitehouse.') }.
        to raise_error(Parslet::ParseFailed) { |error|
        expect(error.cause.ascii_tree).to \
        match(/Expected one of \[DOMAIN_REF, DOMAIN_LITERAL\] at line 1 char 17/)
      }
    end
  end
end
