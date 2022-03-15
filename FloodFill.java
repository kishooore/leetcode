
public class FloodFill {
    public static void main(String[] args) {
        int[][] image = {{0,0,0}, {0,1,1}};
        FloodFill fill = new FloodFill();
        image = fill.floodFill(image, 1, 1, 1);
        System.out.print("Com");
    }

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int curr = image[sr][sc];
        image[sr][sc] = newColor;
        if (sr > 0 && image[sr-1][sc] == curr && curr != newColor) {
            floodFill(image, sr-1, sc, newColor);
        }
        if (sr+1 < image.length && image[sr+1][sc] == curr && curr != newColor) {
            floodFill(image, sr+1, sc, newColor);
        }
        if (sc > 0 && image[sr][sc-1] == curr && curr != newColor) {
            floodFill(image, sr, sc-1, newColor);
        }
        if (sc+1 < image[0].length && image[sr][sc+1] == curr && curr != newColor) {
            floodFill(image, sr, sc+1, newColor);
        }
        return image;
    }
}
