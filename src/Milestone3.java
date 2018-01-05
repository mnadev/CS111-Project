public class Milestone3 {
	public static void main(String[] args){
		Picture v = new Picture("/users/mohammednadeem/Documents/CODE/111Project/greenscreen.jpeg");
		Picture g = new Picture("/users/mohammednadeem/Documents/CODE/111Project/mickey.jpeg");
		greenScreen(v, g);
		v.show();
		v.write("/users/mohammednadeem/Documents/CODE/111Project/modified.jpg");
	}
	
	
	public static void greenScreen(Picture v, Picture g){
		//v refers to image being modified
		//g refers to the image being added to the green screen
		//this method uses green screen to edit background of an image
		
		int x = v.getWidth(); //width of Picture v
		int y = v.getHeight(); //height of Picture v
		
		int x2 = g.getWidth(); //width of Picture g
		int y2 = g.getHeight(); //height of Picture g

		
		for(int i = 0; i < x; i++ ) { //run green screen modification by iterating through each pixel
			for(int j = 0; j < y ; j++ ) {
				Pixel img = new Pixel(v, i, j); //get pixel at (i , j)
				int replace = g.getBasicPixel(i, j); //pixel that will replace other pixel
				
				int red = img.getRed(); //get red value at pixel
				int blue = img.getBlue(); //get blue value at pixel
				int green = img.getGreen(); //get green value at pixel
				
				if(green > 150 && red < 165 && blue < 165 && j < y2 && i < x2){ //change pixel if a certain color condition is met
					// check if j < y2 and  i < x2 to prevent being out of bounds for the image
					v.setBasicPixel(i, j, replace);
				}
				
				if(green > 200 && j < y2 && i < x2){ // change pixel if value of green is greater than 200
					// check if j < y2 and  i < x2 to prevent being out of bounds for the image
					v.setBasicPixel(i, j, replace);
				}
			}
		}
	}
}
