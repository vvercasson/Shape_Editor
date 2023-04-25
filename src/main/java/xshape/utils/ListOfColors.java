package xshape.utils;

import java.util.HashMap;
import java.util.Map;

public class ListOfColors {

    private Map<MyColor, String> colors = new HashMap<>();

    public ListOfColors(){
        colors.put(MyColor.GREEN, "Green");
        colors.put(MyColor.BLUE, "Blue");
        colors.put(MyColor.BLACK, "Black");
        colors.put(MyColor.WHITE, "White");
        colors.put(MyColor.YELLOW, "Yellow");
        colors.put(MyColor.CYAN, "Cyan");
        colors.put(MyColor.MAGENTA, "Magenta");
        colors.put(MyColor.ORANGE, "Orange");
        colors.put(MyColor.PINK, "Pink");
        colors.put(MyColor.GRAY, "Gray");
        colors.put(MyColor.LIGHT_GRAY, "Light Gray");
        colors.put(MyColor.DARK_GRAY, "Dark Gray");
        colors.put(MyColor.LIGHT_BLUE, "Light Blue");
        colors.put(MyColor.LIGHT_GREEN, "Light Green");
        colors.put(MyColor.LIGHT_RED, "Light Red");
        colors.put(MyColor.LIGHT_YELLOW, "Light Yellow");
        colors.put(MyColor.LIGHT_ORANGE, "Light Orange");
        colors.put(MyColor.LIGHT_PINK, "Light Pink");
        colors.put(MyColor.LIGHT_MAGENTA, "Light Magenta");
        colors.put(MyColor.LIGHT_CYAN, "Light Cyan");
        colors.put(MyColor.LIGHT_BROWN, "Light Brown");
        colors.put(MyColor.DARK_BLUE, "Dark Blue");
        colors.put(MyColor.DARK_GREEN, "Dark Green");
        colors.put(MyColor.DARK_RED, "Dark Red");
        colors.put(MyColor.DARK_YELLOW, "Dark Yellow");
        colors.put(MyColor.DARK_ORANGE, "Dark Orange");
        colors.put(MyColor.DARK_PINK, "Dark Pink");
        colors.put(MyColor.DARK_MAGENTA, "Dark Magenta");
        colors.put(MyColor.DARK_CYAN, "Dark Cyan");
        colors.put(MyColor.DARK_BROWN, "Dark Brown");
    }
    public Map<MyColor, String> getColors() {
        return colors;
    }
}
