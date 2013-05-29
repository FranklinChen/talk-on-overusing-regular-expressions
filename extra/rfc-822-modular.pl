sub make_rfc822re {
#   Basic lexical tokens are specials, domain_literal, quoted_string, atom, and
#   comment.  We must allow for lwsp (or comments) after each of these.
#   This regexp will only work on addresses which have had comments stripped 
#   and replaced with lwsp.

    my $specials = '()<>@,;:\\\\".\\[\\]';
    my $controls = '\\000-\\031';

    my $dtext = "[^\\[\\]\\r\\\\]";
    my $domain_literal = "\\[(?:$dtext|\\\\.)*\\]$lwsp*";

    my $quoted_string = "\"(?:[^\\\"\\r\\\\]|\\\\.|$lwsp)*\"$lwsp*";

#   Use zero-width assertion to spot the limit of an atom.  A simple 
#   $lwsp* causes the regexp engine to hang occasionally.
    my $atom = "[^$specials $controls]+(?:$lwsp+|\\Z|(?=[\\[\"$specials]))";
    my $word = "(?:$atom|$quoted_string)";
    my $localpart = "$word(?:\\.$lwsp*$word)*";

    my $sub_domain = "(?:$atom|$domain_literal)";
    my $domain = "$sub_domain(?:\\.$lwsp*$sub_domain)*";

    my $addr_spec = "$localpart\@$lwsp*$domain";

    my $phrase = "$word*";
    my $route = "(?:\@$domain(?:,\@$lwsp*$domain)*:$lwsp*)";
    my $route_addr = "\\<$lwsp*$route?$addr_spec\\>$lwsp*";
    my $mailbox = "(?:$addr_spec|$phrase$route_addr)";

    my $group = "$phrase:$lwsp*(?:$mailbox(?:,\\s*$mailbox)*)?;\\s*";
    my $address = "(?:$mailbox|$group)";

    return "$lwsp*$address";
}
