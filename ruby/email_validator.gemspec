# coding: utf-8
lib = File.expand_path('../lib', __FILE__)
$LOAD_PATH.unshift(lib) unless $LOAD_PATH.include?(lib)
require 'email_validator/version'

Gem::Specification.new do |spec|
  spec.name          = "email_validator"
  spec.version       = EmailValidator::VERSION
  spec.authors       = ["Franklin Chen"]
  spec.email         = ["franklinchen@franklinchen.com"]
  spec.description   = %q{Illustrate use of parslet for parsing}
  spec.summary       = %q{Illustrate use of parslet for parsing}
  spec.homepage      = ""
  spec.license       = "MIT"

  spec.files         = `git ls-files`.split($/)
  spec.executables   = spec.files.grep(%r{^bin/}) { |f| File.basename(f) }
  spec.test_files    = spec.files.grep(%r{^(test|spec|features)/})
  spec.require_paths = ["lib"]

  spec.add_development_dependency "bundler", "~> 1.3"
  spec.add_development_dependency "rspec"
  spec.add_development_dependency "rake"
  spec.add_development_dependency "guard"
  spec.add_development_dependency "guard-bundler"
  spec.add_development_dependency "guard-rspec"
  spec.add_development_dependency "rb-inotify"
  spec.add_development_dependency "rb-fsevent"
  spec.add_development_dependency "rb-fchange"

  spec.add_dependency "parslet"
end
