import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class Week4Tests extends FunSuite {

    import doodle.core._
    import doodle.core.Image._
    import doodle.syntax._

    import Week4._

    val singleForwardPath = List(Forward(10))
    val singleTurnPath = List(Turn(90.degrees))
    val mixedPath = List(Forward(10), Turn(45.degrees), Forward(20), Turn(90.degrees), Forward(5))
}
