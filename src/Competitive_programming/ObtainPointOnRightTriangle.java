package Competitive_programming;

/**
 * Given 2 point A(ax, ay) and B(bx, by)
 * A user starts from point A and goes to point b. Then takes a sharp right turn at 90 degrees.
 * Now find first the point which has integer coordinates on the line on which he started.
 * A and B are always different points.
 * * Example: A(-1,3) , B(3,1) => (2,-1)
 */
public class ObtainPointOnRightTriangle {

    public static void main(String[] args) {
        System.out.println(new ObtainPointOnRightTriangle().solution(-1, 3, 3, 1));
    }

    public String solution(int AX, int AY, int BX, int BY) { //-1,3 3,1
        //case 1 : ay < by => left down ; x-- y++
        int PX = BX;
        int PY = BY;
        if (AY < BY) {
            if (AX > BX) {
                // PX++ PY++
                for (int i = 0; i < 100; i++) {
                    if (checkRightTriangle(AX, AY, BX, BY, PX, PY)) {
                        return PX + "," + PY;
                    }
                    PX++;
                    PY++;
                }
            } else if (AX < BX) {
                //X++ Y--
                for (int i = 0; i < 100; i++) {
                    PX++;
                    PY--;
                    if (checkRightTriangle(AX, AY, BX, BY, PX, PY)) {
                        return PX + "," + PY;
                    }
                }
            } else {
                // PX++
                for (int i = 0; i < 100; i++) {
                    if (checkRightTriangle(AX, AY, BX, BY, PX, PY)) {
                        return PX + "," + PY;
                    }
                    PX++;
                }
            }
            for (int i = 0; i < 50; i++) {

            }
        } else if (AY > BY) {
            if (AX < BX) {
                //X-- Y--
                for (int i = 0; i < 100; i++) {
                    PX--;
                    PY = BY;
                    for (int j = 0; j < 100; j++) {
                        PY--;
                        if (checkRightTriangle(AX, AY, BX, BY, PX, PY)) {
                            return PX + "," + PY;
                        }
                    }
                }
            } else if (AX > BX) {
                for (int i = 0; i < 100; i++) {
                    if (checkRightTriangle(AX, AY, BX, BY, PX, PY)) {
                        return PX + "," + PY;
                    }
                    PX++;
                    PY--;
                }
            } else {
                //ax = bx
                for (int i = 0; i < 100; i++) {
                    if (checkRightTriangle(AX, AY, BX, BY, PX, PY)) {
                        return PX + "," + PY;
                    }
                    PX--;
                }
            }
        } else if (AY == BY) {
            if (AX < BX) {
                // Y--
                for (int i = 0; i < 100; i++) {
                    if (checkRightTriangle(AX, AY, BX, BY, PX, PY)) {
                        return PX + "," + PY;
                    }
                    PY--;
                }
            } else if (AX > BX) {
                //Y++
                for (int i = 0; i < 100; i++) {
                    if (checkRightTriangle(AX, AY, BX, BY, PX, PY)) {
                        return PX + "," + PY;
                    }
                    PY++;
                }
            }
        }

        //case 2 : ay = by  ->
        // a: ax < bx => go up or b: ax > bx => go down
        //case 3 : ay > by => right up ; x++ y--
        return "0,0";
    }

    public boolean checkRightTriangle(int AX, int AY, int BX, int BY, int PX, int PY) {
        int distAB = (int) (Math.pow((AX - BX), 2) + Math.pow((AY - BY), 2));
        int distAP = (int) (Math.pow((AX - PX), 2) + Math.pow((AY - PY), 2));
        int distBP = (int) (Math.pow((BX - PX), 2) + Math.pow((BY - PY), 2));
        return distAP == (distAB + distBP);
    }
}
