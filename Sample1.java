import java.util.ArrayList;

public class Sample1 {
    public static void main(String[] args) {
        int[] detector1 = {14, 2, 8, 12, 5};
        int[] detector2 = {18, 1, 15, 3, 10, 11};

        System.out.println("Original Data:");
        System.out.print("Detector 1: ");
        displayArrNoBracket(detector1); System.out.println();
        
        System.out.print("Detector 2: ");
        displayArrNoBracket(detector2); System.out.println();
        
        System.out.println();

        insertionSort(detector1);
        selectionSort(detector2);

        System.out.println("Sorted Data:");
        System.out.print("Detector 1 (Insertion Sort): ");
        displayArrNoBracket(detector1); System.out.println();
        
        System.out.print("Detector 2 (Selection Sort): ");
        displayArrNoBracket(detector2);System.out.println("\n\n");

        ArrayList<Integer> mergedArr = merge(detector1, detector2);
        System.out.println("\nMerged Data:");
        System.out.print("Combined Measurements: ");
        displayArrListNoBracket(mergedArr); System.out.println();
    }
    
    public static void displayArr(int[] arr) {
        System.out.print("[");
        for (int num = 0; num<arr.length; num++) {
            System.out.print(arr[num]);
            if (num<arr.length-1) System.out.print(", ");
            else System.out.print("]");
        }
    }
    
    public static void displayArrNoBracket(int[] arr) {
        for (int num = 0; num<arr.length; num++) {
            System.out.print(arr[num]);
            if (num<arr.length-1) System.out.print(", ");
            else System.out.print("");
        }
    }

    public static void displayArrList(ArrayList<Integer> arr) {
        System.out.print("[");
        for (int num = 0; num<arr.size(); num++) {
            System.out.print(arr.get(num));
            if (num<arr.size()-1) System.out.print(", ");
            else System.out.print("]");
        }
    }

    public static void displayArrListNoBracket(ArrayList<Integer> arr) {
        for (int num = 0; num<arr.size(); num++) {
            System.out.print(arr.get(num));
            if (num<arr.size()-1) System.out.print(", ");
            else System.out.print("");
        }
    }

    private static void insert(int[] arr, int i) {
        int key = arr[i];
        int j;
        for (j = i - 1; j >= 0 && arr[j] > key; j--) {
            arr[j+1] = arr[j];
        }
        arr[j+1] = key;

    }

    public static void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            System.out.printf("Pass %d: ", i);
            displayArr(arr);
            System.out.print(" -> ");          
            insert(arr, i);
            displayArr(arr); System.out.println();
        }
        System.out.print("Final:  ");
        displayArr(arr); System.out.println();
        System.out.println();
    }

    public static void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            System.out.printf("Pass %d: ", i+1);
            displayArr(arr);
            System.out.print(" -> ");
            int toIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[toIndex]) toIndex=j;
            }
            int temp = arr[toIndex];
            arr[toIndex] = arr[i];
            arr[i] = temp;
            displayArr(arr); System.out.println();
        }
        System.out.print("Final:  ");
        displayArr(arr); System.out.println();
        System.out.println();
    }

    public static ArrayList<Integer> merge(int[] arr1, int[] arr2) {
        System.out.println("Merging Process:");

        ArrayList<Integer> newArr = new ArrayList<Integer>();
        int indexOfArr1 = 0;
        int indexOfArr2 = 0;
        int count = 1;

        while (indexOfArr1<arr1.length && indexOfArr2<arr2.length) {
            if (arr1[indexOfArr1] < arr2[indexOfArr2]) {
                System.out.printf("Step %d: Compare %d and %d -> ", count, arr1[indexOfArr1], arr2[indexOfArr2]);
                newArr.add(arr1[indexOfArr1++]);
                displayArrList(newArr); System.out.println();
                count++;
            }else if (arr2[indexOfArr2] < arr1[indexOfArr1]) {
                System.out.printf("Step %d: Compare %d and %d -> ", count, arr1[indexOfArr1], arr2[indexOfArr2]);
                newArr.add(arr2[indexOfArr2++]);
                displayArrList(newArr); System.out.println();
                count++;
            }else {
                System.out.printf("Step %d: Compare %d and %d -> ", count, arr1[indexOfArr1], arr2[indexOfArr2]);
                newArr.add(arr1[indexOfArr1++]);
                indexOfArr2++;
                displayArrList(newArr); System.out.println();
                count++;
            }
        }
        while (indexOfArr1 >= arr1.length) newArr.add(arr2[indexOfArr2++]);
        
        while (indexOfArr2 >= arr2.length) newArr.add(arr1[indexOfArr1++]);
            
        System.out.printf("Step %d: Add remaining -> ", count);
        displayArrList(newArr); System.out.println();

        return newArr;
    }
}
