package october.week4;

public class Day5_ChampagneTower {

    // main idea -
    // starting with first row contains poured wine/champagne
    // if current ith row glass contains contains alcohol >= 1 then
    // it its glass is full ie set to 1 and remaining to equally distributed
    // to its child
    // we do so by traversing each row of glass up till end that is also less than row itself
    public double champagneTower(int poured, int query_row, int query_glass) {
        // so ith row(starting with zero index) has row+1 no of nodes
        // ex query_row=2, then we create arr of size arr[3][3]
        double arr[][] = new double[query_row + 1][query_row + 1];
        arr[0][0] = poured;

        // here we traverse up till query_row - 1 cause last row will either be fully filled
        // or partially, thus rows below query_row - 1 are not needed to be traversed
        for (int i=0; i<query_row; i++) {
            for (int j=0; j<=i; j++) {
                if (arr[i][j] >1) {
                    double of = arr[i][j] - 1.0;
                    arr[i][j] = 1;
                    arr[i+1][j] += of/2.0;
                    arr[i+1][j+1] += of/2.0;
                }
            }
        }
        return Math.min(1, arr[query_row][query_glass]);
    }
}
