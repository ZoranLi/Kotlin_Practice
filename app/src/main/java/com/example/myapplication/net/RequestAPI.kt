package com.example.myapplication.net

object RequestAPI : IRequest {

    /* companion object {
         fun instance
     }*/


    override fun instanceRequestAction(url: String, value: String, resultData: NetWorkResultData) {
        commonOkHttpRequest(url, resultData, value, value);
    }

    fun commonOkHttpRequest(url: String, resultData: NetWorkResultData, vararg value: String) {

    }


}