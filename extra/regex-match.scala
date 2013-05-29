if (("""\A[a-zA-Z]+@([^@\.]+\.)+[^@\.]+\z""".r
    findFirstMatchIn address).nonEmpty)
  println(s"Successfully regex-matched $address")
else
  println("Regex match failed, but we have no idea where!")
