class EmailValidator::PrettyRegexMatcher
  LOCAL_PART = /[a-zA-Z]+/x
  AT = /@/x
  DOMAIN_CHAR = /[^@\.]/x
  SUB_DOMAIN = /#{DOMAIN_CHAR}+/x
  DOT = /\./x
  DOMAIN = /(#{SUB_DOMAIN}#{DOT})+ #{SUB_DOMAIN}/x
  EMAIL = /
      \A
      #{LOCAL_PART}
      #{AT}
      #{DOMAIN}
      \z
    /x

  def match(s)
    s =~ EMAIL
  end
end
