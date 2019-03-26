/**
  * Created by adimn on 2019/3/25.
  */
package myscala.datastructure

object TestList {
  def main(args: Array[String]) {
    //    showZip()
//    highFunc("ang", (x, y) => x + "_very_good" + ",age is:" + y)
//    val par1 = curryFunc("curang")
//    par1(10)
    val res = removeSubLIst(Array(1,2,3,5))
    println(res)
  }

  def highFunc(name: String, func: (String, Int) => String) = {
    println(func(name, 10))
  }

  def curryFunc(name: String) = {
    println("curname is :" + name)
    val func = (age: Int) => println("age is :" + age)
    func
  }

  def showZip(): Unit = {
    val name = List("ang", "feng", "lei")
    val age = List(10, 20, 30)
    val tt = name.zip(age)
    val sth = tt.zip(age)
    for ((n, a) <- sth) {
      printf("name is %s, age is %d", n, a)
      println()
    }
  }


  def removeSubLIst(str:Array[Any])={
    if(str == Nil){
       Nil;
    }
    var start = -1;
    var end = -1;
    for(i <- 0 until str.length){
      if(str(i).toString.toInt < 0){
        if( start < 0){
          start = i
        }
      }else if (str(i).toString.toInt > 0 && start>=0 && end<0){
        end = i;
      }
    }
    val left = str.dropRight(start)
    val right = str.drop(end);
    val res = (left++right).mkString(",")
    res
  }
}

class ConstructureTry(name:String,var age:Int=10){

}
