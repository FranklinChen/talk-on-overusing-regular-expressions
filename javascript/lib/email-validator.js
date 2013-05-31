/*
  JavaScript limitations:
  - RegExp does not support x
  - no string interpolation
  - no raw strings
*/

// Use regex

var UGLY_EMAIL = /^[a-zA-Z]+@([^@\.]+\.)+[^@\.]+$/;

exports.ugly_match = function(s) {
    return UGLY_EMAIL.exec(s)
}

var LOCAL_PART = '[a-zA-Z]+';
var DOMAIN_CHAR = '[^@\\.]';
var SUB_DOMAIN = DOMAIN_CHAR + '+';
var AT = '@';
var DOT = '\\.';
var DOMAIN = '(' + SUB_DOMAIN + DOT + ')+' + SUB_DOMAIN;
var EMAIL = new RegExp('^' + LOCAL_PART + AT + DOMAIN + '$');

exports.pretty_match = function(s) {
    return EMAIL.exec(s)
}

// Use parser

var Parsimmon = require('parsimmon');

var regex = Parsimmon.regex;
var string = Parsimmon.string;

// https://github.com/jayferd/parsimmon
// Due to limitations in javascript's regex API, regex must be anchored
var local_part = regex(/^[a-zA-Z]/).atLeast(1);
var domain_char = regex(/^[^@\.]/);
var at = string('@');
var dot = string('.');
var sub_domain = domain_char.atLeast(1);
var domain = sub_domain.then(dot).atLeast(1).then(sub_domain);
var email = local_part.then(at).then(domain);

/*
  Define own exception class. Parsimmon is faulty in design,
  in throwing a string.
*/
function EmailParseError(message) {
  this.name = 'EmailParseError';
  this.message = message;
}
EmailParseError.prototype = new Error();
EmailParseError.prototype.constructor = EmailParseError;
exports.EmailParseError = EmailParseError;

exports.parse = function(s) {
    try {
        return email.parse(s);
    }
    catch (message) {
        // Convert string exception to a typed exception.
        throw new EmailParseError(message);
    }
}
