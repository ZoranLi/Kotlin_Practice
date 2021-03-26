package com.example.myapplication.module.login

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.myapplication.R
import com.example.myapplication.base.BaseActivity
import com.example.myapplication.data.LoginResponse
import com.example.myapplication.module.login.inter.LoginPresenter
import com.example.myapplication.module.login.inter.LoginView
import com.example.myapplication.utils.ToastUtils
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : BaseActivity<LoginPresenter>(), View.OnClickListener, LoginView {
//    lateinit var p: LoginPresenter;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        tv_login.setOnClickListener(this)
//        p = LoginPresentImpl(this);
    }

    override fun onClick(view: View?) {
        when (view?.id) {
            R.id.tv_login -> {
//                Toast.makeText(view.context, "登录", Toast.LENGTH_SHORT).show()
                presenter.loginAction(this@LoginActivity, "Derry", "123456");
            }
            else -> {

            }
        }
    }

    //响应的结果
    override fun loginSuccess(loginBean: LoginResponse?) {
        ToastUtils.instance.showToast(this@LoginActivity, "登录成功")
    }

    override fun loginFailure(errorMsg: String?) {
        ToastUtils.instance.showToast(this@LoginActivity, "登录失败")
    }

    override fun createP(): LoginPresenter = LoginPresentImpl(this);

    override fun recycle() {
        presenter.unAttachView();
    }
}