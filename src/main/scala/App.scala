import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.html_<^._
import org.scalajs.dom.html

/**
 * The equivalent react version doesn't show key errors:
 *
 * function Toolbar() {
 *   return (
 *     <div>TOOLBAR</div>
 *   )
 * }
 *
 * function CanvasWrapper() {
 *   const ref = React.createRef()
 *
 *   return (
 *     <div>
 *       <Toolbar />
 *       <canvas ref={ref} />
 *     </div>
 *   )
 * }
 *
 * function App() {
 *   return (
 *     <div>
 *       <CanvasWrapper />
 *     </div>
 *   );
 * }
 *
 * ReactDOM.render(<App />, document.getElementById('root'))
 *
 */
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

  val App = ScalaComponent
  .builder[Unit]("App")
  .render_P { _ => <.div(CanvasWrapperComponent()) }
  .build

  def main(args: Array[String]): Unit = {
    import org.scalajs.dom.document
    App().renderIntoDOM(document.getElementById("container"))
  }
}
