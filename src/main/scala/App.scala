import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.html_<^._
import org.scalajs.dom.html

object App {

  private val canvasRef = Ref[html.Canvas]

  val MainPage =
      <.div(
        <.div("=========================="),
        <.div("loop container",
          (1 to 5).map( i =>
            if (i == 3) <.canvas(
              ^.key := s"swaggy-key-$i",
              ^.title := "anyone there?"
            ).withRef(canvasRef)
            else <.canvas( ^.key := s"swaggy-$i" )
          ).toVdomArray
        )
      )


  def main(args: Array[String]): Unit = {
    import org.scalajs.dom.document
    MainPage().renderIntoDOM(document.getElementById("container"))
  }
}