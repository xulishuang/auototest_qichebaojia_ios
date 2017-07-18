
public class Debug {
	public static void debug(){
		String s = System.getProperty("user.dir")+"/image";
		System.out.println(s);
	}
	
	public static void main(String[] args){
		Debug.debug();
	}

}
