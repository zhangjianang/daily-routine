package myscala


object Sc02{
  implicit def object2SpecialPerson (obj: Object): SpecialPerson = {
    if (obj.getClass == classOf[Student]) {
      val stu = obj.asInstanceOf[Student];
      new SpecialPerson(stu.name)
    } else if (obj.getClass == classOf[Older]) {
      val older = obj.asInstanceOf[Older];
      new SpecialPerson(older.name)
    } else
      Nil
  }

  def main(args: Array[String]): Unit = {
    println("hello world")
    var s1 = new Student("ang")
    println(s1.name)

    var ticketNumber = 0
    def buySpecialTicket(p: SpecialPerson) = {
      ticketNumber += 1
      "T-" + ticketNumber
    }
    buySpecialTicket(s1);
    println(ticketNumber)
  }


  var ticketNumber = 0
  def buySpecialTicket(p: SpecialPerson) = {
    ticketNumber += 1
    "T-" + ticketNumber
  }
}

class Student( var name:String)
class Older(var name:String)
class SpecialPerson(var name:String)

