public class Codec {
    HashMap<Integer, String> map = new HashMap();
    String prefix = "http://tinyurl.com/";
    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        int hash = longUrl.hashCode();
        String tinyUrl = prefix + longUrl;
        map.put(hash, longUrl);
        return  tinyUrl;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        int key = shortUrl.replace(prefix, "").hashCode();
        return map.get(key);
        
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(url));