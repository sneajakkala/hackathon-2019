package tutorial;

public class GoogleTesting {

	public static void main(String[] args) throws Exception {
		//String command = args[0];
		String as = Recognize.streamingMicRecognize();
		System.out.println(as);
		
	}

}
