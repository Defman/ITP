import static java.lang.Math.abs;

public class Solver
{   
    int noOfQueens;
    int[] queens;
    int noOfSolutions;
    
    public Solver(int noOfQueens) {
        this.queens = new int[noOfQueens];
        this.noOfQueens = noOfQueens;
        this.noOfSolutions = 0;
    }
    
    public void findAllSolutions() {
        this.noOfSolutions = 0;
        this.positionQueens(0);
        System.out.printf("There is %d solutions\n", noOfSolutions);
    }
    
    public void optimizedFindAllSolutions() {
        this.noOfSolutions = 0;
        int newx = 0;
        for (int y = 0; y < noOfQueens; y++) {
            int x = newx;
            newx = 0;
            for (; x < noOfQueens; x++) {
                if(!(y < noOfQueens) && legal(y, x)) {
                    noOfSolutions++;
                    y -= 2;
                    newx++;
                } else if(legal(y, x)) {
                    queens[y] = x;
                }
            }
        }
        System.out.printf("There is %d solutions\n", noOfSolutions);       
    }
    
    public String repeat(String element, int times) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < times; i++)
            result.append(element);
        return result.toString();
    }
    
    public void positionQueens(int row) {
        if (!(row < noOfQueens)) {
            noOfSolutions++;
            return;
        }
        for (int col = 0; col < noOfQueens; col++)
            if (legal(row, col)) {
                queens[row] = col;
                positionQueens(row + 1);
            }
    }
    
    public boolean legal(int row, int col) {
        for(int i = 0; i < row; i++)
            if (queens[i] == col || abs(i - row) == abs(queens[i] - col))
                return false;
        return true;
    }
    
    public void printSolution() {
    }
    
    public String convert(int row, int col) {
        return String.format("(%s,%d)", (char) ((int) 'a' + row % 26), col);
    }
}
