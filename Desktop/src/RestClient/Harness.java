public class Harness {

  public static void main(String[] args) throws Exception {
      RestClient client = new RestClient("localhost", 5000);
      Screen s = client.getScreen(1);
      System.out.println(s);
  }
}
