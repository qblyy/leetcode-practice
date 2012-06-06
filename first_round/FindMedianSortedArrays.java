
/**
 * Tricky!!!
 * @author ryan
 *
 */
public class FindMedianSortedArrays {
    public double findMedianSortedArrays(int A[], int B[]) {
        int total = A.length + B.length;
        int excluded = 0;
        int AL = 0, AH = A.length - 1, AMid = -1;
        int BL = 0, BH = B.length - 1, BMid = -1;
        while (excluded < ((total + 1) >> 1)) {
            AMid = AL + (AH - AL + 1) / 2;
            BMid = BL + (BH - BL + 1) / 2;
            if (A[AMid] > B[BMid]) {
            	excluded += ((AH - AMid) + BMid - BL);
            	AH = AMid;
                BL = BMid;
                
            } else if (A[AMid] < B[BMid]) {
                excluded += (AMid - AL + BH - BMid);
                AL = AMid;
                BH = BMid;
            } else {
                return A[AMid];
            }
        }
        return (A[AMid] + B[BMid]) / 2;
    }
}
