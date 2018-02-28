import java.util.Map;

public class Screen extends Resource {

  private int id;

  private int capacity;

  public Screen(int id) throws Exception {
    /**String json = this.client.get("screen/"+id);
    Map<String, Object> p = this.getMap(json);

    this.id = (int)p.get("screen_id");
    this.capacity = (int)p.get("screen_capacity");
    */
    
  }


  public int getId(){
    return id;
  }

  public int getCapacity(){
    return capacity;
  }

  public void setCapacity(int capacity){

  }
}
