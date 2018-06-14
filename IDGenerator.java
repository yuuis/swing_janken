package swing;

class IDGenerator {
  static int id = 0;
  public static int getId() {
    return id++;
  }
}