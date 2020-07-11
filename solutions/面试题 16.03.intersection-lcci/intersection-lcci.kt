import kotlin.math.abs
import kotlin.math.min
import kotlin.math.max

const val E = 1e-6

fun main() {
    val a = Solution().intersection(intArrayOf(0, 3), intArrayOf(0, 6), intArrayOf(0, 1), intArrayOf(0, 5))
    println(a.contentToString())
}

class Solution {
    fun inLine(x: Double, s: Double, e: Double): Boolean {   // 判断x是否在s->e或e->s之间
        if (abs(x - s) < E || abs(x - e) < E) return true;
        return (x - s > 0 && e - x > 0) || (x - e > 0 && s - x > 0);
    }

    fun intersection(start1: IntArray, end1: IntArray, start2: IntArray, end2: IntArray): DoubleArray {
        //两条直线方程为 a1x+b1y+c1=0,a2x+b2y+c2=0
        val x1 = start1[0];
        val y1 = start1[1];
        val x2 = end1[0];
        val y2 = end1[1];
        val x3 = start2[0];
        val y3 = start2[1];
        val x4 = end2[0];
        val y4 = end2[1];
        val a11 = y2 - y1;
        val a12 = x1 - x2;
        val b1 = x1 * y2 - x2 * y1;
        val a21 = y4 - y3;
        val a22 = x3 - x4;
        val b2 = x3 * y4 - x4 * y3;
        //两条直线的一般式方程
        //a11x+a12y+b1=0
        //a21x+a22y+b2=0
        //联立，求方程组的解
        val D = a11 * a22 - a12 * a21;  //系数矩阵的行列式
        val D1 = b1 * a22 - a12 * b2;   //除掉第一列后的行列式
        val D2 = a11 * b2 - b1 * a21;   //除掉第二列后的行列式
        if (D == 0 && D1 == 0) {
            //无穷多解——共线
            if (min(x3, x4) > max(x1, x2) || min(x1, x2) > max(x3, x4))
                return doubleArrayOf()
            if (min(y3, y4) > max(y1, y2) || min(y1, y2) > max(y3, y4))
                return doubleArrayOf()
            //先按 x 排序，再按 y 排序，找到第二个点，就是交点
            var v = listOf(listOf(x1, y1), listOf(x2, y2), listOf(x3, y3), listOf(x4, y4))
            v = v.sortedBy { it[0] }
            val res = mutableListOf<List<Int>>()
            for(group in v.groupBy { it[0] }){
                res.addAll(group.value.sortedBy { it[1] })
            }
            return doubleArrayOf(res[1][0].toDouble(), res[1][1].toDouble());
        }
        if (D != 0) {
            //有解
            val x0 = D1.toDouble() / D.toDouble();
            val y0 = D2.toDouble() / D.toDouble()
            if (inLine(x0, x1.toDouble(), x2.toDouble()) && inLine(x0, x3.toDouble(), x4.toDouble()) && inLine(
                    y0,
                    y1.toDouble(),
                    y2.toDouble()
                ) && inLine(y0, y3.toDouble(), y4.toDouble())
            ) return doubleArrayOf(x0, y0);
        }
        //无解——平行
        return doubleArrayOf()
    }
}