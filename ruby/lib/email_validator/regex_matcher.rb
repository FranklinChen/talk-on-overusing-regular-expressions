class EmailValidator::RegexMatcher
  def match(s)
    s =~ /\A[a-zA-Z]+@([^@\.]+\.)+[^@\.]+\z/
  end
end
