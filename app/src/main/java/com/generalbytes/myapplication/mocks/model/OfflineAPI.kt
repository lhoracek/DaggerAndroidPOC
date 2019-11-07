package com.generalbytes.myapplication.mocks.model

import com.generalbytes.myapplication.model.ApiInterface


class OfflineAPI: ApiInterface {
    override fun getData() = "Hi I'm offline fake response"

}