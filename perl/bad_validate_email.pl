#!/usr/bin/env perl

use warnings;
use strict;

my @regexes = (
qr/\A[^@]+@[^@]+\z/,
qr/\A        # match string begin
     [^@]+     # local part: 1+ chars of not @
     @         # @
     [^@]+     # domain: 1+ chars of not @
   \z/x,     # match string end
qr/\A[a-zA-Z]+@([^@\.]+\.)+[^@\.]+\z/,
qr/\A        # match string begin
     [a-zA-Z]+ # local part: 1+ Roman alphabetic
     @         # @
     (         # 1+ of this group
       [^@\.]+   # 1+ of not (@ or dot)
       \.        # dot
     )+
     [^@\.]+   # 1+ of not (@ or dot)
   \z/x,     # match string end
);

my $address = $ARGV[0];

foreach my $regex (@regexes) {
    if ($address =~ $regex) {
        print "$regex: successfully regex-matched $address\n";
    }
    else {
        print "$regex: regex match failed, but we have no idea where!\n";
    }
}
