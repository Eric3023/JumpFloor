package com.dong.jumpfloor

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //跳台阶问题
        jump.setOnClickListener {
            var intentJump = Intent(this, JumpActivity::class.java)
            startActivity(intentJump)
        }

        //变态跳台阶问题
        jumpBT.setOnClickListener {
            var intentJump = Intent(this, JumpBTActivity::class.java)
            startActivity(intentJump)
        }
    }
}
