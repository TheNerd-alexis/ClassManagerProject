
public class StarCarHighGrade extends StarCar{

	public StarCarHighGrade(String color, String tire, int displacement, String handle) {
		super(color, tire, displacement, handle);
		color = "red";
		tire = "Drift";
		displacement = 30;
		handle = "lether";
				
		
		
	}

	@Override
	public void getSpec() {
		
		System.out.println("color : " + color);
		System.out.println("tire : " + tire);
		System.out.println("disp;acement : "+ displacement);
		System.out.println("handle : " + handle);
	}
	

}
