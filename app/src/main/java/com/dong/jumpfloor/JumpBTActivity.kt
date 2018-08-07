package com.dong.jumpfloor

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_jump.*

/**
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。
 * 求该青蛙跳上一个n级的台阶总共有多少种跳法。
 */

class JumpBTActivity : AppCompatActivity() {

    private var array: Array<Int?>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_jump_bt)

        btn.setOnClickListener {
            var content = edit.text.toString()
            var n = content.toInt()

            array = arrayOfNulls(n)

            //递归(n超出一定数量后，无响应)
            jump1.text = "递归推算结果："+jumpFloor1(n)
            Log.i("Dong","递归推算结果："+jumpFloor1(n))
            //备忘录
            jump2.text = "备忘录推算结果："+jumpFloor2(n)
            Log.i("Dong","备忘录推算结果："+jumpFloor2(n))
            //动态规划
            jump3.text = "动态规划推算结果："+jumpFloor3(n)
            Log.i("Dong","动态规划推算结果："+jumpFloor3(n))
        }

    }

    /*
     * 普通递归算法
     */
    private fun jumpFloor1(num:Int):Int{
        return when{
            num < 1 -> 0
            num == 1 -> 1
            num == 2 -> 2
            else -> {
                val result = 1 + (1 until num).sumBy { jumpFloor1(it) }
                result
            }
        }
    }

    /*
     * 备忘录算法(时间复杂度和空间复杂度都是O(N))
     */
    private fun jumpFloor2(num:Int):Int{
        return when {
            num < 1 -> 0
            num == 1 -> 1
            num == 2 -> 2
            else -> {
                var result = array!![num-1]
                if (result != null && result != 0)
                    result
                else {
                    result = 1 + (1 until num).sumBy { jumpFloor1(it) }
                    array!![num-1] = result
                    result
                }
            }
        }
    }

    /*
     * 动态规划算法(时间复杂度O(N)，空间复杂度O(1))
     */
    private fun jumpFloor3(num:Int):Int{
        return when {
            num < 1 -> 0
            num == 1 -> 1
            else -> {
                var a = 1//跳到第一个台阶跳法
                var temp = 0

                for(i in 2..num){
                    temp = a*2
                    a = temp
                }
                return temp
            }
        }
    }
}
