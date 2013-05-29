package com.franklinchen

object ValidateEmail {
  def main(args: Array[String]) {
    // Example of ugly code.
    val address = args(0)
    if (("""\A[a-zA-Z]+@([^@\.]+\.)+[^@\.]+\z""".r
        findFirstMatchIn address).nonEmpty)
      println(s"Successfully regex-matched $address")
    else
      println("Regex match failed, but we have no idea where!")

    import EmailParsers._
    parseAll(email, address) match {
      case Success(_, _) =>
        println(s"Successfully parsed $address")
      case failure: NoSuccess =>
        println("Parse failed, and here's why:")
        println(failure)
    }
  }
}
