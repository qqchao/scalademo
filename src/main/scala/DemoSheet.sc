object DemoSheet{

  var x = println(1)

  val name ="qqchao"

  s"hello ${name}"

  hello("a")

  def hello(name : String) = {
    s"hello ${name}"
  }

  hello2("qqchao")

  def hello2(name : String) =
  s"hello ${name}"

  if(true) 1 else 2
  if(false) 2 else 4
  if(false) 2

  val l = List("Alice","Bob","Cathy")

  for (
    s <- l
  )println(s)

  for (
    s <- l
    if(s.length>3)
  )println(s)

  var s1 = "12"

  for {
    s <- l
    s1 = s.toUpperCase()
    if(s1 != "")
  }yield(s1)

  for(s <- l) {

    println(s)
  }

  val f:Float = 8.5f

  val d:Float = 85l

  try {
    Integer.parseInt("asdf")
  }catch {
    case _ => 0
  }finally {
    println("always")
  }

  var a = 1

  val result_match = a match {
    case 1 => "一"
    case 2 => "二"
    case _ => "好多"
  }

  def callByValue(x:Int,y:Int) = x*x
  def callByName(x: => Int,y: => Int) = x*x

  callByValue(3+4,8)
  callByName(3+4,8)

  def bar(x:Int, y: => Int) = 1
/*
  def loop():Int = loop

  bar(1,loop)
  bar(loop, 1)*/

  def add(x:Int,y:Int) = x+y
  def decode(x:Int,y:Int) = x-y

  def addOperate(x:Int,f: (Int, Int) => Int) = {
    x-f(3,4)
  }

  add(3, 2)
  decode(3, 2)

  addOperate(7, add)
  addOperate(7, decode)

  def hello() = (name:String) => {"hello " + name}

  def printUpperCase(s:String) : String = {
    s.toUpperCase
  }

  def listToUpper(f : String => String) = {
    for(s <- l)println(f(s))
  }

  listToUpper(printUpperCase)

}
