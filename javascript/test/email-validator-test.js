var validator = require('../lib/email-validator')

var expect = require('chai').expect;

describe("validator", function() {
    describe("ugly", function() {
        it("matches simple email address", function() {
            expect(validator.ugly_match('FranklinChen@cmu.edu')).to.be.ok;
        });
        
        it("does not match email address with +", function() {
            expect(validator.ugly_match('FranklinChen+spam@cmu.edu')).to.not.be.ok;
        });
    });

    describe("pretty", function() {
        it("matches simple email address", function() {
            expect(validator.pretty_match('FranklinChen@cmu.edu')).to.be.ok;
        });
        
        it("does not match email address with +", function() {
            expect(validator.pretty_match('FranklinChen+spam@cmu.edu')).to.not.be.ok;
        });
    });

    describe("parse", function() {
        it("parses simple email address", function() {
            expect(validator.parse('FranklinChen@cmu.edu')).to.be.ok;
        });
        
        it("does not parse email address with +", function() {
            expect(function () {
                return validator.parse('FranklinChen+spam@cmu.edu');
            }).to.throw(validator.EmailParseError,
                        /Parse Error: expected '@' at character 12, got '\.\.\.\+spam@cmu.ed\.\.\./);
        });
    });
});
