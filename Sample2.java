//Merge recursively

import java.util.ArrayList;

public class Sample2 {

    public static void main(String[] args) {
        int[] arr1 = {3, 4, 8, 10, 15};
        int[] arr2 = {1, 2, 4, 8};
        ArrayList<Integer> result = new ArrayList<Integer>();
        
        mergeRec(arr1, arr2, result, 0, 0);
        
        for (int num : result)
            System.out.println(num);
    }
    
    public static void mergeRec(int[] A, int[] B, ArrayList<Integer> C, int kA, int kB) {
        if (kA >= A.length && kB >= B.length) return;
        
        if (kA >= A.length) {
            while (kB < B.length) C.add(B[kB++]);
            return;
        }

        if (kB >= B.length) {
            while (kA < A.length) C.add(A[kA++]);
            return;
        }
        
        if (A[kA] < B[kB]) {
            C.add(A[kA++]);
            mergeRec(A, B, C, kA, kB);
        } else if (A[kA] > B[kB]) {
            C.add(B[kB++]);
            mergeRec(A, B, C, kA, kB);
        } else {
            C.add(A[kA++]);
            kB++;
            mergeRec(A, B, C, kA, kB);
        } 
    }
}

