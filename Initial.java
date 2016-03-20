package imooc.src.car.rental;
import java.util.*;
public class Initial {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("��ӭʹ�ô���⳵ϵͳ�����Ƿ�Ҫ�⳵��1�� 0��");
		System.out.println("���Ƿ�Ҫ�⳵��1�� 0��");
		Scanner scan = new Scanner(System.in);
		int useTheSystem = scan.nextInt();
		if (useTheSystem == 1){
			System.out.println("����ѡ��ĳ�Ϊ��");
			Car[] carForRent = {new PassengerCar("����",  100, 1), new Trunk("����",  200, 2), new Pickup("����",  200, 2 ,3)};
			for (Car car : carForRent){
				if(car instanceof PassengerCar){
                    System.out.println(car.getCarName()+"\t"+car.getRent()+"/��"+"\t"+"����:"+((PassengerCar)car).getCarCapacity()+"��");
				}
                if(car instanceof Pickup){
                    System.out.println(car.getCarName()+"\t"+car.getRent()+"/��"+"\t"+"����:"+((Pickup)car).getCarCapacity()+"��"+"\t"+"�ػ�:"+((Pickup)car).getCarCargo()+"��");
                }
                if(car instanceof Trunk){
                    System.out.println(car.getCarName()+"\t"+car.getRent()+"/��"+"\t"+"�ػ�:"+((Trunk)car).getCarCargo()+"��");
                }
			}
			System.out.println("��������Ҫ��������������");
			int carQuantity = scan.nextInt();
			Car[] choiceCar = new Car[carQuantity];
			for (int i = 0; i<carQuantity; i++){
				System.out.println("�������" + (i+1) + "���������");
				int carNumber = scan.nextInt();
				choiceCar[i] = carForRent[carNumber-1];
			}
			System.out.println("��������Ҫ��������������");
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
			System.out.println("���ؿ�����"+totalCapacity);
			System.out.println("���ػ�����"+totalCargo);
			System.out.println("�ܽ�"+totalRent*totalDays);
			
		}
		else if (useTheSystem == 0){
			System.out.println("�´��ټ�");
		}
		else{
			System.out.println("�����������");
		}
		scan.close();

	}

}