/**
  * Created by adimn on 2019/3/22.
  */
class Sc21 {

}

object MyRun{
  def main(args: Array[String]) {

  }
}

class HelloActor extends Actor {
  def act() {
    while (true) {
      receive {
        case name: String => println("Hello, " + name)
      }
    }
  }
}
