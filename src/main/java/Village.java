import java.util.HashSet;

public class Village {
    private int countHouses;

    private double X[];
    private double Y[];
    private double lengths[][];
    private double valueOstovTree;
    /**
     *
     * @param  countHouses количество домов
     * @param X x координаты домов
     * @param Y y координаты домов
     */
    Village(int countHouses, double X[], double Y[]){
        this.countHouses = countHouses;
        this.X = X;
        this.Y = Y;
        lengths = new double [countHouses] [countHouses];
    }

    //README: необходим для теста. Иначе не знал как поступить.
    Village(double[][] lengths){
        this.lengths = lengths;
    }

    //образуем матрицу весов применяя теорему пифагора
    public double[][] calculateLengths(){
        for (int i = 0; i < countHouses; i++) {
            for (int j = 0; j < countHouses; j++) {
                lengths[i][j] = Math.sqrt(Math.pow(X[i] - X[j], 2) + Math.pow(Y[i] - Y[j], 2));
            }
        }
        return lengths;
    }


    // Находит минимальное количество метров требуемых для соединения всех домов при помощи алгоритма Прима,
    // которое в свою очередь опирается на минимальное основное дерево
    public double calculateOstovTree() {
        HashSet<Integer> vertexes = new HashSet<Integer>();
        double min = 0;
        int nextVertex = 0;
        Double minEdge;

        while(vertexes.size() != lengths[0].length - 1){
            minEdge = null;
            vertexes.add(nextVertex);
            for (Integer vertex :
                    vertexes) {
                for (int i = 0; i < lengths[vertex].length; i++) {
                    if (!vertexes.contains(i)) {
                        if (minEdge == null) { // README: можно улучшить алгоритм убрав это условие. прям 100%, но и так пойдет
                            minEdge = lengths[vertex][i];
                            nextVertex = i;
                        } else {
                            if (minEdge > lengths[vertex][i]) {
                                minEdge = lengths[vertex][i];
                                nextVertex = i;
                            }
                        }
                    }
                }
            }
            min +=  minEdge;
        }

        valueOstovTree = min;
        return min;
    }

    public double getValueOstovTree(){
        return valueOstovTree;
    }

    public double[][] getLengths(){
        return lengths;
    }

}
