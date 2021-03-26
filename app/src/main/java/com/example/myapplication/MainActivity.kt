package com.example.myapplication

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import com.example.myapplication.api.WanAPI
import com.example.myapplication.net.APIClient
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.gson.Gson
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.*

//首页
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        tv_login.setOnClickListener {
//            when (it.id) {
//                R.id.tv_login -> {
//                    val wanAPI = APIClient.instance.instanceRetrofit(WanAPI::class.java);
//                    wanAPI.loginAction("derry", "123456")
//                        .subscribeOn(Schedulers.io())
//                        .observeOn(AndroidSchedulers.mainThread())
//                        .subscribe { t ->
//                            Log.e(this@MainActivity.javaClass.name, Gson().toJson(t?.data));
//                            Toast.makeText(this@MainActivity, "登录成功", Toast.LENGTH_SHORT).show()
//                        }
//                }
//                else -> {
//
//                }
//            }
//        }

        val navView: BottomNavigationView = findViewById(R.id.nav_view);
        val appBarConfiguration: AppBarConfiguration = AppBarConfiguration.Builder(
            R.id.navigation_home,
            R.id.navigation_collect,
            R.id.navigation_personal)
            .build()
        val navController: NavController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(navView, navController);
    }
}