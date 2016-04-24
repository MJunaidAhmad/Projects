/* Tacuma Solomon
 * @02580808
 * Operating Systems
 * Lab 2 Part B - Project Multi-threaded Matrix Multiply using 1) Java Threads 
 */
package matrixmultiplication;

public class mm {

    //initializes variables for dimensions
    public static int M = 3;
    
    public static int N = 3;
    
    //Declares Arrays A,B,C, and an Array or WorkerThreads
    public static int [][] A = {{1,4,3}, {2,5,3}, {3,6,3}}; //Initializes A
    public static int [][] B = {{8,7,6}, {5,4,3},{5,4,3}};    //Initializes B
    public static int [][] C = new int [M][N];
    public static wt [] Threads = new wt[M];
    
    
    public static void main(String[] args) throws InterruptedException {      
        //creates 9 Worker threads. Each thread Calculates a Matrix Value and sets it to C matrix
        for (int i = 0; i<M; i++){
            
                Threads[i] = new wt(i,M,N,A,B,C);
                Threads[i].start();
            
        }
        //creates 9 Worker threads. Each thread Calculates a Matrix Value and sets it to C matrix
        for (int i = 0; i<M; i++){
                Threads[i].join();
            
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




