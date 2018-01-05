public class MyPicture{
	
	String filename;
	String description;
	Picture p;
	
	public MyPicture(String filename, String description) {
		this.filename = filename;
		this.description = description;
		this.p = new Picture(filename);
	}

	public String toString(){
		String retStr = p.getFileName() + " " + p.getWidth() + " x " + p.getHeight() + " " + this.description;
		return retStr;
	}

	public boolean equals(MyPicture v) {
		if(v.filename == this.filename && v.description == this.description){
			return true;
		} else {
			return false;
		}
	}

	public Picture negative(){
		int x = p.getWidth();
		int y = p.getHeight();
		
		Picture v = new Picture(x, y);
		
		for(int i = 0; i < x ; i++) {
			for(int j = 0; j < y; j++){
				Pixel img = new Pixel(p, i , j);
				Pixel newImg = new Pixel(v, i, j);
				newImg.setRed(255 - img.getRed());
				newImg.setBlue(255 - img.getBlue());
				newImg.setGreen(255 - img.getGreen());
			}
		}
		
		return v;
	}

	public double redness() {
		int x = p.getWidth();
		int y = p.getHeight();
		double redness;
		int count = 0;
		
		
		for(int i = 0; i < x; i++){
			for(int j = 0; j < y; j++){
				Pixel img = new Pixel(p, i, j);
				if(img.getRed() > img.getBlue() && img.getRed() > img.getGreen())
					count++; 
			}
		}
		
		redness = (double) count/(x  * y);
		
		return redness;	
	}

	public void flipHorizontal() {
		int x = p.getWidth();
		int y = p.getHeight();
	
		for(int i = 0; i < x/2; i++){
			for(int j = 0; j < y; j++){
				int rgb = p.getBasicPixel(i, j);
				p.setBasicPixel(x - i - 1, j, rgb);
			}
		}
	}

	public void flipVertical(){
		int xLength = p.getWidth();
		int yLength = p.getHeight();
		
		for(int i = 0; i < xLength; i++){
			for(int j = 0; j < yLength/2; j++){
				int rgb = p.getBasicPixel(i, j);
				p.setBasicPixel(i, yLength - j - 1, rgb);
			}
		}
	}
}