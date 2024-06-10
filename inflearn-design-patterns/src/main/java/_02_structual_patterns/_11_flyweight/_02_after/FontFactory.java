package _02_structual_patterns._11_flyweight._02_after;

import java.util.HashMap;
import java.util.Map;

public class FontFactory {

  private Map<String, Font> cache = new HashMap<>();

  public Font createFont(String fontData) {
    if (this.cache.containsKey(fontData)) {
      return cache.get(fontData);
    }

    String fontFamily = fontData.split(":")[0];
    int fontSize = Integer.parseInt(fontData.split(":")[1]);
    cache.put(fontData, new Font(fontFamily, fontSize));
    return cache.get(fontData);
  }
}
