package com.franklinchen

object ValidateEmail {
  def main(args: Array[String]) {
    val address = args(0)

    // Example of ugly code.
    if (("""\A[a-zA-Z]+@([^@\.]+\.)+[^@\.]+\z""".r
        findFirstMatchIn address).nonEmpty)
      println(s"Successfully regex-matched $address")
    else
      println("Regex match failed, but we have no idea where!")

    runParser(address)
  }

  def runParser(address: String) {
    import EmailParsers._

    // parseAll is method inherited from RegexParsers
    parseAll(email, address) match {
      case Success(_, _) =>
        println(s"Successfully parsed $address")
      case failure: NoSuccess =>
        println("Parse failed, and here's why:")
        println(failure)
    }
  }
}
