package classconn

import scala.beans.{BeanDescription, BeanProperty}

/**
  * Created by adimn on 2019/3/26.
  */
class Student {
  @BeanProperty var name = "ang"
//  def getName = name;
//  def setName(nn:String){ name = nn}
}

class Person(var name:String,var age:Int){
  private var hobby = "eat"
  println("whos your daddy!")
  def description = "name is "+name+", age is "+age

  class InnerPerson(var gender:String)

  def getInnerPerson(gender:String): InnerPerson ={
    name = "harry"
    println(name)
    print(description + ", gender is "+gender)
    println()
    new InnerPerson(gender)
  }

  //缺省构造函数
  def this(){
    this("Ang",10)
    Person.showInfo
    Person.num
  }
}

object Person{
  private var num:Long = 0;
  def showInfo{println( num)}
  def incNum(): Unit ={
    num +=1
  }
}

object StuConn{
  def main(args: Array[String]): Unit = {
//    var s1 = new Student
//    println(s1.getName)
//    s1.name = "potter"
//    println(s1.name)
//
//    s1.setName ( "hary")
//    println(s1.getName)
//
//    val p = new Person("Ang",10)
//    p.name = "super"
//    p.age = 100
//    println( p.description)
    val p1 = new Person("super",34)
//    p1.description

    var g1 = p1.getInnerPerson("female")
    Person.incNum()
    Person.showInfo
  }
}
