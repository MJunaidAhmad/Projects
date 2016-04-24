
package matrixmultiplication;

public class wt extends Thread{
    private int nrow;
    private int ncol;
    private int index;
    private int [][] A;
    private int [][] B;
    private int [][] C;
    
    public wt(int index,int nrow, int ncol, int[][] A,
      int[][] B, int[][] C) {
        this.nrow = nrow;
        this.ncol = ncol;
        this.index = index;
        this.A = A;
        this.B = B;
        this.C = C;
    }
    
    public void run() {
            for(int i=0; i<nrow; i++){

                for(int j=0; j<ncol; j++){

                    C[index][i] += A[index][j] * B[j][i];

                }

            }


    }   
}

          