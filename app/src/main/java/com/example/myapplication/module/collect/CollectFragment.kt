package com.example.myapplication.module.collect

import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.R
import com.example.myapplication.base.BaseFragment
import com.example.myapplication.data.Student
import com.example.myapplication.module.collect.interf.CollectPresenter
import com.example.myapplication.module.collect.interf.CollectView
import kotlinx.android.synthetic.main.fragment_collect.*

/**
 * 收藏中心
 * view 的实现层
 */
class CollectFragment : BaseFragment<CollectPresenter>(), CollectView {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Toast.makeText(activity, "收藏", Toast.LENGTH_SHORT).show()
        val root: View? = inflater.inflate(R.layout.fragment_collect, container, false)// = null;
        return root ?: super.onCreateView(inflater, container, savedInstanceState)
    }

    //类似构造代码块
    init {
        setHasOptionsMenu(true)
    }

    override fun getPresenter(): CollectPresenter = CollectPresenterImpl(this);

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        addData.setOnClickListener {
            val names = arrayOf<String>(
                "乔峰",
                "段誉",
                "虚竹",
                "慕容复",
                "张三",
                "李四",
                "王五",
                "赵六",
                "初七",
                "杜子腾",
                "王小二",
                "李大奇"
            )

            val ages = arrayOf<Int>(
                43,
                24,
                19,
                83,
                64,
                21,
                56,
                32,
                17,
                32,
                45,
                14
            )

            for (index in names.indices) {
                val stu = Student(names[index], ages[index]);
                p.requestInsert(stu);
            }
        }

        clearData.setOnClickListener {
            p.requestDeleteAll();
        }
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.personal_menu, menu)
    }


    override fun createOk() {
        p.requestQueryAll();
    }

    override fun recycle() {
        p.unAttachView();
    }

    override fun showResultSuccess(result: List<Student>?) {
        recyclerView.layoutManager = LinearLayoutManager(activity)
        val adapter = CollectAdapter();
        result?.let { adapter.allStudents = result; }
        recyclerView.adapter = adapter;
    }

    override fun showResult(result: Boolean) {
        result.let {
            p.requestQueryAll()
        }
    }
}