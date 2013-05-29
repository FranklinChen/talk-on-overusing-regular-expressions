package com.franklinchen

sealed trait ToyJSON

case class JObject(map: Map[String, ToyJSON]) extends ToyJSON

case class JArray(list: List[ToyJSON]) extends ToyJSON

case class JString(string: String) extends ToyJSON

case class JFloat(float: Float) extends ToyJSON

case object JNull extends ToyJSON

case class JBoolean(boolean: Boolean) extends ToyJSON
