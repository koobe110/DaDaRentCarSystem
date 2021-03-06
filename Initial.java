package imooc.src.car.rental;
import java.util.*;
public class Initial {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("欢迎使用答答租车系统：您是否要租车：1是 0否");
		System.out.println("您是否要租车：1是 0否");
		Scanner scan = new Scanner(System.in);
		int useTheSystem = scan.nextInt();
		if (useTheSystem == 1){
			System.out.println("您可选择的车为：");
			Car[] carForRent = {new PassengerCar("福特",  100, 1), new Trunk("长安",  200, 2), new Pickup("五菱",  200, 2 ,3)};
			for (Car car : carForRent){
				if(car instanceof PassengerCar){
                    System.out.println(car.getCarName()+"\t"+car.getRent()+"/天"+"\t"+"载人:"+((PassengerCar)car).getCarCapacity()+"人");
				}
                if(car instanceof Pickup){
                    System.out.println(car.getCarName()+"\t"+car.getRent()+"/天"+"\t"+"载人:"+((Pickup)car).getCarCapacity()+"人"+"\t"+"载货:"+((Pickup)car).getCarCargo()+"吨");
                }
                if(car instanceof Trunk){
                    System.out.println(car.getCarName()+"\t"+car.getRent()+"/天"+"\t"+"载货:"+((Trunk)car).getCarCargo()+"吨");
                }
			}
			System.out.println("请输入您要租汽车的数量：");
			int carQuantity = scan.nextInt();
			Car[] choiceCar = new Car[carQuantity];
			for (int i = 0; i<carQuantity; i++){
				System.out.println("请输入第" + (i+1) + "辆车的序号");
				int carNumber = scan.nextInt();
				choiceCar[i] = carForRent[carNumber-1];
			}
			System.out.println("请输入您要租汽车的天数：");
			int totalDays = scan.nextInt();
			int totalRent = 0;
			int totalCargo = 0;
			int totalCapacity = 0;
			for (Car car : choiceCar){
				if(car instanceof PassengerCar){
					totalCapacity += ((PassengerCar)car).getCarCapacity();
					totalRent += ((PassengerCar)car).getRent();
				}
                if(car instanceof Trunk){
                	totalCargo += ((Trunk)car).getCarCargo();
                	totalRent += ((Trunk)car).getRent();
                }
                if(car instanceof Pickup){
                    totalCargo += ((Pickup)car).getCarCargo();
                    totalCapacity += ((Pickup)car).getCarCapacity();
                    totalRent += ((Pickup)car).getRent();
                }
				
			}
			System.out.println("总载客量："+totalCapacity);
			System.out.println("总载货量："+totalCargo);
			System.out.println("总金额："+totalRent*totalDays);
			
		}
		else if (useTheSystem == 0){
			System.out.println("下次再见");
		}
		else{
			System.out.println("您输入的有误");
		}
		scan.close();

	}

}
