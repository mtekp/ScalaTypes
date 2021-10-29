import scala.util.control.Breaks._                      
    val a1 = Array(1,2,3,5)

    val a2 = Array(1,4,5,6,8)


    var arr = Array[Int]()


    var big = a1
    var small = a2

    if(a1.size<a2.size){
      big = a2
      small = a1
    }else{
      big = a1
      small = a2
    }

    var bigIndex = 0
    var smallIndex = 0

    (0 until small.size).foreach{ i=>
      breakable{
      (bigIndex until big.size).foreach{j =>
        if(big(j) < small(i)){
         arr =  arr :+ (big(j))
          bigIndex = j+1
        }else if(big(j) == small(i)){
          arr = arr :+ (big(j))
          arr = arr :+ (small(i))
          bigIndex = j+1
          break()
        }else{
          arr = arr :+ (small(i))
          break()
        }
      }
    }
    }

    (bigIndex until big.size).foreach{ i =>
      arr = arr :+ (big(i))
    }


 println(arr.mkString(","))
