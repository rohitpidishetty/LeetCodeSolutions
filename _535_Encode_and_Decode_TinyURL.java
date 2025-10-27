import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Codec {
  private Map<String, String> registry;

  public Codec() {
    this.registry = new HashMap<>();
  }

  // Encodes a URL to a shortened URL.
  public String encode(String longUrl) {
    int i = 0;
    String RESERVED_SYMBOLS = ":/?#[]@!$&'()*+,;=.- ";
    int n = longUrl.length();
    int j = 0;
    StringBuilder encoded_url = new StringBuilder();
    String token = new String();
    for (; i < n; i++) {
      String ch = String.valueOf(longUrl.charAt(i));
      if (RESERVED_SYMBOLS.contains(ch)) {
        token = longUrl.substring(j, i);
        encoded_url.append(hash(token, i - j));
        encoded_url.append(ch);
        j = i + 1;
      }
    }
    encoded_url.append(hash(longUrl.substring(j, i), i - j));
    return encoded_url.toString();
  }

  private String hash(String token, int length) {

    int structured_encodings = length;
    for (char ch : token.toCharArray())
      structured_encodings += (int) ch;
    structured_encodings /= 2;
    String hash = String.valueOf(structured_encodings);
    if (!this.registry.containsKey(hash))
      this.registry.put(hash, token);
    else {
      while (this.registry.containsKey(String.valueOf(structured_encodings)))
        structured_encodings++;
      String exponential_hash = String.valueOf(structured_encodings);
      this.registry.put(exponential_hash, token);
      return exponential_hash;
    }
    return hash;
  }

  // Decodes a shortened URL to its original URL.
  public String decode(String shortUrl) {

    int i = 0;
    String RESERVED_SYMBOLS = ":/?#[]@!$&'()*+,;=.- ";
    int n = shortUrl.length();
    int j = 0;
    StringBuilder decoded_url = new StringBuilder();
    String token = new String();
    for (; i < n; i++) {
      String ch = String.valueOf(shortUrl.charAt(i));
      if (RESERVED_SYMBOLS.contains(ch)) {
        token = shortUrl.substring(j, i);
        if (i - j > 1)
          decoded_url.append(this.registry.get(token));
        decoded_url.append(ch);
        j = i + 1;
      }
    }

    token = shortUrl.substring(j, i);
    decoded_url.append(this.registry.get(token));

    return decoded_url.toString();
  }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(url));

public class _535_Encode_and_Decode_TinyURL {
  public static void main(String[] args) {
    Codec obj = new Codec();
    String url = obj
        .decode(obj.encode("http://3.141592653589793238462643383279502884197169399375105820974944592.com"));
    System.out.println(url);

  }
}
