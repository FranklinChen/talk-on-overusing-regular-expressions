require 'email_validator/parser'
require 'parslet/rig/rspec'

describe EmailValidator::Parser do
  subject(:parser) { EmailValidator::Parser.new }

  context "local_part" do
    it "parses all-lowercase local part" do
      expect(parser.local_part).to parse('prez')
    end

    it "fails to parse local part with a plus" do
      expect { parser.local_part.parse('+spam') }.to \
      raise_error(Parslet::ParseFailed) { |error|
        expect(error.cause.ascii_tree).to \
        match(/Expected at least 1 of \[a-zA-Z\] at line 1 char 1/)
      }
    end
  end

  context "email" do
    it "parses good email" do
      expect(parser.email).to parse('prez@whitehouse.gov')
    end

    it "fails to parse bad email with incomplete domain" do
      expect { parser.email.parse('prez@whitehouse.') }.
        to raise_error(Parslet::ParseFailed) { |error|
        expect(error.cause.ascii_tree).to \
        match(/Expected at least 1 of DOMAIN_CHAR at line 1 char 17/)
      }
    end
  end
end
