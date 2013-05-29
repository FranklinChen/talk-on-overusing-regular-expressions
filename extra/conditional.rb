EXPRESSION = /(.+?)\s+(unless|if)\s+(.+)/i
TERNARY = /(.*?)\(\s*(.+?)\s+\?\s+(.+?)\s+:\s+(.+?)\s*\)(.+?)?/

def strip_expression(markup, context = false)
  if markup =~ TERNARY
    result = evaluate_ternary($2, $3, $4, context)
    markup = "#{$1} #{result} #{$5}"
  end
  markup =~ EXPRESSION ? $1 : markup
end
