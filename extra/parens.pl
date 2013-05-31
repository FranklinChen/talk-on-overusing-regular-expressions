$regex = qr/
  \(               # match an open paren (
    (              #   followed by
      [^()]+       #     1+ non-paren characters
    |              #   OR
      (??{$regex}) #     the regex itself
    )*             #   repeated 0+ times
  \)               # followed by a close paren )
/x;
