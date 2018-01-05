
public class MyPictureTest {

	public static void main(String[] args) {
		MyPicture img = new MyPicture("/users/mohammednadeem/Documents/CODE/111Project/redblue.jpeg", "test");
		MyPicture img2 = new MyPicture("/users/mohammednadeem/Documents/CODE/111Project/greenscreen.jpeg", "test");
		System.out.println(img.toString());
		System.out.println(img.redness());
		System.out.println(img.equals(img2));
		System.out.println(img.negative().getWidth());
		
	}

}
