package ua.kharkiv.yeremenko.exCollections.part3;

public class Part3 {
	private static int random(int minNumber, int maxNumber) {
		maxNumber -= minNumber;
		return (int) (Math.random() * ++maxNumber) + minNumber;
	}

	public static void main(String[] args) {
		Parking parking = new Parking();
		int num1 = 0, num2 = 0, pP1 = 0, pP2 = 0;
		boolean check = false;
		for (int i = 0; i < 20; i++){
			Car car = new Car(random(1000, 9999));
			int parkingPlace = random(0, 10);
			if (i == 0) {
				num1 = car.getNumberCar();
				pP1 = parkingPlace;
			}
			System.out.println("Car " + car.getNumberCar() + " is trying to park in place " + parkingPlace);
			if (parking.takeParkingPlace(car, parkingPlace) == true) {
				System.out.println(parking.getNewParkingPlace() + ": " + car.getNumberCar());
				System.out.println("**********");
				if (check){
					check = false;
					num2 = car.getNumberCar();
					pP2 = parking.getNewParkingPlace();
				}
			}
			else {
				if (parking.getWrongParkingPlace() != 0){
					System.out.println("Car  " + car.getNumberCar() + " run away");
					System.out.println("**********");
				}
			}
			if (i == 10) {
				System.out.println("Car " + num2 + " is running away from place " + pP2);
				System.out.println("**********");
				parking.runAway(new Car(num2), pP2);
			}
			check = true;
		}
		Car car = new Car(num1);
		parking.takeParkingPlace(car, pP1);

	}
}
