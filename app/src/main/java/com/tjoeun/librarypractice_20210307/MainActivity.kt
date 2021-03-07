package com.tjoeun.librarypractice_20210307

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.gun0912.tedpermission.PermissionListener
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setUpEvents()
        setValues()

    }

    override fun setUpEvents() {

//        전화걸기 버튼 눌리면 => 권한이 있는지 확인하고 => 실제 전화 걸어보자
        callBtn.setOnClickListener {

//            1. 권한이 있는지 / 거절됬는지에 따르 [행동 방침] (Interface) 변수 생성
//              권한이 있으면 => Uri / ACTION_CALL 등등 내용 실행
//              권한이 없으면 => 토스트로 연결 불가 안내

            val pl = object : PermissionListener {
                override fun onPermissionGranted() {
                    val myUri = Uri.parse("tel:010-2222-3333")
                    val myIntent = Intent(Intent.ACTION_CALL, myUri)
                    startActivity(myIntent)
                }

                override fun onPermissionDenied(deniedPermissions: MutableList<String>?) {
                    Toast.makeText(mContext, "권한이 없어서 전화 연결 불가", Toast.LENGTH_SHORT).show()
                }

            }

//            2. 1에서 만든 [행동 방침]을 가지고 => 실제 권한 확인.


        }

//        이미지뷰를 눌렀을때? => 사진 보기 화면으로 이동
        profileImg.setOnClickListener {

            val myIntent = Intent(mContext, ViewPhotoActivity::class.java)
            startActivity(myIntent)

        }

    }

    override fun setValues() {

    }

}