import scala.annotation.tailrec

object DemoSheet{

  //var: 变量
  var x = println(1)
  //val: 常量
  val name ="qqchao"
  //s开头字符串
  s"hello ${name}"

  def hello(name : String) = {
    s"hello ${name}"
  }

  //一句话方法省略｛｝
  def hello2(name : String) =
    s"hello ${name}"

  hello("a")
  hello2("qqchao")

  //省略｛｝
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

  for( s<-l ){
    if(s.length>3)
      println(s)
  }

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

  val d:Double = 6.5

  try {
    Integer.parseInt("asdf")
  }catch {
    case _ => 0
  }finally {
    println("always")
  }

  var a = 1

  //类比switch--case
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

  val l1 = List("Alice","Bob","Cathy")

  def printHello(s:String) : Unit = {
    println("Hello " + s)
  }

  def printUpperCase(s:String) : Unit = {
    println("Hello " + s.toUpperCase)
  }

  def listToUpper(f : String => Unit) = {
    for(s <- l1)f(s)
  }

  listToUpper(printHello)
  listToUpper(printUpperCase)

  def curriedAdd(a: Int)(b:Int)= a + b;

  val addOne = curriedAdd(1)_

  addOne(2)

  //递归实现循环
  //示例： 计算 n!
  def factorial(n: Int) : Int =
    if(n <= 0) 1
    else n*factorial(n-1)

  factorial(10) // 10!


  //尾递归优化  优化栈
  @annotation.tailrec
  def factorial2(n:Int, m:Int) : Int =
    if(n <= 0) m
    else factorial2(n-1, m*n)

  factorial2(5,5) // 5! * 5

//  @annotation.tailrec
  def factorial3(n:Int)(m:Int):Int = {
    if(m <= 0) n
    else factorial3(m*n)(m-1)
  }

  val factoralOne = factorial3(1)_

  factoralOne(10)

  //计算从a~b的f(x)方法和
  def caculateAtoB(f:Int => Int)(a:Int)(b:Int):Int={
    @tailrec
    def loop(n:Int,sum:Int): Int ={
      if(n > b){
        println(s"n = ${n} sum = ${sum}")
        sum
      }
      else{
        println(s"n = ${n} sum = ${sum}")
        loop(n+1, sum + f(n))
      }
    }

    loop(a,0)
  }

  caculateAtoB(x => x*x*x)(1)(5)

  val la = List(1,2,3,4)

  val lb = 0::la

  val lc = "a"::"b"::"c"::Nil

  val ld = la ::: lc

  la.head
  la.tail
  lc.head
  lc.tail

  la.isEmpty
  Nil.isEmpty

  def walkthru(l:List[Int]):String ={
    if(l.isEmpty) ""
    else l.head + " " + walkthru(l.tail)
  }
  def walkthru2(l:List[Int]):String ={
    var s = ""
    for(i <- l) {
      s += i+" "
    }
    return s
  }

  walkthru(la)
  walkthru2(la)

  la.filter(x=>x>2)

  var ls = "hialnc23dJ sadf325".toList

  ls.filter(x => Character.isDigit(x))
  ls.takeWhile(x => x != ' ')

  lc.map(x => x.toUpperCase)

  lc.map(_.toUpperCase)
  la.filter(_ % 2 == 1).map(_+10)

  val lq = List(la,List(4,5,6,7))

  lq.map(_.filter(_%2==1))
  //将两层list转换为一层
  lq.flatMap(_.filter(_%2==0))

  la.reduceLeft((x,y)=>x+y)
  la.reduceLeft(_+_)
  la.reduce(_+_)

  la.foldLeft(0)(_+_)
  la.foldLeft("0")(_+_)

  1 to 10
  1 to 10 by 2

}
