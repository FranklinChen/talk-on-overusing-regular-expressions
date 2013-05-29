$regex = qr/
  \(                 # (1) match an open paren (
    (                # followed by
      [^()]+         #   (3) one or more non-paren character
    |                # OR
      (??{$regex})   #   (5) the regex itself
    )*               # (6) repeated zero or more times
  \)                 # (7) followed by a close paren )
/x;
