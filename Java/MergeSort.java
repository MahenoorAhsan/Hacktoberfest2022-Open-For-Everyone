import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;


//Method 2
public class MergeSort {
    static void MergeSt(int[] arr,int l,int h){
        if(h-l==1)
             return;
        int m=(l+h)/2;
        MergeSt(arr,l,m);
        MergeSt(arr,m,h);
        Mergearr(arr,l,m,h);
    }
    static void Mergearr(int[] arr,int strt,int mid,int end){

        int[] mix=new int[end-strt];
        int i=strt,j=mid,k=0;
        while(i<mid && j<end){
            if(arr[i]<arr[j])
                mix[k]=arr[i++];
            else mix[k]=arr[j++];
            k++;
        }
        while (i<mid){
            mix[k++]=arr[i++];
        }
        while (j<end){
            mix[k++]=arr[j++];
        }
        for(int l=0;l<mix.length;l++){
            arr[strt+l]=mix[l];
        }

    }



// Method 1
    static int[] MSort(int[] arr){
        if(arr.length<2)
            return arr;
        int mid=arr.length/2;
        int[] left= MSort(Arrays.copyOfRange(arr,0,mid));
        int[] right= MSort(Arrays.copyOfRange(arr,mid,arr.length));
        return Merge(left,right);
    }
    static int[] Merge(int[] l,int[] r){
        int[] c=new int[l.length+r.length];
        int i=0;
        int l1=0,r1=0;
        while(l1<l.length && r1<r.length){
            if(l[l1]<r[r1]){
                c[i]=l[l1++];
            }
            else c[i]=r[r1++];
            i++;
        }
        while(l1<l.length){
            c[i++]=l[l1++];
        }
        while (r1<r.length){
            c[i++]=r[r1++];
        }
        return c;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n= sc.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]= sc.nextInt();
        }
        System.out.println("Unsorted array:"+Arrays.toString(arr));
        int[] narr=MSort(arr);
        // method 1
        System.out.println("Sorted array using method 1: "+Arrays.toString(narr));
        // method 2
        MergeSt(arr,0, arr.length);
        System.out.println("Sorted array using method 2: "+Arrays.toString(arr));
    }
}
