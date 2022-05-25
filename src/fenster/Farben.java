package fenster;

import java.awt.Color;
import java.util.Map;
import java.util.HashMap;

public class Farben {
    private Map<Color, Character> encode = new HashMap<>();
    private Map<Character, Color> decode = new HashMap<>();

    public Farben() {
        setColorEncode();
        setColorDecode();
    }

    public char getCode(Color c) {
        return encode.get(c);
    }

    public Color getColor(char c) {
        return decode.get(c);
    }

    public void setColorEncode() {
        encode.put(Color.RED, 'R');
        encode.put(Color.GREEN, 'G');
        encode.put(Color.BLUE, 'B');
        encode.put(Color.YELLOW, 'Y');
        encode.put(Color.WHITE, 'W');
        encode.put(Color.BLACK, 'S');
    }

    public void setColorDecode() {
        decode.put('R', Color.RED);
        decode.put('G', Color.GREEN);
        decode.put('B', Color.BLUE);
        decode.put('Y', Color.YELLOW);
        decode.put('W', Color.WHITE);
        decode.put('S', Color.BLACK);
    }
}
