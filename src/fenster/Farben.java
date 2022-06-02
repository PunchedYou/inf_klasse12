package fenster;

import java.awt.Color;
import java.util.HashMap;
import java.util.Map;

public class Farben {
    private Map<Color, String> encode = new HashMap<>();
    private Map<String, Color> decode = new HashMap<>();

    public Farben(boolean schalter) {
        if (schalter) {
            setColorByteEncode();
        } else {
            setColorEncode();
        }
        
        setColorDecode();
    }

    public String getCode(Color c) {
        return encode.get(c);
    }

    public Color getColor(String c) {
        return decode.get(c);
    }

    public void setColorByteEncode(){
        encode.put(Color.RED, "100");
        encode.put(Color.GREEN, "010");
        encode.put(Color.BLUE, "001");
        encode.put(Color.YELLOW, "110");
        encode.put(Color.WHITE, "000");
        encode.put(Color.BLACK, "111");
    }

    public void setColorEncode() {
        encode.put(Color.RED, "R");
        encode.put(Color.GREEN, "G");
        encode.put(Color.BLUE, "B");
        encode.put(Color.YELLOW, "Y");
        encode.put(Color.WHITE, "W");
        encode.put(Color.BLACK, "S");
    }

    public void setColorDecode() {
        decode.put("R", Color.RED);
        decode.put("G", Color.GREEN);
        decode.put("B", Color.BLUE);
        decode.put("Y", Color.YELLOW);
        decode.put("W", Color.WHITE);
        decode.put("S", Color.BLACK);
    }
}
