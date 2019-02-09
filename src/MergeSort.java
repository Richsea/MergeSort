public class MergeSort {
    public MergeSort(){

    }

    public boolean sort(int[] aList){
        if(aList.length <= 1){//리스트 원소개수가 1 이하이면(정렬필요없음)
            return false;
        }
        else{
            int[] aList1 = new int[aList.length/2];
            System.arraycopy(aList, 0, aList1, 0, aList1.length);
            int[] aList2 = new int[aList.length - (aList.length/2)];
            System.arraycopy(aList, aList.length/2, aList2, 0, aList2.length);

            //aList = merge(aList1, aList2);//나눈 배열 병합(conquer)
            System.arraycopy(merge(aList1, aList2), 0, aList, 0, merge(aList1, aList2).length);
            return true;

        }
    }
    //increasingOrder(작은순으로 원소삽입)
    public int[] merge(int[] aList1, int[] aList2){
        int[] mergedList = new int[aList1.length + aList2.length];
        int i = 0, j = 0;
        int mergedIndex = 0;
        while(i < aList1.length || j < aList2.length){
            if(aList1[i] > aList2[j]){
                mergedList[mergedIndex] = aList2[j];
                mergedIndex++;
                j++;
            }
            else{//aList1[i] < aList2[j]
                mergedList[mergedIndex] = aList1[i];
                mergedIndex++;
                i++;
            }
        }

        return mergedList;

    }

}
