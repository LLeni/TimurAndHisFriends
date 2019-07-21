import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestVillage {

    @Test
    public void testCalculateLengths(){
        Village village;
        double inputX [][] = {
                {
                    100, 200, 300, 400, 400
                },
                {
                    5, 10, 0
                }
        };
        double inputY [][] = {
                {
                    200, 200, 400, 200, 100
                },
                {
                    -5, -10, 0
                }
        };
        double expectResults[][][] =
                {
                        {
                                {0, 100, 282.84, 300, 316.23},
                                {100, 0, 223.61, 200, 223.61},
                                {282.84, 223.61, 0, 223.61, 316.23,},
                                {300, 200, 223.61, 0, 100},
                                {316.23, 223.61, 316.23, 100, 0}
                        },
                        {
                                {0, 7.07, 7.07},
                                {7.07, 0, 14.14},
                                {7.07, 14.14, 0}
                        }
                };
        for (int i = 0; i < inputX.length; i++) {
            village = new Village(inputX[i].length, inputX[i], inputY[i]);
            double lengths[][] = village.calculateLengths();
            boolean isSame = true;
            for (int l = 0; l < inputX[i].length; l++) {
                for (int c = 0; c < inputX[i].length; c++) {
                    if((Math.round(lengths[l][c]* 100.0) / 100.0) != expectResults[i][l][c] ){
                        isSame = false;
                    }
                }
            }
            Assert.assertEquals("Тест метода calculateLengths прошел неуспешно",true, isSame);
        }
    }

    @Test
    public void testCalculateOstovTree(){
        Village village;
        double inputValues[][][] =
                {
                        {
                                {0, 100, 282.84, 300, 316.23},
                                {100, 0, 223.61, 200, 223.61},
                                {282.84, 223.61, 0, 223.61, 316.23,},
                                {300, 200, 223.61, 0, 100},
                                {316.23, 223.61, 316.23, 100, 0}
                        },
                        {
                                {0, 100.0},
                                {100.0, 0}
                        }
                };
        double expectResults[] = {623.61, 100};

        for (int i = 0; i < inputValues.length; i++) {
            village = new Village(inputValues[i]);
            Assert.assertEquals("Тест метода calculateOstovTree прошел неуспешно", expectResults[i], village.calculateOstovTree(), 1);
        }
    }
}
