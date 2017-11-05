package PatternRecognition;

import java.text.DecimalFormat;

import static GUI.CreatePanel.myGUI;

public class MatrixCalculate {

    String[][] text = new String[6][6];
    DecimalFormat df = new DecimalFormat("######0.00");
    String tempString;

    //保存从输入框获取的各数值
    public MatrixCalculate(){
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                text[i][j] = myGUI.getTextFromInput()[i][j];
            }
        }
    }

    //计算标称属性相异性矩阵
    private double[][] buildNomimalMatrix()
    {
        double[][] matrix = new double[6][6];

        for (int i = 0; i < 6; i++)
        {
            for (int j = 0; j < 6; j++)
            {
                if (i <= j)
                {
                    matrix[i][j] = 0;
                    tempString = df.format(matrix[i][j]);
                    matrix[i][j] = Double.parseDouble(tempString);
                }
                else
                    if (!text[i][0].equals(text[j][0]))
                    {
                        matrix[i][j] = 1;
                        tempString = df.format(matrix[i][j]);
                        matrix[i][j] = Double.parseDouble(tempString);
                    }
            }
        }
        return matrix;
    }

    //计算二元属性相异性矩阵
    private double[][] buildBinaryMatrix()
    {
        double[][] matrix = new double[6][6];
        int numerator = 0;
        int denominator = 0;

        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {

                numerator = 0;
                denominator = 0;

                if (i <= j)
                {
                    matrix[i][j] = 0;
                    tempString = df.format(matrix[i][j]);
                    matrix[i][j] = Double.parseDouble(tempString);
                }
                else
                {
                    if (!text[i][1].equals(text[j][1]))
                    {
                        numerator++;
                        denominator++;
                    }
                    else if (text[i][1].equals("1") && text[j][1].equals("1"))
                        denominator++;

                    if (!text[i][2].equals(text[j][2]))
                    {
                        numerator++;
                        denominator++;
                    }
                    else if (text[i][2].equals("1") && text[j][2].equals("1"))
                        denominator++;

                    if (!text[i][3].equals(text[j][3]))
                    {
                        numerator++;
                        denominator++;
                    }
                    else if (text[i][3].equals("1") && text[j][3].equals("1"))
                        denominator++;

                    if (denominator != 0)
                    {
                        matrix[i][j] = (double)numerator / denominator;
                        String tempString = df.format(matrix[i][j]);
                        matrix[i][j] = Double.parseDouble(tempString);
                    }

                }
            }
        }
        return matrix;
    }

    //计算序数属性的相异性矩阵
    private double[][] buildOrdinalMatrix()
    {
        double[][] matrix = new double[6][6];
        double[][] map = new double[6][6];

        //先映射
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                if (text[i][j].equals("优秀"))
                    map[i][j] = 1.0;
                else if (text[i][j].equals("良好"))
                    map[i][j] = 0.75;
                else if (text[i][j].equals("合格"))
                    map[i][j] = 0.5;
                else if (text[i][j].equals("不合格"))
                    map[i][j] = 0;
            }
        }

        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                if (i <= j)
                {
                    matrix[i][j] = 0;
                    tempString = df.format(matrix[i][j]);
                    matrix[i][j] = Double.parseDouble(tempString);
                }
                else
                {
                    if (Math.abs(map[i][4]-map[j][4]) == 1.0)
                    {
                        matrix[i][j] = 1.0;
                        tempString = df.format(matrix[i][j]);
                        matrix[i][j] = Double.parseDouble(tempString);
                    }
                    else if (Math.abs(map[i][4]-map[j][4]) == 0.75)
                    {
                        matrix[i][j] = 0.75;
                        tempString = df.format(matrix[i][j]);
                        matrix[i][j] = Double.parseDouble(tempString);
                    }
                    else if (Math.abs(map[i][4]-map[j][4]) == 0.5)
                    {
                        matrix[i][j] = 0.5;
                        tempString = df.format(matrix[i][j]);
                        matrix[i][j] = Double.parseDouble(tempString);
                    }
                    else if (Math.abs(map[i][4]-map[j][4]) == 0.25)
                    {
                        matrix[i][j] = 0.25;
                        tempString = df.format(matrix[i][j]);
                        matrix[i][j] = Double.parseDouble(tempString);
                    }
                    else
                    {
                        matrix[i][j] = 0;
                        tempString = df.format(matrix[i][j]);
                        matrix[i][j] = Double.parseDouble(tempString);
                    }
                }
            }
        }
        return matrix;
    }

//    计算数值属性的相异性矩阵
    private double[][] buildNumeralMatrix()
    {
        double[][] matrix = new double[6][6];
        double[][] map = new double[6][6];

        for (int i = 0; i < 6; i++) {
            map[i][5] = Double.parseDouble(text[i][5]);
            tempString = df.format(matrix[i][5]);
            matrix[i][5] = Double.parseDouble(tempString);
        }

        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                if (i <= j)
                {
                    matrix[i][j] = 0;
                    tempString = df.format(matrix[i][j]);
                    matrix[i][j] = Double.parseDouble(tempString);
                }
                else
                {
                    matrix[i][j] = Math.abs(map[i][5] - map[j][5]);
                    tempString = df.format(matrix[i][j]);
                    matrix[i][j] = Double.parseDouble(tempString);
                }
            }
        }
        return matrix;
    }

    //计算混合类型属性的相异性矩阵
    public double[][] buildMixedMatrix()
    {
        double[][] matrix = new double[6][6];
        String tempString;

        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                matrix[i][j] = (buildNomimalMatrix()[i][j] + buildBinaryMatrix()[i][j]
                        + buildNumeralMatrix()[i][j] + buildOrdinalMatrix()[i][j]) / 4;
                tempString = df.format(matrix[i][j]);
                matrix[i][j] = Double.parseDouble(tempString);
            }
        }
        return matrix;
    }

}
