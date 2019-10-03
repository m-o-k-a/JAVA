import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;


public class StandardOutputSandbox implements Runnable {
  static String NEW_LINE = System.getProperty("line.separator");
  private Runnable runnable;
  private OutputStream outputStream;

  StandardOutputSandbox(Runnable runnable) {
    this.runnable = runnable;
  }

  public void run(){
    outputStream = new ByteArrayOutputStream();
    PrintStream printStream = new PrintStream(outputStream);
    System.setOut(printStream);
    runnable.run();
    PrintStream originalOut = System.out;
    System.setOut(originalOut);
  }

  String getProducedOutput() {
    return outputStream.toString();
  }
}
