public class Milestone2 {
	
	public static void main(String[] args){
	}
	
	//Returns the number of red pixels in a picture
	// (1) from MS1
	public static int countRedPixels(Picture v){
		int x = v.getWidth(); //get width
		int y = v.getHeight(); //get height
		
		int count = 0; // intialize count for no. of red pixels
		for(int i = 0; i < x;i++){
			for(int j = 0; j < y; j++){
				Pixel img = new Pixel(v, i, j);
				if(img.getRed() == 255 && img.getBlue() == 0 && img.getGreen() == 0) {
					//check if pixel is pure red
					count++;
				}
			}
		}
		
		return count;
	}
	 
	
	
	//Switches all red and blue pixels (pure red, pure blue)
	// (2) from MS1
	public static void switchRedBlue(Picture v){
		int x = v.getWidth(); //get width
		int y = v.getHeight(); //get height
		
		for(int i = 0; i < x;i++){
			for(int j = 0; j < y; j++){
				Pixel img = new Pixel(v, i, j);
				int blue = img.getBlue(); //get value of blue
				int red = img.getRed(); // get value of red
				int green = img.getGreen(); //get value of green
				if(blue == 255  && green == 0 && red == 0){
					img.setRed(255);//change pure blue to pure red
					img.setBlue(0);
					img.setGreen(0);
				}
				if(red == 255 && blue == 0 && green == 0){
					img.setRed(0); //change pure red to pure blue
					img.setBlue(255);
					img.setGreen(0);
				}
			}
		}
	}
	 
	 
	//Flips over imaginary vertical line (3) from MS1
	// IF pixels exist ON the midline, leave them there without reflecting
	public static void flipHorizontal(Picture v){
		int x = v.getWidth(); //get width
		int y = v.getHeight(); //get height
	
		for(int i = 0; i < x/2; i++){
			for(int j = 0; j < y; j++){
				int rgb = v.getBasicPixel(i, j);
				v.setBasicPixel(x - i - 1, j, rgb);
			}
		}
	}
	 
	 
	
	
	//Flips over imaginary horizontal line (4) from MS1
	// IF pixels exist ON the midline, leave them there without reflecting
	public static void flipVertical(Picture v){
		int xLength = v.getWidth();	//get width
		int yLength = v.getHeight(); //get height
		
		for(int i = 0; i < xLength; i++){
			for(int j = 0; j < yLength/2; j++){
				int rgb = v.getBasicPixel(i, j);
				v.setBasicPixel(i, yLength - j - 1, rgb);
			}
		}
	}
	 
	 
	//Flips over imaginary diagonal line (5) from MS1
	// upper right to lower left diagonal line
	// you may assume SQUARE images (height == width)
	// IF pixels exist ON the midline, leave them there without reflecting
	public static void flipDiagonal(Picture v){
		int x = v.getWidth(); //get width
		int y = v.getHeight(); //get height
		int[][] rgb = new int[x][y];
		
		for(int k = 0; k < x; k++){
			for(int l = 0; l < y; l++){
				rgb[k][l] = v.getBasicPixel(k, l);//create array of rgb ints
			}
		}
		
		if(x == y){
			for(int i = 0; i < x; i++){
				for(int j = 0; j < i; j++){
					v.setBasicPixel(i, y - j - 1, rgb[j][x- i -1]);
				}
			}
		}
	}
}