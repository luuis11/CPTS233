import java.util.Scanner;

public class RoomCarpet {
    public static void main(String[] args) {
        double size, carpetCost;
        RoomDimension rm = new RoomDimension();
        Scanner readme = new Scanner(System.in);

        System.out.println("Enter three numbers..first for length of room..second for room width..third for cost of carpet per square");
        System.out.println("remember press enter when you type each number");

        rm.length = readme.nextDouble();
        rm.width = readme.nextDouble();
        size = rm.getArea(rm.length, rm.width);

        carpetCost = readme.nextDouble();
        System.out.println(getTotalCost(size, carpetCost));


    }
    public static double getTotalCost(double RoomDimension, double cost){
        return RoomDimension*cost;
    }
}
