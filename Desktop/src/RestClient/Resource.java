import org.codehaus.jackson.map.ObjectMapper;
import java.util.Map;
import java.util.HashMap;

public abstract class Resource {

  protected static HttpClient client;

  static {
    Resource.client = new HttpClient("localhost", 5000);
  }


  protected Object getMap(String json, Class klass){
    try {
    Object result =
        new ObjectMapper().readValue(json, class);
    return result;
  } catch (Exception e){
    System.err.println(e);
  }
  return null;
  }
}
