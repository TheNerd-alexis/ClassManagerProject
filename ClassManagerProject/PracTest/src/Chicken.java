
public class Chicken extends Cook implements HowtoCook{
	public void Love(){
		System.out.println("치킨은 사랑입니다 ");
	}

	@Override
	public void cost() {
		// TODO Auto-generated method stub
		System.out.println("치킨 원가는 8000원입니다.");
		
	}

	@Override
	public void price() {
		// TODO Auto-generated method stub
		System.out.println("치킨가격은 18000원입니다. ");
		
	}

	@Override
	public void margin() {
		// TODO Auto-generated method stub
		System.out.println("치킨마진은 10000원입니다.");
	}
}
