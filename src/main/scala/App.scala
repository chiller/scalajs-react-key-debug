import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.html_<^._
import org.scalajs.dom.html

object App {

  private val canvasRef = Ref[html.Canvas]

  val ToolbarComponent = ScalaComponent
  .builder[Unit]("ToolbarComponent")
  .render_P { _ => <.div("toolbar") }
  .build

  val CanvasWrapperComponent = ScalaComponent
  .builder[Unit]("CanvasWrapperComponent")
  .render_P { _ => 
    <.div( 
      ToolbarComponent(),
      <.canvas().withRef(canvasRef)
    )

  }
  .build

  val MainPage = <.div(CanvasWrapperComponent())

  def main(args: Array[String]): Unit = {
    import org.scalajs.dom.document
    MainPage().renderIntoDOM(document.getElementById("container"))
  }
}
