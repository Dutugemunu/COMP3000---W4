
/*
* The original version of this program was discussed in Week 3
* lectures. See the Week 3 lecture notes, near the end.
*
* Additions for the Week 4 practical exercises are marked with
* WEEK 4 comments.
*/

/*
import doodle.core._
import doodle.image._
import doodle.core.Image._
import doodle.image.syntax._
import doodle.image.syntax.core._
import doodle.java2d._
import doodle.reactor._
import scala.concurrent.duration._
import doodle.core.Angle._
import doodle.backend.StandardInterpreter._
import PathElement._
*/


import doodle.core._
import doodle.core.Image._
import doodle.core.Angle._
import doodle.syntax._
import doodle.jvm.Java2DFrame._
import doodle.backend.StandardInterpreter._
import PathElement._
import doodle.core.Angle


// WEEK 4:
// - add PenToggle
// - add Square
abstract class Instruction
case class Forward(distance : Double) extends Instruction
case class Turn(angle : Angle) extends Instruction
case class PenToggle() extends Instruction
case class Square(side : Double) extends Instruction

// WEEK 4:
// - add penup flag to record whether pen is up or down
case class TurtleState(at: Vec, heading: Angle)

object Turtles {

    def draw(instructions: List[Instruction]): Image = {

      def iterate(state: TurtleState, instructions: List[Instruction]): List[PathElement] = instructions match {
          case Nil =>
              Nil
          case i :: is =>
              val (newState, elements) = process(state, i)
              elements ++ iterate(newState, is)
      }

      def process(state: TurtleState, instruction: Instruction): (TurtleState, List[PathElement]) = {
          instruction match {
              case Forward(d) =>
                  val nowAt = state.at + Vec.polar(d, state.heading)
                  (state.copy(at = nowAt), List(lineTo(nowAt.toPoint)))

              case Turn(a) =>
                  val nowHeading = state.heading + a
                  (state.copy(heading = nowHeading), List())
          }
      }

      // WEEK 4:
      // - start with pen down
      openPath(iterate(TurtleState(Vec.zero, Angle.zero), instructions))
    }
}