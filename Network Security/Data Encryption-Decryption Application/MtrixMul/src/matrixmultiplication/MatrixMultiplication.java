
package matrixmultiplication;

public class MatrixMultiplication {

    //initializes variables for dimensions
    public static int M = 3;
    public static int N = 3;
    
    
    public static int [][] A = {{1,4,3}, {2,5,3}, {3,6,3}}; 
    public static int [][] B = {{8,7,6}, {5,4,3},{5,4,3}};    
    public static int [][] C = new int [M][N];
    public static MatrixThread [][] Threads = new MatrixThread[3][3];
    
    public static void main(String[] args) throws InterruptedException {      
        
        for (int i = 0; i<M; i++){
            for (int j=0; j<N; j++){
                Threads[i][j] = new MatrixThread(i,j,A,B,C);
                Threads[i][j].start();
            }
        }
        for (int i = 0; i<M; i++){
            for (int j=0; j<N; j++){
                
                Threads[i][j].join();
            }
        }
        
        //Outputs the Values of Matrix A
        
        System.out.println("Elements of Matrix A:");
        for (int i = 0; i<M; i++){
            for (int j=0; j<N; j++){
                System.out.println("["+i+","+j+"] = "+A[i][j]);
            }
        }  


        //Outputs the Values of Matrix B
        
        System.out.println("Elements of Matrix B:");
        for (int i = 0; i<M; i++){
            for (int j=0; j<N; j++){
                System.out.println("["+i+","+j+"] = "+B[i][j]);
            }
        }  
      //Outputs the Values of Matrix C
        System.out.println("Elements of Matrix C:");
        for (int i = 0; i<M; i++){
            for (int j=0; j<N; j++){
                System.out.println("["+i+","+j+"] = "+C[i][j]);
            }
        }  
    }
}




