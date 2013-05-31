#!/usr/bin/env perl

use warnings;
use strict;

my $address = $ARGV[0];

if ($address =~ /\A        # match string begin
  ([a-zA-Z]+) # $1: local part: 1+ Roman alphabetic
  @           # @
  (           # $2: entire domain
    (?:         # 1+ of this non-capturing group
      [^@\.]+     # 1+ of not (@ or dot)
      \.          # dot
    )+
    ([^@\.]+) # $3: 1+ of not (@ or dot)
  )
   \z/x) {    # match string end
    print "local part: $1; domain: $2; top level: $3\n";
}
else {
    print "Regex match failed!\n";
}
