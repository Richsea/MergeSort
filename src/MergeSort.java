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
            sort(aList1);
            int[] aList2 = new int[aList.length - (aList.length/2)];
            System.arraycopy(aList, aList.length/2, aList2, 0, aList2.length);
            sort(aList2);

            //aList = merge(aList1, aList2);//나눈 배열 병합(conquer)
            System.arraycopy(merge(aList1, aList2), 0, aList, 0, merge(aList1, aList2).length);
            return true;

        }
    }
    //increasingOrder(작은순으로 원소삽입)
    //while문 조건 수정 필요
    public int[] merge(int[] aList1, int[] aList2){
        int[] mergedList = new int[aList1.length + aList2.length];
        int i = 0, j = 0;
        int mergedIndex = 0;

        while(i + j < mergedList.length){
            if(i < aList1.length && j < aList2.length) {//aList1과 aList2의 탐색이 둘다 끝나지 않았을때
                if (aList1[i] > aList2[j]) {
                    mergedList[mergedIndex] = aList2[j];
                    mergedIndex++;
                    j++;
                } else {//aList1[i] < aList2[j]
                    mergedList[mergedIndex] = aList1[i];
                    mergedIndex++;
                    i++;
                }
            }
            else if(i >= aList1.length && j < aList2.length){//aList1의 탐색이 끝난경우
                mergedList[mergedIndex] = aList2[j];
                mergedIndex++;
                j++;
            }
            else if(i < aList1.length && j >= aList2.length){//aList2의 탐색이 끝난경우
                mergedList[mergedIndex] = aList1[i];
                mergedIndex++;
                i++;
            }
            //세 가지 경우 이외에는 while문 종료
        }


        return mergedList;


    }

}
