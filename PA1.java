import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;


public class PA1 {
    public static void main(String[] args) throws IOException {
        LinkedList<Integer> list = new LinkedList<Integer>();
        LinkedList<Double> list2 = new LinkedList<Double>();
        System.out.println("enter the filename: java");
        System.out.println("time insert: " + TimeInsert(getFileName(),list,list2));
        System.out.println("Max:" + getMax(list));
        System.out.println("Min: " + getMin(list));
        System.out.println("Med: " + getMed(list));
        System.out.println("Max time:" + getMaxTime(list2));
        System.out.println("Min time: " + getMinTime(list2));
        System.out.println("Med time: " + getMedTime(list2));


    }

    public static String getFileName() {
        Scanner input = new Scanner(System.in);
        String fileName = input.next();
        input.close();
        return fileName;
    }

    public static LinkedList<Integer> readAndBLinkedList(String fileName, LinkedList<Integer> list) throws IOException {
        int temp;
        String str;

        BufferedReader input = new BufferedReader(new FileReader(fileName));
        while ((str = input.readLine()) != null) {
            temp = Integer.parseInt(str);
            list.add(temp);
            Collections.sort(list);
        }
        input.close();
        return list;
    }

    public static int getMax(LinkedList<Integer> list) {
        return list.getLast();
    }

    public static int getMin(LinkedList<Integer> list) {
        return list.getFirst();
    }

    public static Double getMed(LinkedList<Integer> list) {
        int mid = list.size() / 2;
        if (list.size() % 2 == 0) {
            int first = list.get(mid - 1);
            int second = list.get(mid);
            return Double.valueOf(first + second) / 2.0;
        }
        return Double.valueOf(list.get(mid));

    }

    public static double TimeInsert(String fileName, LinkedList<Integer> list1, LinkedList<Double> list2)
            throws IOException {
        int temp;
        String str;

       BufferedReader input = new BufferedReader(new FileReader(fileName));
       double num4 = System.currentTimeMillis();
       while((str=input.readLine()) != null) {
           temp = Integer.parseInt(str);
            double num1 = System.currentTimeMillis();
            list1.add(temp);
            double num2 = System.currentTimeMillis();
            double num3= num2 - num1;
            list2.add(num3);
            Collections.sort(list1);
            Collections.sort(list2);
        }
        double num5 = System.currentTimeMillis();
        double num6 = num5-num4;
        input.close();
        return num6;
    }
    public static double getMinTime(LinkedList<Double> list){
        return list.getFirst();
    }
    public static double getMaxTime(LinkedList<Double> list){
        return list.getLast();
    }
    public static double getMedTime(LinkedList<Double> list){
        int mid = list.size() / 2;
        if (list.size() % 2 == 0) {
            double first = list.get(mid - 1);
            double second = list.get(mid);
            return Double.valueOf(first + second) / 2.0;
        }
        return Double.valueOf(list.get(mid));
    }
}
