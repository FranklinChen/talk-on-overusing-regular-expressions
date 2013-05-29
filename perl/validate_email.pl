#!/usr/bin/env perl

use warnings;
use strict;

use Mail::RFC822::Address qw(valid);

my $address = $ARGV[0];

if (valid $address) {
    print "Successfully regex-matched $address\n";
}
else {
    print "Regex match failed, but we have no idea where!\n";
}
