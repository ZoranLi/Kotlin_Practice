package com.example.myapplication.module.personal

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import com.example.myapplication.R
import com.example.myapplication.base.BaseFragment
import com.example.myapplication.module.collect.interf.CollectView

class PersonalFragment<P> : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root: View = inflater.inflate(R.layout.fragment_personal, container, false)
        return root ?: super.onCreateView(inflater, container, savedInstanceState)
    }

    init {
        setHasOptionsMenu(true)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.personal_menu, menu)
    }

}